package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.App;
import spring.spot.trial.Entity.Approval;
import spring.spot.trial.Repository.ApprovalRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ApprovalService {
    @Autowired
    ApprovalRepository approvalRepository;

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
        return  approvalRepository.findByManagerId(headId);
    }

}