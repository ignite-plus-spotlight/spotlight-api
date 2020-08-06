package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.TeamAwardsMD;
import spring.spot.trial.Repository.TeamAwardsRepository;

import java.util.List;

@Service
public class TeamAwardsService {
    @Autowired
    TeamAwardsRepository teamAwardsRepository;

    public TeamAwardsService(TeamAwardsRepository teamAwardsRepository) {
        this.teamAwardsRepository = teamAwardsRepository;
    }

    public TeamAwardsMD createTeamAwards(TeamAwardsMD team) {
        return teamAwardsRepository.save(team);
    }

    public List<TeamAwardsMD> getAllTeamAwards() {
        return teamAwardsRepository.findAll();
    }

    public List<TeamAwardsMD> getTeamAwardsById(String id) {
        return teamAwardsRepository.findByManagerId(id);
    }

    //public List<TeamAwardsMD> getTeamAwardsByTeamId(int id) { return teamAwardsRepository.findByTeamId(id); }

    public TeamAwardsMD updateTeamAwardsById(String id, TeamAwardsMD teamAwardsMD) { return teamAwardsRepository.save(teamAwardsMD); }

}
