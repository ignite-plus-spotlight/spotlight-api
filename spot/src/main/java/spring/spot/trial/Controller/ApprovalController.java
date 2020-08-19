package spring.spot.trial.Controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.Approval;
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

    @GetMapping("/approvals//headId/{headId}")
    public Approval getApprovalByIdAndHeadId(@PathVariable("headId")String headId){
        return approvalService.getApprovalByIdAndHeadId(headId);
    }

    @PostMapping("/approvals")
    public Approval createApprovals(@RequestBody Approval approval){
        return approvalService.createApproval(approval);
    }
}
