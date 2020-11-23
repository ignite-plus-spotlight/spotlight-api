package spring.spot.trial.Controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.Approval;
import spring.spot.trial.Entity.EmployeeAwardsTM;
import spring.spot.trial.Service.ApprovalService;

import java.util.List;

@Data
@RestController
@RequestMapping
@CrossOrigin("*")
public class ApprovalController {

    @Autowired
    ApprovalService approvalService;

    public ApprovalController(ApprovalService approvalService){
        this.approvalService = approvalService;
    }

    @GetMapping("/approvals")
    public List<Approval> getAllApprovals() {
        return approvalService.getAllApprovals();
    }

    //history of approved nominations based on headId'
    @GetMapping("/approvalList/{headId}")
    public List<Approval> getApprovalByIdAndHeadId(@PathVariable("headId")String headId){
        return approvalService.getApprovalByHeadId(headId);
    }

    //VP views the filtered list of nominations passed through director
    @GetMapping("/vpsApprovalList/{yourId}")
    public List<Approval> findByVpId(@PathVariable("yourId") String id)
    {
        return approvalService.findByVPId(id);
    }

//    @PostMapping("/approvals")
//    public Approval createApprovals(@RequestBody Approval approval){
//        return approvalService.createApproval(approval);
//    }

    //final approval of VP that results in an award
    @PostMapping("award/{yourId}")
    public EmployeeAwardsTM award(@RequestBody Approval approval,@PathVariable("yourId") String id) { return approvalService.VpAward(approval,id);}
}
