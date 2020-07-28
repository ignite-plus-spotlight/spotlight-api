package spring.spot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.Entity.TeamAwards;
import spring.spot.Key.TeamAwardsKey;
import spring.spot.Repository.TeamAwardsRepository;

import java.util.List;


@Service
public class TeamAwardsService {


    @Autowired
    private TeamAwardsRepository teamAwardsRepository;

    public TeamAwardsService(TeamAwardsRepository teamAwardsRepository) {
        this.teamAwardsRepository = teamAwardsRepository;
    }


    public TeamAwards createTeamAwards(TeamAwards teamawards) {
        return teamAwardsRepository.save(teamawards);
    }


    public List<TeamAwards> getAllTeamAwards() {
        return teamAwardsRepository.findAll();
    }

    public List<TeamAwards> getTeamAwardsById(int id) {
        return teamAwardsRepository.findByTeamAwardsKeyTeamId(id);
    }

    public TeamAwards findByTeamAwardsKeyPeriodName(int id, String periodName) {
        return teamAwardsRepository.findByTeamAwardsKeyTeamIdAndTeamAwardsKeyPeriodName(id, periodName);
    }

    public TeamAwards updateTeamAwardsById(int id, TeamAwards teamawards) {
        return teamAwardsRepository.save(teamawards);
    }

}

