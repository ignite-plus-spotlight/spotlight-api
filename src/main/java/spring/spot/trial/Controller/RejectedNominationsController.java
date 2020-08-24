package spring.spot.trial.Controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.RejectedNominations;
import spring.spot.trial.Service.NominationsService;
import spring.spot.trial.Service.RejectedNominationsService;
import spring.spot.trial.dto.NominationsApprovalDTO;

import java.util.List;

@Data
@RequestMapping
@RestController
@CrossOrigin("*")
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


    @PostMapping("/rejections/{yourId}")
    public RejectedNominations createRejection(@PathVariable("yourId")String rejectedById,@RequestBody NominationsApprovalDTO nominationsApprovalDTO){
        return nominationsService.initialReject(nominationsApprovalDTO,rejectedById);
    }
}