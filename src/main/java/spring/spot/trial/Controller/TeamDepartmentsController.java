package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.TeamDepartments;
import spring.spot.trial.Service.TeamDepartmentsService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping
public class TeamDepartmentsController {
    @Autowired
    TeamDepartmentsService teamDepartmentsService;

    public TeamDepartmentsController(TeamDepartmentsService teamDepartmentsService) {
        this.teamDepartmentsService = teamDepartmentsService;
    }

    @GetMapping("/departments")
    public List<TeamDepartments> getAllTeamDepartment() {
        return (List<TeamDepartments>) teamDepartmentsService.getAllTeamDepartments();
    }

    @GetMapping(value = "{dept}/departments")
    public List<TeamDepartments> getTeamDepartmentsByName(@PathVariable("dept") String dept) {
        return teamDepartmentsService.getTeamDepartmentsByName(dept);
    }

    @PostMapping("/departments")
    public TeamDepartments createTeamDepartments(@RequestBody TeamDepartments teamDepartments) {
        return teamDepartmentsService.createTeamDepartments(teamDepartments);
    }

    @PutMapping(value = "/departments/{dept}")
    public TeamDepartments UpdateTeamDepartmentsById(@PathVariable("dept") String dept, @RequestBody TeamDepartments teamDepartments) {
        return teamDepartmentsService.updateTeamDepartmentsByName(dept, teamDepartments);
    }

}
