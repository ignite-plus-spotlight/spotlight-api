package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.AwardToTeam;
import spring.spot.trial.Service.AwardToTeamService;

import java.util.List;

/*Give away an award to team*/

@CrossOrigin("*")
@RestController
@RequestMapping
@ResponseBody

public class AwardToTeamController {
    @Autowired
    AwardToTeamService awardToTeamService;

    public AwardToTeamController(AwardToTeamService awardToTeamService) {
        this.awardToTeamService = awardToTeamService;
    }

    @GetMapping("/team/teamawards")
    public List<AwardToTeam> getAllAwards() {
        return (List<AwardToTeam>) awardToTeamService.getAllAwards();
    }

    @GetMapping(value = "/team/{name}/teamawards")
    public List<AwardToTeam> getAwardsByDepartment(@PathVariable("name") String Department) {
        return awardToTeamService.getAwardsByDepartment(Department);
    }

    @PostMapping("/team/teamawards")
    public AwardToTeam createAwards(@RequestBody AwardToTeam awardToTeam) {
        return awardToTeamService.createAwards(awardToTeam);
    }
}
