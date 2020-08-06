package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.TeamAwardsMD;
import spring.spot.trial.Service.TeamAwardsService;

import java.util.List;

@CrossOrigin("*")
@RequestMapping
@RestController
public class TeamAwardsController {
    @Autowired
    TeamAwardsService teamAwardsService;

    public TeamAwardsController(TeamAwardsService teamAwardsService) {
        this.teamAwardsService = teamAwardsService;
    }


    @GetMapping("/teamawards")
    public List<TeamAwardsMD> getAllTeamAwards() {
        return (List<TeamAwardsMD>) teamAwardsService.getAllTeamAwards();
    }

    @GetMapping(value = "/teamawards/{id}")
    public List<TeamAwardsMD> getTeamAwardsById(@PathVariable("id") String id) {
        return teamAwardsService.getTeamAwardsById(id);
    }

/*    @GetMapping(value = "/teamawards/{id}")
    public List<TeamAwardsMD> getTeamAwardsByTeamId(@PathVariable("id") int id) {
        return teamAwardsService.getTeamAwardsByTeamId(id);
    }*/


    @PostMapping("/teamawards")
    public TeamAwardsMD createTeamAwards(@RequestBody TeamAwardsMD team) {
        return teamAwardsService.createTeamAwards(team);
    }

    @PutMapping(value = "/teamawards/{id}")
    public TeamAwardsMD UpdateTeamAwardsById(@PathVariable("id") String id, @RequestBody TeamAwardsMD teamAwardsMD) {
        return teamAwardsService.updateTeamAwardsById(id, teamAwardsMD);
    }

}
