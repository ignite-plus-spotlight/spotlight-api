package spring.spot.trial.dto;

import lombok.Data;
import spring.spot.trial.Entity.Employee;

import java.util.List;
@Data
//members of each team
//used in ManagerDTO
public class TeamDTO {

    private String teamName;
    private int teamId;
    private String headName;
    private List<Employee> teamMembers;

    public List<Employee> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Employee> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }



    @Override
    public String toString() {
        return "TeamDTO{" +
                "teamName='" + teamName + '\'' +
                ", employeeId=" + teamId +
                '}';
    }
}
