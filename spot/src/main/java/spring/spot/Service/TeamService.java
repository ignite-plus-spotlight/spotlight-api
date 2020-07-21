package spring.spot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.Entity.Team;
import spring.spot.Exception.TeamException;
import spring.spot.Repository.TeamRepository;


import java.util.List;
import java.util.Optional;

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

    public Team getTeamById(int id) {
        Optional<Team> optionalTeam = teamRepository.findById(id);
        if (!optionalTeam.isPresent())
            throw new TeamException("No such team found");
        return teamRepository.findById(id).get();
    }


    public Team updateTeamById(int id, Team team) {
        Optional<Team> optionalTeam = teamRepository.findById(id);
        if (!optionalTeam.isPresent())
            throw new TeamException("No such team found");
        team.setTeam_id(id);
        return teamRepository.save(team);
    }

    public void deleteTeamById(int id) {
        Optional<Team> optionalTeam = teamRepository.findById(id);
        if (!optionalTeam.isPresent())
            throw new TeamException("No such team found");
        teamRepository.deleteById(id);
    }
}
