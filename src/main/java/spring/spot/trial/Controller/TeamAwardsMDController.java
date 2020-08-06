package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.TeamAwardsMD;
import spring.spot.trial.Service.TeamAwardsMDService;
import spring.spot.trial.dto.ManagerDTO;

import java.util.List;

/*Received team awards that are displayed in the manager dashboard*/

@CrossOrigin("*")
@RequestMapping
@RestController
public class TeamAwardsMDController {
    @Autowired
    TeamAwardsMDService teamAwardsMDService;

    public TeamAwardsMDController(TeamAwardsMDService teamAwardsMDService) {
        this.teamAwardsMDService = teamAwardsMDService;
    }

    @GetMapping("/manager/teamawardsmd")
    public List<TeamAwardsMD> getAllTeamAwards() {
        return (List<TeamAwardsMD>) teamAwardsMDService.getAllTeamAwards();
    }

    @GetMapping(value = "/manager/{id}/teamawardsmd")
    public List<TeamAwardsMD> getTeamAwardsById(@PathVariable("id") String id) {
        return teamAwardsMDService.getTeamAwardsById(id);
    }

    @PostMapping("/manager/teamawardsmd")
    public TeamAwardsMD createTeamAwards(@RequestBody TeamAwardsMD team) {
        return teamAwardsMDService.createTeamAwards(team);
    }

    @PutMapping(value = "/manager/{id}/teamawardsmd")
    public TeamAwardsMD UpdateTeamAwardsById(@PathVariable("id") String id, @RequestBody TeamAwardsMD teamAwardsMD) {
        return teamAwardsMDService.updateTeamAwardsById(id, teamAwardsMD);
    }
/*
    @GetMapping("/manager/{id}/awards")
    public AwardDTO getManagerAwards(@PathVariable("id") String id){
        return teamAwardsMDService.getManagerAwards(id);
    }*/
}
