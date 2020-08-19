package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.*;
import spring.spot.trial.Exception.NotFoundException;
import spring.spot.trial.Repository.*;
import spring.spot.trial.dto.NominationDTO;
import spring.spot.trial.dto.NominationsApprovalDTO;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.UUID.*;

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
        String pollName; String description; LocalDateTime nomStart; LocalDateTime nomEnd; LocalDateTime pollStart; LocalDateTime pollEnd;

        pollName = postIntoMultipleEntity.getPollName();
        description = postIntoMultipleEntity.getDescription();
        pollStart = postIntoMultipleEntity.getPollStart();
        pollEnd = postIntoMultipleEntity.getPollEnd();
        UUID pollId = randomUUID();

        Poll poll = new Poll();
        poll.setPollId(pollId);
        poll.setPollName(pollName);
        poll.setDescription(description);
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
        nominationsRepository.save(nominations);

        NominationsHistory nominationsHistory = new NominationsHistory();
        nominationsHistory.setCreatedDate(createdDate);
        nominationsHistory.setEmployeeId(employeeId);
        nominationsHistory.setManagerId(managerId);
        nominationsHistory.setNominationId(nominationId);
        nominationsHistory.setPollName(pollRepository.findByPollId(pollId).getPollName());
        nominationsHistory.setDescription(description);
        nominationsHistoryRepository.save(nominationsHistory);

        return nominations;
    }

    //post poll id into poll date table
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
                  if (today.compareTo(pollingDate.getPollStartDate()) >= 0 && today.compareTo(pollingDate.getPollEndDate()) <= 0) {
                      NominationsApprovalDTO nominationsApprovalDTO = new NominationsApprovalDTO();
                      nominationsApprovalDTO.setStartDate(pollingDate.getPollStartDate());
                      nominationsApprovalDTO.setEndDate(pollingDate.getPollEndDate());
                      nominationsApprovalDTO.setProcessName(pollingDate.getPollName());
                      nominationsApprovalDTO.setPollId(pollingDate.getPollId());
                      Poll poll = pollRepository.findByPollId(pollingDate.getPollId());
                      nominationsApprovalDTO.setDescription(poll.getDescription());
                      nominationsApprovalDTO.setHeadId(memberId);
                      Nominations nominations = nominationsRepository.findByManagerIdAndPollId(memberId,pollingDate.getPollId());
                      nominationsApprovalDTO.setNominationId(nominations.getNominationId());
                      nominationsApprovalDTO.setNomineeId(nominations.getEmployeeId());
                      nominationsApprovalDTO.setNominee(employeeRepository.findByEmpId(nominations.getEmployeeId()).get(0));
                      nominationsApprovalDTO.setHead(employeeRepository.findByEmpId(memberId).get(0));
                      nominationsApprovalDTOS.add(nominationsApprovalDTO);
                  }
              }
          }
      }
    return nominationsApprovalDTOS;
    }
}
