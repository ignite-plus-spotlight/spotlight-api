package spring.spot.trial.Controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.App;
import spring.spot.trial.Entity.Approval;
import spring.spot.trial.Service.ApprovalService;

import java.util.List;
import java.util.UUID;

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
        return (List<Approval>) approvalService.getAllApprovals();
    }

    /*@GetMapping("/approvals/nominationId/{nominationId}")
    public Approval getApprovalById(@PathVariable("nominationId")UUID nominationId){
        return approvalService.getApprovalById(nominationId);
    }*/

    @GetMapping("/approvals/nominationId/{id}/headId/{headId}")
    public List<Approval> getApprovalByIdAndHeadId(@PathVariable("id")UUID nominationId,@PathVariable("headId")String headId){
        return (List<Approval>) approvalService.getApprovalByIdAndHeadId(nominationId,headId);
    }

    @PostMapping("/approvals")
    public Approval createApprovals(@RequestBody Approval approval){
        return approvalService.createApproval(approval);
    }
}

