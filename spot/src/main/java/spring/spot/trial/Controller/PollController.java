package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.Poll;
import spring.spot.trial.Service.PollService;

import java.util.List;

@CrossOrigin("*")
@RequestMapping
@RestController
@ResponseBody
public class PollController {
    @Autowired
    PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    @GetMapping("/poll")
    public List<Poll> getAllPolls(){ return pollService.getAllPoll();}

    @GetMapping("/poll/{id}")
    public Poll getPollById(@PathVariable("id") String id){ return pollService.getPollbyId(id);}

    @PostMapping("/poll")
    public Poll createPoll(Poll poll){ return pollService.createPoll(poll);}
}
