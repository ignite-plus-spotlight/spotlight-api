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
    public List<Approval> getALlApprovals() {
        return approvalService.getAllApprovals();
    }

    @GetMapping("/approvalList/{headId}")
    public Approval getApprovalByIdAndHeadId(@PathVariable("headId")String headId){
        return approvalService.getApprovalByIdAndHeadId(headId);
    }

    @GetMapping("/vpsApprovalList/{yourId}")
    public List<Approval> findByVpId(@PathVariable("yourId") String id)
    {
        return approvalService.findByVPId(id);
    }

    @PostMapping("/approvals")
    public Approval createApprovals(@RequestBody Approval approval){
        return approvalService.createApproval(approval);
    }

    @PostMapping("award/{yourId}")
    public EmployeeAwardsTM award(@RequestBody Approval approval,@PathVariable("yourId") String id) { return approvalService.VpAward(approval,id);}
}
