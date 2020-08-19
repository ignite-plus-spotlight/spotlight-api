package spring.spot.trial.Controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.Team;
import spring.spot.trial.Service.TeamService;
import spring.spot.trial.dto.DirectorDTO;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping
@ResponseBody
@Api(tags = "Team Api")
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
    public List<Team> getTeamByHeadId(@PathVariable("id") String id) {
        return teamService.getTeamByHeadId(id);
    }

    @GetMapping(value = "/team/superHead/{id}")
    public DirectorDTO getTeamByDirectorId(@PathVariable("id") String id){
        return teamService.viewVerticalMembers(id);
    }

    @PostMapping("/team")
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }


    @PutMapping(value = "/team/{id}")
    public Team UpdateTeamByManagerId(@PathVariable("id") String id,@Validated @RequestBody Team team) {
        return teamService.updateTeamByHeadId(id,team);
    }

    @PostMapping(value = "/team/{empId}/{headId}/{teamId}")
    public Team updateIntoListOfMembers(@PathVariable("empId") String empId, @PathVariable("headId") String headId, @PathVariable("teamId") int teamId)
    {
        return teamService.updateIntoList(empId,headId,teamId);
    }


    @DeleteMapping(value = "/team/{id}")
    public String deleteTeamById(@PathVariable("id") String id) {
        teamService.deleteTeamById(id);
        return "Team with id " + id + " has been deleted!";
    }
}

