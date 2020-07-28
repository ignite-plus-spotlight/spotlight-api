package spring.spot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.Entity.Roles;
import spring.spot.Service.RolesService;


import java.util.List;

@RestController
public class RolesController {

    @Autowired
    private RolesService rolesService;

    public RolesController(RolesService rolesService) {
        this.rolesService = rolesService;
    }

    @GetMapping("/roles")
    public List<Roles> getAllRoles() {
        return (List<Roles>) rolesService.getAllRoles();
    }


    @GetMapping(value = "/roles/{name}")
    public List<Roles> getRolesById(@PathVariable("name") String name) {
        return rolesService.getRolesByName(name);
    }


    @PostMapping("/roles")
    public Roles createRoles(@RequestBody Roles roles) {
        return rolesService.createRoles(roles);
    }


    @PutMapping(value = "/roles/{name}")
    public Roles UpdateRolesByName(@PathVariable("name") String name, @RequestBody Roles roles) {
        return rolesService.updateRolesByName(name,roles);
    }


}

