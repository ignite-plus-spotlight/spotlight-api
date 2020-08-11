package spring.spot.trial.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.PollStatus;
import spring.spot.trial.Service.PollStatusService;

import java.util.List;

@RequestMapping
@RestController
@ResponseBody
@CrossOrigin("*")
public class PollStatusController {

    @Autowired
    PollStatusService pollStatusService;

    public PollStatusController(PollStatusService pollStatusService){
        this.pollStatusService = pollStatusService;
    }

    @GetMapping("/pollStatus")
    public List<PollStatus> getAllPollStatus(){
        return (List<PollStatus>) pollStatusService.getAllPollStatus();
    }

    @GetMapping("/pollStatus/{id}")
    public List<PollStatus> getAllPollStatus(@PathVariable("id")String pollId){
        return (List<PollStatus>) pollStatusService.getAllByPollId(pollId);
    }
/*
    @GetMapping("/pollStatus/{id}/{nominationId}")
    public List<PollStatus> getAllPollStatus(@PathVariable("id")String pollId,@PathVariable("nominationId")String nominationId){
        return (List<PollStatus>) pollStatusService.getAllByPollIdAndNominationId(pollId,nominationId);
    }*/
    @PostMapping("/pollStatus")
    public PollStatus createPollStatus(@RequestBody PollStatus pollStatus){
        return pollStatusService.createPollStatus(pollStatus);
    }

}
