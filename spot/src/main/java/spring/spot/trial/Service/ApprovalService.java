package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.Approval;
import spring.spot.trial.Entity.Employee;
import spring.spot.trial.Entity.EmployeeAwardsTM;
import spring.spot.trial.Entity.Team;
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

    public ApprovalService(ApprovalRepository approvalRepository){
        this.approvalRepository = approvalRepository;
    }

    public Approval createApproval(Approval approval){
        return approvalRepository.save(approval);
    }

    public List<Approval> getAllApprovals(){
        return (List<Approval>) approvalRepository.findAll();
    }

    public Approval getApprovalByIdAndHeadId(String headId){
        return  approvalRepository.findByApprovedById(headId);
    }

    public List<Approval> findByVPId(String vpId)
    {
        List<Approval> approvals = new ArrayList<>();
        List<Team> teams = teamRepository.findByManagerId(vpId);
        for (Team team : teams)
        {
            List<String> members = team.getMembers();
            for (String memId : members)
            {
               if (approvalRepository.findByApprovedById(memId) != null)
               {
                   Approval approval = approvalRepository.findByApprovedById(memId);
                   approvals.add(approval);
               }
            }
        }
        return approvals;
    }

    public EmployeeAwardsTM VpAward(Approval approval, String vpId)
    {
        EmployeeAwardsTM empaward = new EmployeeAwardsTM();
        empaward.setAwardedById(vpId);
        empaward.setAwardName(pollRepository.findByPollId(approval.getProcessId()).getPollName());
        empaward.setDescription(approval.getDescription());
        empaward.setEmpId(approval.getNominee_id());
        empaward.setManagerName(employeeRepository.findByEmpId(vpId).get(0).getFirstName()+" "+employeeRepository.findByEmpId(vpId).get(0).getLastName());
        empaward.setPeriodName(pollRepository.findByPollId(approval.getProcessId()).getPeriod());
        empaward.setTimestamp(LocalDateTime.now());
        return employeeAwardsTMRepository.save(empaward);
    }

}
