package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.*;
import spring.spot.trial.Repository.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApprovalService {
    @Autowired
    ApprovalRepository approvalRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    PollRepository pollRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeAwardsTMRepository employeeAwardsTMRepository;
    @Autowired
    EmployeeAwardsMRepository employeeAwardsMRepository;
    @Autowired
    RejectedNominationsRepository rejectedNominationsRepository;
    @Autowired
    ActivityFeedRepository activityFeedRepository;

    public ApprovalService(ApprovalRepository approvalRepository){
        this.approvalRepository = approvalRepository;
    }

    public Approval createApproval(Approval approval){
        return approvalRepository.save(approval);
    }

    public List<Approval> getAllApprovals(){
        return (List<Approval>) approvalRepository.findAll();
    }

    public List<Approval> getApprovalByHeadId(String headId){
        return  approvalRepository.findByApprovedById(headId); }

    //VP views filtered list of nominations passed through directors
    public List<Approval> findByVPId(String vpId)
    {
        List<Approval> approvals = new ArrayList<>();
        List<Team> teams = teamRepository.findByManagerId(vpId);
        for (Team team : teams)
        {  int i=0;
            List<String> members = team.getMembers();
            for (String memId : members)
            {
                /* if (!approvalRepository.findByApprovedById(memId).isEmpty() && approvalRepository.findByApprovedById(memId).get(i++) == null )*/
                List<Approval> approvals1 = approvalRepository.findByApprovedById(memId);
                for (Approval approval: approvals1)
                {
                    //check if VP has either rejected or approved the nomination
                    if(employeeAwardsTMRepository.findByEmpIdAndPeriodNameAndAwardedByIdAndAwardName(approval.getNomineeId(),pollRepository.findByPollId(approval.getProcessId()).getPeriod(),memId,pollRepository.findByPollId(approval.getProcessId()).getPollName()) == null && rejectedNominationsRepository.findByRejectedByIdAndProcessIdAndNomineeId(vpId,pollRepository.findByPollId(approval.getProcessId()).getPollId(),approval.getNomineeId()) == null)
                        approvals.add(approval);
                }
            }
        }
        return approvals;
    }

    //VP' final approval that results in award
    public EmployeeAwardsTM VpAward(Approval approval, String vpId)
    {
        EmployeeAwardsTM empaward = new EmployeeAwardsTM();
        empaward.setAwardedById(vpId);
        empaward.setAwardName(pollRepository.findByPollId(approval.getProcessId()).getPollName());
        empaward.setDescription(pollRepository.findByPollId(approval.getProcessId()).getDescription());
        empaward.setEmpId(approval.getNomineeId());
        empaward.setManagerName(employeeRepository.findByEmpId(vpId).get(0).getFirstName()+" "+employeeRepository.findByEmpId(vpId).get(0).getLastName());
        empaward.setPeriodName(pollRepository.findByPollId(approval.getProcessId()).getPeriod());
        empaward.setTimestamp(LocalDateTime.now());
        empaward.setEmpPoints(500);

        EmployeeAwardsMD employeeAwardsMD = new EmployeeAwardsMD();
        employeeAwardsMD.setAwardedById(empaward.getAwardedById());
        employeeAwardsMD.setAwardName(empaward.getAwardName());
        employeeAwardsMD.setDepartment(empaward.getDepartment());
        employeeAwardsMD.setDescription(empaward.getDescription());
        employeeAwardsMD.setEmpId(empaward.getEmpId());
        employeeAwardsMD.setEmpPoints(empaward.getEmpPoints());
        employeeAwardsMD.setImgsrc(empaward.getImgsrc());
        employeeAwardsMD.setManagerName(empaward.getManagerName());
        employeeAwardsMD.setPeriodName(empaward.getPeriodName());
        employeeAwardsMD.setTimestamp(empaward.getTimestamp());
        employeeAwardsMRepository.save(employeeAwardsMD);

        ActivityFeed activityFeed = new ActivityFeed();
        activityFeed.setUuid(approval.getProcessId());
        activityFeed.setTimestamp(employeeAwardsMD.getTimestamp());
        activityFeed.setPoints(employeeAwardsMD.getEmpPoints());
        activityFeed.setLikes(0);
        activityFeed.setImgsrc(employeeAwardsMD.getImgsrc());
        activityFeed.setDescription(employeeAwardsMD.getDescription());
        activityFeed.setAwardName(employeeAwardsMD.getAwardName());
        activityFeed.setAwardeeName(employeeRepository.findByEmpId(employeeAwardsMD.getEmpId()).get(0).getFirstName()+" "+employeeRepository.findByEmpId(employeeAwardsMD.getEmpId()).get(0).getLastName());
        activityFeed.setAwardeeId(employeeAwardsMD.getEmpId());
        activityFeedRepository.save(activityFeed);

        return employeeAwardsTMRepository.save(empaward);
    }

}