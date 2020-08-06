package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.EmployeeAwardsMD;
import spring.spot.trial.Entity.EmployeeAwardsTM;
import spring.spot.trial.Service.EmployeeAwardsService;
import spring.spot.trial.dto.AwardsGivenByManagerDTO;

import java.util.List;

/*Received*/

@CrossOrigin("*")
@RequestMapping
@RestController
@ResponseBody

public class EmployeeAwardsController {
    @Autowired
    EmployeeAwardsService employeeAwardsService;


    public EmployeeAwardsController(EmployeeAwardsService employeeAwardsService) {
        this.employeeAwardsService = employeeAwardsService;
    }

    @GetMapping("/employee/employeeawards")
    public List<EmployeeAwardsTM> getAllEmployeeAwards() {
        return (List<EmployeeAwardsTM>) employeeAwardsService.getAllEmployeeAwards();
    }

    @GetMapping(value = "employee/{id}/employeeawards")
    public List<EmployeeAwardsTM> getEmployeeAwardsById(@PathVariable("id") String id) {
        return employeeAwardsService.getEmployeeAwardsById(id);
    }

    @GetMapping(value = "/manager/{id}/employeeawards")
    public List<EmployeeAwardsMD> getEmployeeAwardsByManagerId(@PathVariable("id") String id) {
        return employeeAwardsService.getEmployeeAwardsMByManagerId(id);
    }

    @GetMapping(value = "/manager/{id}/history/givenawards")
    public AwardsGivenByManagerDTO historyOfGivenAwards(@PathVariable("id") String id)
    {
        return employeeAwardsService.getWinnersUnderManager(id);
    }

    @PostMapping("/employee/employeeawards")
    public EmployeeAwardsTM createEmployeeAwards(@RequestBody EmployeeAwardsTM emp) throws Exception {
        return employeeAwardsService.createEmployeeAwards(emp);
    }

    @PutMapping(value = "employee/{id}/employeeawards")
    public EmployeeAwardsTM UpdateEmployeeAwardsById(@PathVariable("id") String id, @RequestBody EmployeeAwardsTM emp) {
        return employeeAwardsService.updateEmployeeAwardsById(id,emp);
    }
}
