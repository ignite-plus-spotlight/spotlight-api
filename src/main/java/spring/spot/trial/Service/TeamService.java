package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.Employee;
import spring.spot.trial.Entity.Team;
import spring.spot.trial.Exception.MethodArgumentNotValidException;
import spring.spot.trial.Exception.NotFoundException;
import spring.spot.trial.Repository.EmployeeRepository;
import spring.spot.trial.Repository.TeamRepository;
import spring.spot.trial.dto.DirectorDTO;
import spring.spot.trial.dto.HeadDTO;
import spring.spot.trial.dto.TeamDTO;

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
        if(team == null)
            throw new MethodArgumentNotValidException("Error");
        return teamRepository.save(team);
    }


    public List<Team> getAllTeam() {
        return teamRepository.findAll();
    }

    public List<Team> getTeamByHeadId(String id) {
        return teamRepository.findByHeadId(id);
    }


    public Team updateTeamByHeadId(String id, Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeamById(String id) {
        teamRepository.deleteById(id);
    }

    public Team updateIntoList(String empId, String managerId, int teamId){

        List<Employee> employees = employeeRepository.findByEmpId(empId);
        if (employees.isEmpty())
        {
            throw new NotFoundException("No such employee exists");
        }

        Team team = new Team();
        team = teamRepository.findByHeadIdAndTeamId(managerId, teamId);
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

    public DirectorDTO viewVerticalMembers(String directorId)
    {
        DirectorDTO directorDTO = new DirectorDTO();
        directorDTO.setEmployee(employeeRepository.findByEmpId(directorId).get(0));
        List<HeadDTO> managers = new ArrayList<>();
        List<Team> teamList = teamRepository.findByHeadId(directorId);

        for(Team t : teamList) {
            List<String> members = t.getMembers();
            for (String id : members) {

                HeadDTO headDTO = new HeadDTO();
                //Manager Employee Information

                headDTO.setEmployee(employeeRepository.findByEmpId(id).get(0));

                // Manager can have list of Teams

                // Database Team Entity Way
                List<Team> teams = teamRepository.findByHeadId(id);

                // Team DTO initialize
                List<TeamDTO> teamsdto = new ArrayList<>();
                for (Team team : teams) {
                    TeamDTO teamDTO = new TeamDTO();
                    teamDTO.setTeamId(team.getTeamId());
                    teamDTO.setTeamName(team.getTeamName());
                    //validate not null
                    List<Employee> employees = new ArrayList<>();
                    for (String ids : team.getMembers()) {
                        //validation
                        employees.add(employeeRepository.findByEmpId(ids).get(0));
                    }
                    teamDTO.setTeamMembers(employees);
                    teamsdto.add(teamDTO);
                }
                headDTO.setTeams(teamsdto);
                managers.add(headDTO);
            }
        }
        directorDTO.setHeadDTOList(managers);
        return directorDTO;
    }
}

