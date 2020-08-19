package spring.spot.trial.Controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.EmployeeAwardsMD;
import spring.spot.trial.Entity.EmployeeAwardsTM;
import spring.spot.trial.Service.EmployeeAwardsService;
import spring.spot.trial.dto.AwardsGivenByHeadDTO;

import java.util.List;

/*Received*/

@CrossOrigin("*")
@RequestMapping
@RestController
@ResponseBody
@Api(tags = "Employee Awards Api")
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

    //currently not used
    @GetMapping(value = "/head/{id}/employeeawards")
    public List<EmployeeAwardsMD> getEmployeeAwardsByManagerId(@PathVariable("id") String id) {
        return employeeAwardsService.getEmployeeAwardsMByHeadId(id);
    }

    //used in dto,awards given by the manager
    @GetMapping(value = "/head/{id}/history/givenawards")
    public AwardsGivenByHeadDTO historyOfGivenAwards(@PathVariable("id") String id)
    {
        return employeeAwardsService.getWinnersUnderHead(id);
    }

    @PostMapping("/employee/{emp_id}/employeeawards/award/{award_name}/period/{period_name}/department/{department}/head/{headId}")
    public EmployeeAwardsTM createEmployeeAwards(@PathVariable("emp_id") String emp_id ,@PathVariable("award_name") String award_name, @PathVariable("period_name") String period_name , @PathVariable("department") String department, @PathVariable("headId") String headId) throws Exception {
        return employeeAwardsService.createEmployeeAwards(emp_id,headId,award_name,period_name,department);
    }


    @PutMapping(value = "employee/{id}/employeeawards")
    public EmployeeAwardsTM UpdateEmployeeAwardsById(@PathVariable("id") String id, @RequestBody EmployeeAwardsTM emp) {
        return employeeAwardsService.updateEmployeeAwardsById(id,emp);
    }
}

