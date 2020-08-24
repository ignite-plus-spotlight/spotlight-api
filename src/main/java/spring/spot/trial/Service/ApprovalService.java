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

    public ApprovalService(ApprovalRepository approvalRepository){
        this.approvalRepository = approvalRepository;
    }

    public Approval createApproval(Approval approval){
        return approvalRepository.save(approval);
    }

    public List<Approval> getAllApprovals(){
        return (List<Approval>) approvalRepository.findAll();
    }

    public List<Approval> getApprovalByIdAndHeadId(String headId){
        return  approvalRepository.findByApprovedById(headId);
    }

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
        empaward.setDescription(pollRepository.findByPollId(approval.getProcessId()).getDescription());
        empaward.setEmpId(approval.getNomineeId());
        empaward.setManagerName(employeeRepository.findByEmpId(vpId).get(0).getFirstName()+" "+employeeRepository.findByEmpId(vpId).get(0).getLastName());
        empaward.setPeriodName(pollRepository.findByPollId(approval.getProcessId()).getPeriod());
        empaward.setTimestamp(LocalDateTime.now());

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

        return employeeAwardsTMRepository.save(empaward);
    }

}
