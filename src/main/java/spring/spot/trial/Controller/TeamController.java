package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.Team;
import spring.spot.trial.Service.TeamService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping
@ResponseBody

public class TeamController {

    @Autowired
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }


    @GetMapping("/team")
    public List<Team> getAllTeam() {
        return teamService.getAllTeam();
    }


    @GetMapping(value = "/team/{id}")
    public List<Team> getTeamByManagerId(@PathVariable("id") String id) {
        return teamService.getTeamByManagerId(id);
    }


    @PostMapping("/team")
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }


    //adding a member to the team
    @PostMapping(value = "/team/{empId}/{managerId}/{teamId}")
    public Team updateIntoListOfMembers(@PathVariable("empId") String empId, @PathVariable("managerId") String managerId, @PathVariable("teamId") int teamId)
    {
        return teamService.updateIntoList(empId,managerId,teamId);
    }


}

