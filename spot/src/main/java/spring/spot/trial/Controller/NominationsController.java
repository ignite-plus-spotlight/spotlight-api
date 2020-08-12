package spring.spot.trial.Controller;

import jnr.posix.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.Nominate;
import spring.spot.trial.Entity.Nominations;
import spring.spot.trial.Entity.Poll;
import spring.spot.trial.Entity.PostIntoMultipleEntity;
import spring.spot.trial.Service.NominationsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.spot.trial.dto.PollProcessDTO;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RequestMapping
@ResponseBody
@RestController
@CrossOrigin("*")
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

    @GetMapping("/nominations/{id}")
    public List<Nominations> getAllNominations(@PathVariable("id") String id){
        return  nominationsService.getNominationsById(id);
    }

    @GetMapping("/nominations/{id}/{nominationId}")
    public List<Nominations> getAllNominations(@PathVariable("id") String id,@PathVariable("nominationId") String nominationId){
        return nominationsService.getNominationsByPollIdAndNominationId(id,nominationId);
    }
    @PostMapping("/nominations")
    public Nominations createNominations(@RequestBody Nominations nominations){
        return nominationsService.createNominations(nominations);
    }

    @PostMapping("/postmultiple")
    public PostIntoMultipleEntity create(@RequestBody PostIntoMultipleEntity postIntoMultipleEntity)
    {
        return nominationsService.postIntoMultipleTables(postIntoMultipleEntity);
    }

    @GetMapping("/pollprocess/{pollId}")
    public PollProcessDTO pollDisplay(@PathVariable("pollId") String pollId)
    {
       return nominationsService.pollProcess(pollId);
    }

    @PostMapping("/nominate")
    public Nominations nominate(@RequestBody Nominate nominate)
    {
        UUID pollId; String nominationId; String employeeId; String managerId; String description; Date createdDate; String pollName;
        pollId = nominate.getPollId();
        nominationId = nominate.getNominationId();
        employeeId = nominate.getEmployeeId();
        managerId = nominate.getManagerId();
        description = nominate.getDescription();
        createdDate = nominate.getCreatedDate();
        pollName = nominate.getPollName();
        return nominationsService.nominate(pollId,nominationId,employeeId,managerId,description,createdDate,pollName);
    }

}
