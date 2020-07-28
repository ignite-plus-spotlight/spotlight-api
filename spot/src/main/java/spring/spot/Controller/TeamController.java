package spring.spot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.Entity.Team;
import spring.spot.Service.TeamService;


import java.util.List;

@RestController
public class TeamController {

    @Autowired
    private TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }


    @GetMapping("/team")
    public List<Team> getAllTeam() {
        return (List<Team>) teamService.getAllTeam();
    }


    @GetMapping(value = "/team/{id}")
    public List<Team> getTeamById(@PathVariable("id") int id) {
        return teamService.getTeamById(id);
    }


    @PostMapping("/team")
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }


    @PutMapping(value = "/team/{id}")
    public Team UpdateTeamById(@PathVariable("id") int id, @RequestBody Team team) {
        return teamService.updateTeamById(id,team);
    }

}
