package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.Roles;
import spring.spot.trial.Service.RolesService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping
@ResponseBody

public class RolesController {

    @Autowired
    private RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping("/employee/roles")
    public List<Roles> getAllRoles() {

        return (List<Roles>) rolesService.getAllRoles();
    }

    @PostMapping("/employee/roles")
    public Roles createRoles(@RequestBody Roles roles) {

        return rolesService.createRoles(roles);
    }



}