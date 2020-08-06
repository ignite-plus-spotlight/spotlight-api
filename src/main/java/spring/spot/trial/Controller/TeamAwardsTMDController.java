package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.TeamAwardsTMD;
import spring.spot.trial.Service.TeamAwardsTMDService;

import java.util.List;

/*Received team awards that are displayed in the team member dashboard*/

@RestController
@RequestMapping
@CrossOrigin("*")
@ResponseBody

public class TeamAwardsTMDController {
    @Autowired
    TeamAwardsTMDService teamAwardsTMDService;

    public TeamAwardsTMDController(TeamAwardsTMDService teamAwardsTMDService) {
        this.teamAwardsTMDService = teamAwardsTMDService;
    }
    @GetMapping("/teammember/teamawardstmd")
    public List<TeamAwardsTMD> getAllTeamAwards() {
        return (List<TeamAwardsTMD>) teamAwardsTMDService.getAllTeamAwards();
    }

    @GetMapping(value = "/teammember/{id}/teamawardstmd")
    public List<TeamAwardsTMD> getTeamAwardsById(@PathVariable("id") int id) {
        return teamAwardsTMDService.getTeamAwardsById(id);
    }


    @PostMapping("/teammember/teamawardstmd")
    public TeamAwardsTMD createTeamAwards(@RequestBody TeamAwardsTMD team) {
        return teamAwardsTMDService.createTeamAwards(team);
    }

    @PutMapping(value = "/teammember/{id}/teamawardstmd")
    public TeamAwardsTMD UpdateTeamAwardsById(@PathVariable("id") int id, @RequestBody TeamAwardsTMD teamAwardsTMD) {
        return teamAwardsTMDService.updateTeamAwardsById(id, teamAwardsTMD);
    }

}
