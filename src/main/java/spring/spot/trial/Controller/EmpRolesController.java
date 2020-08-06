package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.EmpRoles;
import spring.spot.trial.Service.EmpRolesService;

import java.util.List;

@CrossOrigin("*")
@RequestMapping
@RestController
@ResponseBody

public class EmpRolesController {

    @Autowired
    EmpRolesService empRolesService;

    public EmpRolesController(EmpRolesService empRolesService) {
        this.empRolesService = empRolesService;
    }

    @GetMapping("/employeeroles")
    public List<EmpRoles> getAllEmpRoles() {
        return (List<EmpRoles>) empRolesService.getAllEmpRoles();
    }

    @GetMapping(value = "/{id}/employeeroles")
    public List<EmpRoles> getEmpRolesById(@PathVariable("id") String id) {
        return empRolesService.getEmpRolesById(id);
    }

    @PostMapping("/employeeroles")
    public EmpRoles createEmpRoles(@RequestBody EmpRoles emp) {
        return empRolesService.createEmpRoles(emp);
    }

    @PutMapping(value = "/{id}/employeeroles")
    public EmpRoles UpdateEmpRolesById(@PathVariable("id") String id, @RequestBody EmpRoles empRoles) {
        return empRolesService.updateEmpRolesById(id,empRoles);
    }
}
