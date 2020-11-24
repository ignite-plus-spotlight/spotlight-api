package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.TeamAwardsTMD;
import spring.spot.trial.Service.TeamAwardsTMDService;
import spring.spot.trial.dto.ManagerDTO;

import java.util.List;
import java.util.Date;
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
        return teamAwardsTMDService.getAllTeamAwards();
    }

    @GetMapping(value = "/teammember/{id}/teamawardstmd")
    public List<TeamAwardsTMD> getTeamAwardsById(@PathVariable("id") int id) {
        return teamAwardsTMDService.getTeamAwardsById(id);
    }


    @PostMapping("/teammember/{teamId}/{teamName}/{awardedById}/{periodName}/{awardName}/teamawardstmd")
    public TeamAwardsTMD createTeamAwards(@PathVariable("awardedById") String awardedById, @PathVariable("teamId") int teamId, @PathVariable("awardName") String awardName,@PathVariable("periodName") String periodName, @PathVariable("teamName") String teamName) {
        return teamAwardsTMDService.createTeamAwards(awardName,awardedById,periodName,teamId,teamName);
    }

    @PutMapping(value = "/teammember/{id}/teamawardstmd")
    public TeamAwardsTMD UpdateTeamAwardsById(@PathVariable("id") int id, @RequestBody TeamAwardsTMD teamAwardsTMD) {
        return teamAwardsTMDService.updateTeamAwardsById(id, teamAwardsTMD);
    }

    //for team awards to display one level below
    @GetMapping(value = "/display/{yourid}")
    public ManagerDTO display(@PathVariable("yourid") String id)
    {
        return teamAwardsTMDService.display(id);
    }

}
