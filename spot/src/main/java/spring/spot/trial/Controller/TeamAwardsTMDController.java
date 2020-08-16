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

    //all members
    @GetMapping(value = "/teammember/{managerId}/teamawardstmd")
    public List<TeamAwardsTMD> getTeamAwardsById(@PathVariable("managerId") String id) {
        return teamAwardsTMDService.getTeamAwardsById(id);
    }

    @PostMapping("/teammember/teamawardstmd")
    public TeamAwardsTMD createTeamAwards(@RequestBody TeamAwardsTMD team) {
        return teamAwardsTMDService.createTeamAwards(team);
    }

    //all members
    @PostMapping(value = "/manager/{managerId}/teamawards/team/{teamId}")
    public TeamAwardsTMD UpdateTeamAwardsById(@PathVariable("managerId") String managerId,@PathVariable("teamId") int teamId, @RequestBody TeamAwardsTMD teamAwardsTMD) {
        return teamAwardsTMDService.updateTeamAwardsById(managerId, teamId, teamAwardsTMD);
    }
}
