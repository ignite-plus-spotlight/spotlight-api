package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.TeamAwardsMD;
import spring.spot.trial.Repository.EmployeeRepository;
import spring.spot.trial.Repository.TeamAwardsMDRepository;
import java.util.List;

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

}
