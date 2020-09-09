package spring.spot.trial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.trial.Entity.Employee;
import spring.spot.trial.Exception.InputValidationException;
import spring.spot.trial.Service.EmployeeService;
import spring.spot.trial.dto.HierarchyDTO;
import spring.spot.trial.dto.ManagerDTO;

import java.util.List;

@RequestMapping
@RestController
@CrossOrigin("*")
@ResponseBody

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String helloController() {
        return "Hey the Application is running on port 8081";
    }


    //used in drop down during add members
    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        List<Employee> employees = employeeService.getAllEmployee();
        if(employees.isEmpty())
        throw new InputValidationException("Not found!!");
        return employeeService.getAllEmployee();
    }

    @GetMapping(value = "/employee/{id}")
    public List<Employee> getEmployeeById(@PathVariable("id") String id)  {
        InputValidationException.validateInputParameter(id);
        return employeeService.getEmployeeById(id);
    }

   @GetMapping(value="/employee/{id}/{firstName}")
    public Employee findByKeyFirstName(@PathVariable("id") String id, @PathVariable("firstName") String firstName){
        return employeeService.findByIdAndFirstName(id, firstName);
    }

    //used while adding a member to the team
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee emp) {
        return employeeService.createEmployee(emp);
    }


    @PutMapping(value = "/employee/{id}")
    public Employee UpdateEmployeeById(@PathVariable("id") String id, @RequestBody Employee emp) {
        return employeeService.updateEmployeeById(id,emp);
    }

    //get all the members under the head so as to nominate
    @GetMapping("/manager/{id}")
    public ManagerDTO getManager(@PathVariable("id") String id){
        return employeeService.getManagerDetails(id);
    }

    //get details of all the employees down the hierarchy so as to award
    @GetMapping("levels/{headId}")
    public List<HierarchyDTO> levels(@PathVariable("headId") String headId)
    {
        return employeeService.levels(headId);
    }

}

