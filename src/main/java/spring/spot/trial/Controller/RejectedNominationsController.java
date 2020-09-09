package spring.spot.trial.Controller;

import io.swagger.annotations.Api;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.Approval;
import spring.spot.trial.Entity.RejectedNominations;
import spring.spot.trial.Service.NominationsService;
import spring.spot.trial.Service.RejectedNominationsService;
import spring.spot.trial.dto.NominationsApprovalDTO;

import java.util.List;

@Data
@RequestMapping
@RestController
@CrossOrigin("*")
@Api(tags = "Rejected Nominations")
public class RejectedNominationsController {

    @Autowired
    RejectedNominationsService rejectedNominationsService;

    @Autowired
    NominationsService nominationsService;

    public RejectedNominationsController(RejectedNominationsService rejectedNominationsService){
        this.rejectedNominationsService = rejectedNominationsService;
    }

    @GetMapping("/rejectednominations")
    public List<RejectedNominations> findRejectedNominations(){
        return rejectedNominationsService.findRejectedNominations();
    }

    //history of rejected nominations based on headId'
    @GetMapping("/rejections/{yourId}")
    public List<RejectedNominations> getById(@PathVariable("yourId") String id)
    {
        return rejectedNominationsService.findById(id);
    }

    //director rejects the nomination
    @PostMapping("/rejections/{yourId}")
    public RejectedNominations createRejection(@PathVariable("yourId")String rejectedById,@RequestBody NominationsApprovalDTO nominationsApprovalDTO){
        return nominationsService.initialReject(nominationsApprovalDTO,rejectedById);
    }

    //VP rejects the nominations
    @PostMapping("/vprejections/{yourId}")
    public RejectedNominations createRejection(@PathVariable("yourId")String rejectedById, @RequestBody Approval approval){
        return nominationsService.finalReject(approval,rejectedById);
    }
}