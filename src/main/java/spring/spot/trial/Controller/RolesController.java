package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.Roles;
import spring.spot.trial.Service.RolesService;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping
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


    @GetMapping(value = "/employee/roles/{name}")
    public Roles getRolesById(@PathVariable("name") String name) {
        return rolesService.getRolesByName(name);
    }


    @PostMapping("/employee/roles")
    public Roles createRoles(@RequestBody Roles roles) {

        return rolesService.createRoles(roles);
    }


    @PutMapping(value = "/employee/{name}/roles")
    public Roles UpdateRolesByName(@PathVariable("name") String name, @RequestBody Roles roles) {
        return rolesService.updateRolesByName(name,roles);
    }


    @DeleteMapping(value = "/employee/{name}/roles")
    public String deleteRolesByName(@PathVariable("id") String name) {
        rolesService.deleteRolesByName(name);
        return "Roles with name " + name + " has been deleted!";
    }
}