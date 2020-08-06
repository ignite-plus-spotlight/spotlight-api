package spring.spot.trial.dto;

import spring.spot.trial.Entity.Employee;

import java.util.List;

//members of each team
public class TeamDTO {

    private String teamName;
    private int teamId;
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
                ", teamId=" + teamId +
                '}';
    }
}
