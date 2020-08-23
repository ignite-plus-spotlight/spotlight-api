package spring.spot.trial.dto;

//Employee details of all employees(role=team member) who have received awards/s from a particular manager
import spring.spot.trial.Entity.Employee;
import spring.spot.trial.Entity.EmployeeAwardsTM;

import java.util.List;

public class EmpAwardWinnersUnderManagerDTO {
    private Employee employee;
   List<EmployeeAwardsTM> employeeAwardsTMS;

    @Override
    public String toString() {
        return "EmpAwardWinnersUnderManagerDTO{" +
                "employee=" + employee +
                ", employeeAwardsTMS=" + employeeAwardsTMS +
                '}';
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<EmployeeAwardsTM> getEmployeeAwardsTMS() {
        return employeeAwardsTMS;
    }

    public void setEmployeeAwardsTMS(List<EmployeeAwardsTM> employeeAwardsTMS) {
        this.employeeAwardsTMS = employeeAwardsTMS;
    }
}
