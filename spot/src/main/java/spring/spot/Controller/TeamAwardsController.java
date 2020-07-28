package spring.spot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.Entity.Employee;
import spring.spot.Entity.TeamAwards;
import spring.spot.Key.TeamAwardsKey;
import spring.spot.Service.TeamAwardsService;

import java.util.List;
@RequestMapping
@RestController
public class TeamAwardsController {

    @Autowired
    private TeamAwardsService teamAwardsService;

    public void TeamAwardsService(TeamAwardsService teamAwardsService) {
        this.teamAwardsService = teamAwardsService;
    }

    @GetMapping("/teamawards")
    public List<TeamAwards> getAllTeamAwards() {
        return (List<TeamAwards>) teamAwardsService.getAllTeamAwards();
    }


    @GetMapping(value = "/teamawards/{id}")
    public List<TeamAwards> getTeamAwardsById(@PathVariable("id") int id) {
        return teamAwardsService.getTeamAwardsById(id);
    }

    @GetMapping (value="/teamawards/{id}/{periodName}")
    public TeamAwards findByTeamAwardsKeyPeriodName(@PathVariable("id") int id, @PathVariable("periodName") String periodName){
        return teamAwardsService.findByTeamAwardsKeyPeriodName(id, periodName);
    }


    @PostMapping("/teamawards")
    public TeamAwards createTeamAwards(@RequestBody TeamAwards teamAwards) {
        return teamAwardsService.createTeamAwards(teamAwards);
    }


    @PutMapping(value = "/teamawards/{id}")
    public TeamAwards UpdateTeamAwardsById(@PathVariable("id") int id, @RequestBody TeamAwards teamAwards) {
        return teamAwardsService.updateTeamAwardsById(id,teamAwards);
    }

}
