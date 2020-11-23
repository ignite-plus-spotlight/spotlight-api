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


    @PostMapping("/teammember/{teamId}/{managerId}/{periodName}/{awardName}/{teamPoints}/{teamName}/{description}/{imgsrc}/teamawardstmd")
    public TeamAwardsTMD createTeamAwards(@PathVariable("managerId") String managerId, @PathVariable("teamId") int teamId, @PathVariable("awardName") String awardName, @PathVariable("teamPoints") int teamPoints, @PathVariable("teamName") String teamName, @PathVariable("description") String description, @PathVariable("imgsrc") String imgsrc,@PathVariable("periodName") String periodName) {
        Date d = new Date();
        TeamAwardsTMD team = new TeamAwardsTMD();
        team.setAwardName(awardName);
        team.setDescription(description);
        team.setImgsrc(imgsrc);
        team.setManagerId(managerId);
        team.setPeriodName(periodName);
        team.setTeamId(teamId);
        team.setTeamName(teamName);
        team.setTeamPoints(teamPoints);
        team.setTimestamp(d);
        return teamAwardsTMDService.createTeamAwards(team);
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
