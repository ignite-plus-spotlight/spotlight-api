package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.TeamAwardsTMD;
import spring.spot.trial.Repository.TeamAwardsTMDRepository;
import spring.spot.trial.Repository.TeamRepository;

import java.util.List;

@Service
public class TeamAwardsTMDService {
    @Autowired
    TeamAwardsTMDRepository teamAwardsTMDRepository;

    @Autowired
    TeamRepository teamRepository;

    public TeamAwardsTMDService(TeamAwardsTMDRepository teamAwardsTMDRepository) {
        this.teamAwardsTMDRepository = teamAwardsTMDRepository;
    }
//change...............................................
    public TeamAwardsTMD createTeamAwards(TeamAwardsTMD team) {
        return teamAwardsTMDRepository.save(team);
    }

    public List<TeamAwardsTMD> getAllTeamAwards() {
        return teamAwardsTMDRepository.findAll();
    }

    public List<TeamAwardsTMD> getTeamAwardsById(String id) {
        return teamAwardsTMDRepository.findByEmployeeId(id);
    }

    public TeamAwardsTMD updateTeamAwardsById(String managerId, int teamId, TeamAwardsTMD teamAwardsTMD) {

        return teamAwardsTMDRepository.save(teamAwardsTMD);
    }
}
