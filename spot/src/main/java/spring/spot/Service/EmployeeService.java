package spring.spot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.Entity.Employee;
import spring.spot.Key.EmployeeKey;
import spring.spot.Repository.EmployeeRepository;


import java.util.List;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeeById(int id) {
        return employeeRepository.findByEmployeeKeyEmpId(id);
    }

    public Employee findByKeyFirstName(int id, String firstName) {
        return employeeRepository.findByEmployeeKeyEmpIdAndEmployeeKeyFirstName(id, firstName);
    }

    public Employee updateEmployeeById(int id,Employee employee) {
        return employeeRepository.save(employee);
    }


}
