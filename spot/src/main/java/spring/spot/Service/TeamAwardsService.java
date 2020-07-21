package spring.spot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.Entity.TeamAwards;
import spring.spot.Exception.TeamAwardsException;
import spring.spot.Repository.TeamAwardsRepository;

import java.util.List;
import java.util.Optional;

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

    public TeamAwards getTeamAwardsById(int id) {
        Optional<TeamAwards> optionalTeamAwards = teamAwardsRepository.findById(id);
        if (!optionalTeamAwards.isPresent())
            throw new TeamAwardsException("No such team found");
        return teamAwardsRepository.findById(id).get();
    }

//    public TeamAwards getTeamAwardsByName(String periodname) {
//        Optional<TeamAwards> optionalTeamAwards = teamAwardsRepository.findByName(periodname);
//        if (!optionalTeamAwards.isPresent())
//            throw new TeamAwardsException("No such team found");
//        return teamAwardsRepository.findByName(periodname).get();
//    }

    public TeamAwards updateTeamAwardsById(int id, TeamAwards teamawards) {
        Optional<TeamAwards> optionalTeamAwards = teamAwardsRepository.findById(id);
        if (!optionalTeamAwards.isPresent())
            throw new TeamAwardsException("No such team found");
        teamawards.setTeam_id(id);
        return teamAwardsRepository.save(teamawards);
    }

    public void deleteTeamAwardsById(int id) {
        Optional<TeamAwards> optionalTeamAwards = teamAwardsRepository.findById(id);
        if (!optionalTeamAwards.isPresent())
            throw new TeamAwardsException("No such team found");
        teamAwardsRepository.deleteById(id);
    }
}

