package spring.spot.trial.Controller;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.PollStatus;
import spring.spot.trial.Service.PollStatusService;
import spring.spot.trial.dto.WinnerDTO;

import java.util.List;
import java.util.UUID;

@RequestMapping
@RestController
@ResponseBody
@CrossOrigin("*")
@Api(tags = "Poll status Api")
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
    public List<PollStatus> getAllPollStatus(@PathVariable("id")UUID pollId){
        return (List<PollStatus>) pollStatusService.getAllByPollId(pollId);
    }
    @GetMapping("/pollStatus/{id}/{nominationId}")
    public List<PollStatus> getAllPollStatus(@PathVariable("id")UUID pollId,@PathVariable("nominationId")UUID nominationId){
        return (List<PollStatus>) pollStatusService.getAllByPollIdAndNominationId(pollId,nominationId);
    }
    @PostMapping("/pollStatus")
    public PollStatus createPollStatus(@RequestBody PollStatus pollStatus){
        return pollStatusService.createPollStatus(pollStatus);
    }
    @PostMapping("/castvote/pollid/{pollId}/nominationid{nominationId}")
    public PollStatus increment(@PathVariable("pollId")UUID pollId, @PathVariable("nominationId") UUID nominationId)
    {
        return pollStatusService.increment(pollId, nominationId);
    }

    //get the winner
    @GetMapping("/getwinner/poll/{pollId}")
    public WinnerDTO win(@PathVariable("pollId")UUID pollId){
        return pollStatusService.win(pollId);
    }

}
