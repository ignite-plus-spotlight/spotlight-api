package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.Employee;
import spring.spot.trial.Entity.Team;
import spring.spot.trial.Exception.NotFoundException;
import spring.spot.trial.Repository.EmployeeRepository;
import spring.spot.trial.Repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }


    public List<Team> getAllTeam() {
        return teamRepository.findAll();
    }

    public List<Team> getTeamByManagerId(String id) {
        return teamRepository.findByManagerId(id);
    }

    //update into the list of teams in emp table
    public Team updateIntoList(String empId, String managerId, int teamId){

        List<Employee> employees = employeeRepository.findByEmpId(empId);
        if (employees.isEmpty())
        {
            throw new NotFoundException("No such employee exists");
        }

        Team team = new Team();
        team = teamRepository.findByManagerIdAndTeamId(managerId, teamId);
        List<String> ids = new ArrayList<>();
        ids = team.getMembers();
        ids.add(empId);
        team.setMembers(ids);
        teamRepository.save(team);

       Employee employee = employeeRepository.findByEmpId(empId).get(0);
       List<Integer> teams = employee.getTeamId();
       teams.add(teamId);
       employee.setTeamId(teams);
       employeeRepository.save(employee);

       return teamRepository.save(team);
    }
}
