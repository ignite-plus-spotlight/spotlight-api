package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.*;
import spring.spot.trial.Exception.NotAcceptableException;
import spring.spot.trial.Exception.NotFoundException;
import spring.spot.trial.Repository.*;
import spring.spot.trial.dto.NominationsApprovalDTO;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Service
public class NominationsService {

    @Autowired
    NominationsRepository nominationsRepository;

    @Autowired
    PollRepository pollRepository;

    @Autowired
    NominationDateRepository nominationDateRepository;

    @Autowired
    PollingDateRepository pollingDateRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    NominationsHistoryRepository nominationsHistoryRepository;

    @Autowired
    ApprovalRepository approvalRepository;

    @Autowired
    EmpRolesRepository empRolesRepository;

    @Autowired
    RejectedNominationsRepository rejectedNominationsRepository;


    public NominationsService(NominationsRepository nominationsRepository){
        this.nominationsRepository = nominationsRepository;
    }

    public Nominations createNominations(Nominations nominations){
        return nominationsRepository.save(nominations);
    }

    public List<Nominations> getAllNominations(){
        List<Nominations> nominations = nominationsRepository.findAll();
        if(nominations.isEmpty())
            throw new NotFoundException("No nominations found!");
        return nominations;
    }


    public PostIntoMultipleEntity postIntoMultipleTables(PostIntoMultipleEntity postIntoMultipleEntity )
    {
        String pollName; String description; LocalDateTime pollStart; LocalDateTime pollEnd; String period;

        pollName = postIntoMultipleEntity.getPollName();
        description = postIntoMultipleEntity.getDescription();
        if((postIntoMultipleEntity.getPollStart().compareTo(postIntoMultipleEntity.getPollEnd())==0) || (postIntoMultipleEntity.getPollStart().compareTo(postIntoMultipleEntity.getPollEnd())>0))
            throw new NotAcceptableException("Give a valid dates");
        pollStart = postIntoMultipleEntity.getPollStart();
        pollEnd = postIntoMultipleEntity.getPollEnd();
        period = postIntoMultipleEntity.getPeriod();
        UUID pollId = randomUUID();

        Poll poll = new Poll();
        poll.setPollId(pollId);
        poll.setPollName(pollName);
        poll.setDescription(description);
        poll.setPeriod(period);
        pollRepository.save(poll);

        NominationDate nominationDate = new NominationDate();
        nominationDate.setPollId(pollId);
        nominationDate.setNominationEndDate(pollEnd);
        nominationDate.setNominationStartDate(pollStart);
        nominationDateRepository.save(nominationDate);

        PollingDate pollingDate = new PollingDate();
        pollingDate.setPollName(pollName);
        pollingDate.setPollStartDate(pollStart);
        pollingDate.setPollEndDate(pollEnd);
        pollingDate.setPollId(pollId);
        pollingDateRepository.save(pollingDate);
        return postIntoMultipleEntity;
    }

    //manager nominates
    public Nominations nominate(UUID pollId, String employeeId, String managerId, String description, String pollName)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        LocalDateTime createdDate = LocalDateTime.now();

        UUID nominationId=UUID.randomUUID();

        Nominations nominations = new Nominations();
        nominations.setNominationId(nominationId);
        nominations.setPollId(pollId);
        nominations.setManagerId(managerId);
        nominations.setEmployeeId(employeeId);
        nominations.setDescription(description);
        nominations.setPeriod(pollRepository.findByPollId(pollId).getPeriod());
        nominationsRepository.save(nominations);

        NominationsHistory nominationsHistory = new NominationsHistory();
        nominationsHistory.setCreatedDate(createdDate);
        nominationsHistory.setEmployeeId(employeeId);
        nominationsHistory.setManagerId(managerId);
        nominationsHistory.setNominationId(nominationId);
        nominationsHistory.setPollName(pollRepository.findByPollId(pollId).getPollName());
        nominationsHistory.setDescription(description);
        nominationsHistory.setPeriod(pollRepository.findByPollId(pollId).getPeriod());
        nominationsHistoryRepository.save(nominationsHistory);

         String roleName = empRolesRepository.findByEmpId(managerId).get(0).getRoleName();
        if (roleName.equalsIgnoreCase("director"))
        {
            Approval approval = new Approval();
            approval.setApprovedById(managerId);
            approval.setDescription(nominations.getDescription());
            approval.setDirectorName(employeeRepository.findByEmpId(managerId).get(0).getFirstName()+" "+employeeRepository.findByEmpId(managerId).get(0).getLastName());
            approval.setManagerId(managerId);
            approval.setManagerName(employeeRepository.findByEmpId(managerId).get(0).getFirstName()+" "+employeeRepository.findByEmpId(managerId).get(0).getLastName());
            approval.setNominationId(nominations.getNominationId());
            approval.setNomineeId(nominations.getEmployeeId());
            approval.setNomineeName(employeeRepository.findByEmpId(nominations.getEmployeeId()).get(0).getFirstName()+" "+employeeRepository.findByEmpId(nominations.getEmployeeId()).get(0).getLastName());
            approval.setProcessId(nominations.getPollId());
            approvalRepository.save(approval);
        }

        return nominations;
    }

    public List<NominationsApprovalDTO> approvalAlert(String yourEmpId)
    {
      LocalDateTime today = LocalDateTime.now();
      List<PollingDate> pollingDates = pollingDateRepository.findAll();
      List<NominationsApprovalDTO> nominationsApprovalDTOS = new ArrayList<>();
      for(PollingDate pollingDate : pollingDates)
      {
          List<Team> teams = teamRepository.findByManagerId(yourEmpId);
          for(Team team : teams) {
              List<String> members = team.getMembers();
              for (String memberId : members) {
                  if(nominationsRepository.findByManagerIdAndPollId(memberId,pollingDate.getPollId()) != null)
                    if (today.compareTo(pollingDate.getPollStartDate()) >= 0 && today.compareTo(pollingDate.getPollEndDate()) <= 0) {
                      NominationsApprovalDTO nominationsApprovalDTO = new NominationsApprovalDTO();
                      nominationsApprovalDTO.setStartDate(pollingDate.getPollStartDate());
                      nominationsApprovalDTO.setEndDate(pollingDate.getPollEndDate());
                      nominationsApprovalDTO.setProcessName(pollingDate.getPollName());
                      nominationsApprovalDTO.setPollId(pollingDate.getPollId());
                      Poll poll = pollRepository.findByPollId(pollingDate.getPollId());
                      nominationsApprovalDTO.setPeriod(poll.getPeriod());
                      nominationsApprovalDTO.setHeadId(memberId);
                      Nominations nominations = nominationsRepository.findByManagerIdAndPollId(memberId,pollingDate.getPollId());
                      if(nominations != null) {
                          nominationsApprovalDTO.setNominationId(nominations.getNominationId());
                          nominationsApprovalDTO.setDescription(nominations.getDescription());
                          nominationsApprovalDTO.setNomineeId(nominations.getEmployeeId());
                          nominationsApprovalDTO.setNominee(employeeRepository.findByEmpId(nominations.getEmployeeId()).get(0));
                          nominationsApprovalDTO.setHead(employeeRepository.findByEmpId(memberId).get(0));
                          UUID pId = poll.getPollId();

                          if (approvalRepository.findByApprovedByIdAndProcessIdAndNomineeId(yourEmpId, pId, nominations.getEmployeeId()) == null &&  rejectedNominationsRepository.findByRejectedByIdAndProcessIdAndNomineeId(yourEmpId,pId,nominations.getEmployeeId()) == null)
                              nominationsApprovalDTOS.add(nominationsApprovalDTO);
                      }
                  }
              }
          }
      }
    return nominationsApprovalDTOS;
    }

    public Approval initialApprove(NominationsApprovalDTO nominationsApprovalDTO, String yourId)
    {
        Approval approval = new Approval();
        approval.setApprovedById(yourId);
        approval.setDescription(nominationsApprovalDTO.getDescription());
        approval.setDirectorName(employeeRepository.findByEmpId(yourId).get(0).getFirstName()+" "+employeeRepository.findByEmpId(yourId).get(0).getLastName());
        approval.setEndDate(nominationsApprovalDTO.getEndDate());
        approval.setManagerId(nominationsApprovalDTO.getHeadId());
        approval.setManagerName(employeeRepository.findByEmpId(nominationsApprovalDTO.getHeadId()).get(0).getFirstName()+" "+employeeRepository.findByEmpId(nominationsApprovalDTO.getHeadId()).get(0).getLastName());
        approval.setNominationId(nominationsApprovalDTO.getNominationId());
        approval.setNomineeId(nominationsApprovalDTO.getNomineeId());
        approval.setNomineeName(nominationsApprovalDTO.getNominee().getFirstName()+" "+nominationsApprovalDTO.getNominee().getLastName());
        approval.setProcessId(nominationsApprovalDTO.getPollId());

        return approvalRepository.save(approval);
    }
    public RejectedNominations initialReject(NominationsApprovalDTO nominationsApprovalDTO, String yourId)
    {
        RejectedNominations rejectedNominations = new RejectedNominations();
        rejectedNominations.setRejectedById(yourId);
        rejectedNominations.setDescription(nominationsApprovalDTO.getDescription());
        rejectedNominations.setDirectorName(employeeRepository.findByEmpId(yourId).get(0).getFirstName()+" "+employeeRepository.findByEmpId(yourId).get(0).getLastName());
        rejectedNominations.setEndDate(nominationsApprovalDTO.getEndDate());
        rejectedNominations.setManagerId(nominationsApprovalDTO.getHeadId());
        rejectedNominations.setManagerName(employeeRepository.findByEmpId(nominationsApprovalDTO.getHeadId()).get(0).getFirstName()+" "+employeeRepository.findByEmpId(nominationsApprovalDTO.getHeadId()).get(0).getLastName());
        rejectedNominations.setNominationId(nominationsApprovalDTO.getNominationId());
        rejectedNominations.setNomineeId(nominationsApprovalDTO.getNomineeId());
        rejectedNominations.setNomineeName(nominationsApprovalDTO.getNominee().getFirstName()+" "+nominationsApprovalDTO.getNominee().getLastName());
        rejectedNominations.setProcessId(nominationsApprovalDTO.getPollId());

        return rejectedNominationsRepository.save(rejectedNominations);
    }

    public RejectedNominations finalReject(Approval approval, String yourId)
    {
        RejectedNominations rejectedNominations = new RejectedNominations();
        rejectedNominations.setRejectedById(yourId);
        rejectedNominations.setDescription(approval.getDescription());
        rejectedNominations.setDirectorName(employeeRepository.findByEmpId(yourId).get(0).getFirstName()+" "+employeeRepository.findByEmpId(yourId).get(0).getLastName());
        rejectedNominations.setEndDate(approval.getEndDate());
        rejectedNominations.setManagerId(approval.getManagerId());
        rejectedNominations.setManagerName(employeeRepository.findByEmpId(approval.getManagerId()).get(0).getFirstName()+" "+employeeRepository.findByEmpId(approval.getManagerId()).get(0).getLastName());
        rejectedNominations.setNominationId(approval.getNominationId());
        rejectedNominations.setNomineeId(approval.getNomineeId());
        rejectedNominations.setNomineeName(approval.getNomineeName());
        rejectedNominations.setProcessId(approval.getProcessId());

        return rejectedNominationsRepository.save(rejectedNominations);
    }

}
