package spring.spot.trial.dto;

import spring.spot.trial.Entity.Employee;

import java.util.List;

public class AwardsGivenByManagerDTO {

    private Employee employee;
    private List<EmpAwardWinnersUnderManagerDTO> empAwardWinnersUnderManagerDTOS;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<EmpAwardWinnersUnderManagerDTO> getEmpAwardWinnersUnderManagerDTOS() {
        return empAwardWinnersUnderManagerDTOS;
    }

    public void setEmpAwardWinnersUnderManagerDTOS(List<EmpAwardWinnersUnderManagerDTO> empAwardWinnersUnderManagerDTOS) {
        this.empAwardWinnersUnderManagerDTOS = empAwardWinnersUnderManagerDTOS;
    }

    @Override
    public String toString() {
        return "AwardsGivenByManagerDTO{" +
                "employee=" + employee +
                ", empAwardWinnersUnderManagerDTOS=" + empAwardWinnersUnderManagerDTOS +
                '}';
    }
}
