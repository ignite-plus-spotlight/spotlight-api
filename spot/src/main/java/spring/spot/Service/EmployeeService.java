package spring.spot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.Entity.Employee;
import spring.spot.Exception.EmployeeException;
import spring.spot.Repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee createEmployee(Employee emp) {
        return employeeRepository.save(emp);
    }


    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (!optionalEmployee.isPresent())
            throw new EmployeeException("No such employee found");
        return employeeRepository.findById(id).get();
    }


    public Employee updateEmployeeById(int id, Employee emp) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (!optionalEmployee.isPresent())
            throw new EmployeeException("No such employee found");
        emp.setEmpId(id);
        return employeeRepository.save(emp);
    }

    public void deleteEmployeeById(int id) {
        Optional<Employee> optionalUser = employeeRepository.findById(id);
        if (!optionalUser.isPresent())
            throw new EmployeeException("No such employee found");
        employeeRepository.deleteById(id);
    }
}
