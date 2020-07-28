package spring.spot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.Entity.Team;
import spring.spot.Exception.TeamException;
import spring.spot.Repository.TeamRepository;


import java.util.List;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }


    public List<Team> getAllTeam() {
        return teamRepository.findAll();
    }

    public List<Team> getTeamById(int id) {
        List<Team> optionalTeam = teamRepository.findByTeamKeyTeamId(id);
        if (optionalTeam ==  null)
            throw new TeamException("No such team found");
        return teamRepository.findByTeamKeyTeamId(id);
    }


    public Team updateTeamById(int id, Team team) {
        return teamRepository.save(team);
    }

}
