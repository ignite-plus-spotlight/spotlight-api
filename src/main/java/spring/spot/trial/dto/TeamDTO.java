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
    private String headId;
    private List<Employee> teamMembers;

    public List<Employee> getTeamMembers() {
        return teamMembers;
    }


}
