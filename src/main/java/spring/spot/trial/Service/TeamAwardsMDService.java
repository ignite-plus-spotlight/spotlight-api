package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.TeamAwardsMD;
import spring.spot.trial.Repository.EmployeeRepository;
import spring.spot.trial.Repository.TeamAwardsMDRepository;

import java.util.List;

//import spring.spot.trial.dto.AwardsDTO;

@Service
public class TeamAwardsMDService {
    @Autowired
    TeamAwardsMDRepository teamAwardsMDRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public TeamAwardsMDService(TeamAwardsMDRepository teamAwardsMDRepository) {
        this.teamAwardsMDRepository = teamAwardsMDRepository;
    }

    public TeamAwardsMD createTeamAwards(TeamAwardsMD team) {
        return teamAwardsMDRepository.save(team);
    }

    public List<TeamAwardsMD> getAllTeamAwards() {
        return teamAwardsMDRepository.findAll();
    }

    public List<TeamAwardsMD> getTeamAwardsById(String id) {
        return teamAwardsMDRepository.findByManagerId(id);
    }

    public TeamAwardsMD updateTeamAwardsById(String id, TeamAwardsMD teamAwardsMD) {
        return teamAwardsMDRepository.save(teamAwardsMD);
    }

    /*public AwardsDTO getManagerAwards(String id) {
        AwardsDTO awardDTO = new AwardsDTO();
        //Manager Employee Information
        awardDTO.setEmployee(employeeRepository.findByEmpId(id).get(0));
        // Manager can have list of Teams

        // Database Team Entity Way
        List<Team> teams = teamRepository.findByManagerId(id);


        // Team DTO initialize
        List<TeamDTO> teamsdto = new ArrayList<>();
        for (Team team : teams) {
            TeamDTO teamDTO = new TeamDTO();
            teamDTO.setTeamId(team.getTeamId());
            teamDTO.setTeamName(team.getTeamName());
            //validate not null
            List<Employee> employees = new ArrayList<>();
            for (String ids : team.getMembers()) {
                //validattion
                employees.add(employeeRepository.findByEmpId(ids).get(0));
            }
            teamDTO.setTeamMembers(employees);
            teamsdto.add(teamDTO);
        }
        managerDTO.setTeams(teamsdto);
        return managerDTO;
    }*/
}
