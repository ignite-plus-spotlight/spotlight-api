package spring.spot.trial.dto;

import spring.spot.trial.Entity.Employee;

import java.util.List;

public class AwardsGivenByHeadDTO {

    /*Employee details of manager*/
    private Employee employee;
    /*List of award winner under the manager*/
    private List<EmpAwardWinnersUnderHeadDTO> empAwardWinnersUnderHeadDTOS;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<EmpAwardWinnersUnderHeadDTO> getEmpAwardWinnersUnderHeadDTOS() {
        return empAwardWinnersUnderHeadDTOS;
    }

    public void setEmpAwardWinnersUnderHeadDTOS(List<EmpAwardWinnersUnderHeadDTO> empAwardWinnersUnderHeadDTOS) {
        this.empAwardWinnersUnderHeadDTOS = empAwardWinnersUnderHeadDTOS;
    }

    @Override
    public String toString() {
        return "AwardsGivenByManagerDTO{" +
                "employee=" + employee +
                ", empAwardWinnersUnderHeadDTOS=" + empAwardWinnersUnderHeadDTOS +
                '}';
    }
}
