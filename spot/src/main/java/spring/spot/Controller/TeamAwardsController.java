package spring.spot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.Entity.TeamAwards;
import spring.spot.Service.TeamAwardsService;

import java.util.List;

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
    public TeamAwards getTeamAwardsById(@PathVariable("id") int id) {
        return teamAwardsService.getTeamAwardsById(id);
    }

//    @GetMapping(value = "/teamawards/{periodname")
//    public TeamAwards getTeamAwardsByName(@PathVariable("periodname") String periodname){ return teamAwardsService.getTeamAwardsByName(periodname);}


    @PostMapping("/teamawards")
    public TeamAwards createTeamAwards(@RequestBody TeamAwards teamAwards) {
        return teamAwardsService.createTeamAwards(teamAwards);
    }


    @PutMapping(value = "/teamawards/{id}")
    public TeamAwards UpdateTeamAwardsById(@PathVariable("id") int id, @RequestBody TeamAwards teamAwards) {
        return teamAwardsService.updateTeamAwardsById(id,teamAwards);
    }


    @DeleteMapping(value = "/teamawards/{id}")
    public String deleteTeamAwardsById(@PathVariable("id") int id) {
        teamAwardsService.deleteTeamAwardsById(id);
        return "TeamAward with id " + id + " has been deleted!";
    }
}
