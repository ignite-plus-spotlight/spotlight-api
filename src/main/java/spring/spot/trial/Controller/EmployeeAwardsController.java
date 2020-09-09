package spring.spot.trial.Controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.EmployeeAwardsMD;
import spring.spot.trial.Entity.EmployeeAwardsTM;
import spring.spot.trial.Service.EmployeeAwardsService;
import spring.spot.trial.dto.AwardsGivenByManagerDTO;
import spring.spot.trial.dto.AwardsHistoryDTO;

import java.util.List;

/*Received*/

@CrossOrigin("*")
@RequestMapping
@RestController
@Api(tags = "Employee Awards")

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

    //used in "individual awards" tab to know the awards won by the individual
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

    //used in "reward" tab to display the number of awards already won
    @GetMapping(value = "/employeeawards/count/{empId}/{period}")
    public int countawards(@PathVariable("empId") String empId, @PathVariable("period") String period)
    {
        return employeeAwardsService.countAwards(empId, period);
    }

    //used in "reward" tab to award an individual
    @PostMapping("/employee/{emp_id}/employeeawards/award/{award_name}/period/{period_name}/department/{department}/manager/{manager_id}")
    public EmployeeAwardsTM createEmployeeAwards(@PathVariable("emp_id") String emp_id ,@PathVariable("award_name") String award_name, @PathVariable("period_name") String period_name , @PathVariable("department") String department, @PathVariable("manager_id") String manager_id) throws Exception {
        return employeeAwardsService.createEmployeeAwards(emp_id,manager_id,award_name,period_name,department);
    }

    @PutMapping(value = "employee/{id}/employeeawards")
    public EmployeeAwardsTM UpdateEmployeeAwardsById(@PathVariable("id") String id, @RequestBody EmployeeAwardsTM emp) {
        return employeeAwardsService.updateEmployeeAwardsById(id,emp);
    }

    //head views the history of awards given
    @GetMapping(value = "/awardshistory/{yourId}")
    public List<AwardsHistoryDTO> awardsHistory (@PathVariable("yourId") String id)
    {
        return employeeAwardsService.awardsHistory(id);
    }
}
