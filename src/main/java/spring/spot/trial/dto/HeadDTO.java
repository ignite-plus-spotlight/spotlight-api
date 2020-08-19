package spring.spot.trial.dto;

import spring.spot.trial.Entity.Employee;

import java.util.List;

public class HeadDTO {

    //Manager Employee Details
    private Employee employee;
    //All his team members details
    private List<TeamDTO> teams;

    @Override
    public String toString() {
        return "ManagerDTO{" +
                "employee=" + employee +
                ", teams=" + teams +
                '}';
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<TeamDTO> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamDTO> teams) {
        this.teams = teams;
    }
}
