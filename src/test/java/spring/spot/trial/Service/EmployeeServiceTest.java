package spring.spot.trial.Service;

import javafx.beans.binding.When;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import spring.spot.trial.Entity.Employee;
import spring.spot.trial.Repository.EmployeeRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    EmployeeRepository employeeRepository=mock(EmployeeRepository.class);

    @BeforeEach
    public void beforeEach(){
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    EmployeeService employeeService;

    @Test
    public void createEmployee(){
        Employee employee=new Employee();
        employee.setEmpId("100");
        employee.setDob("12-12-2020");
        employee.setEmpEmail("sree@gmail.com");
        employee.setFirstName("sree");
        employee.setImageUrl("http:");
        employee.setLastName("M");
        employee.setProviderName("google");
        employee.setTimestamp(LocalDateTime.now());

        when(employeeRepository.save(any())).thenReturn(employee);
        Employee response = employeeService.createEmployee(employee);
        assertEquals("sree",employee.getFirstName());

    }

    @Test
    public void getAllEmployees(){
        List<Employee> employees= new ArrayList<>();

        Employee employee1= new Employee();
        employee1.setEmpId("100");
        employee1.setDob("12-12-2020");
        employee1.setEmpEmail("sree@gmail.com");
        employee1.setFirstName("sree");
        employee1.setImageUrl("http:");
        employee1.setLastName("M");
        employee1.setProviderName("google");
        employee1.setTimestamp(LocalDateTime.now());

        Employee employee2=new Employee();
        employee2.setEmpId("200");
        employee2.setDob("12-12-2020");
        employee2.setEmpEmail("a@gmail.com");
        employee2.setFirstName("a");
        employee2.setImageUrl("http:");
        employee2.setLastName("M");
        employee2.setProviderName("google");
        employee2.setTimestamp(LocalDateTime.now());

        employees.add(employee1);
        employees.add(employee2);

        when(employeeRepository.findAll()).thenReturn(employees);
        List<Employee> employee = employeeService.getAllEmployee();
        assertEquals(2,employee.size());

    }

    @Test
    public void findByEmpId(){

        List<Employee> employee=new ArrayList<>();

        Employee employee1= new Employee();
        employee1.setEmpId("100");
        employee1.setDob("12-12-2020");
        employee1.setEmpEmail("sree@gmail.com");
        employee1.setFirstName("sree");
        employee1.setImageUrl("http:");
        employee1.setLastName("M");
        employee1.setProviderName("google");
        employee1.setTimestamp(LocalDateTime.now());

        employee.add(employee1);

        when(employeeRepository.findByEmpId(employee1.getEmpId())).thenReturn(employee);
        List<Employee> response = employeeService.getEmployeeById(employee1.getEmpId());
        assertNotNull(response);
    }
}
