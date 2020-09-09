package spring.spot.trial.Controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.Approval;
import spring.spot.trial.Entity.Nominate;
import spring.spot.trial.Entity.Nominations;
import spring.spot.trial.Entity.PostIntoMultipleEntity;
import spring.spot.trial.Service.NominationsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.spot.trial.dto.NominationsApprovalDTO;

import java.util.List;
import java.util.UUID;


@RequestMapping
@RestController
@CrossOrigin("*")
@Api(tags = "Nominations")
public class NominationsController {
    @Autowired
    NominationsService nominationsService;

    public NominationsController (NominationsService nominationsService){
        this.nominationsService = nominationsService;
    }

    @GetMapping("/nominations")
    public List<Nominations> getAllNominations(){
        return nominationsService.getAllNominations();
    }


    @PostMapping("/nominations")
    public Nominations createNominations(@RequestBody Nominations nominations){
        return nominationsService.createNominations(nominations);
    }


    //admin starts the nominations process
    @PostMapping("/postmultiple")
    public PostIntoMultipleEntity create(@RequestBody PostIntoMultipleEntity postIntoMultipleEntity)
    {
        return nominationsService.postIntoMultipleTables(postIntoMultipleEntity);
    }


    //head nominates his or her immediate reportee
    @PostMapping("/nominate/{pollId}/{employeeId}")
    public Nominations nominate(@RequestBody Nominate nominate,@PathVariable("pollId") UUID pollId,@PathVariable("employeeId") String employeeId)
    {
        UUID nominationId;  String managerId; String description;  String pollName;

        managerId = nominate.getManagerId();
        description = nominate.getDescription();
        pollName = nominate.getPollName();
        return nominationsService.nominate(pollId,employeeId,managerId,description,pollName);
    }

    //director gets the list of nominations done by his or her managers
    @GetMapping("ApproveAlert/{yourId}")
    public List<NominationsApprovalDTO> approve (@PathVariable("yourId") String id)
    {
        return nominationsService.approvalAlert(id);
    }

    //after clicking approve
    @PostMapping("OnclickApprove/{yourId}")
    public Approval approved(@PathVariable("yourId") String id,@RequestBody NominationsApprovalDTO nominationsApprovalDTO)
    {
        return nominationsService.initialApprove(nominationsApprovalDTO, id);
    }
}
