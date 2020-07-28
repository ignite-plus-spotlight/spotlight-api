package spring.spot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.spot.Entity.Employee;
import spring.spot.Key.EmployeeKey;
import spring.spot.Service.EmployeeService;

import java.util.List;
@RequestMapping
@RestController
public class EmployeeController {
    EmployeeKey employeeKey;

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String helloController(){
        return "Hey the Application is running on port 8080";
    }


    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        return (List<Employee>) employeeService.getAllEmployee();
    }


    @GetMapping(value = "/employee/{id}")
    public List<Employee> getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping (value="/employee/{id}/{firstName}")
    public Employee findByKeyFirstName(@PathVariable("id") int id, @PathVariable("firstName") String firstName){
        return employeeService.findByKeyFirstName(id, firstName);
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }


    @PutMapping(value = "/employee/{id}")
    public Employee UpdateEmployeeById(@PathVariable("id") int id, @RequestBody Employee employee) {
        return employeeService.updateEmployeeById(id,employee);
    }
}