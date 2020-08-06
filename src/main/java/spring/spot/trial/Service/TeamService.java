package spring.spot.trial.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.spot.trial.Entity.Team;
import spring.spot.trial.Repository.TeamRepository;

import java.util.ArrayList;
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

    public List<Team> getTeamByManagerId(String id) {
        return teamRepository.findByManagerId(id);
    }


    public Team updateTeamByManagerId(String id, Team team) {
        return teamRepository.save(team);
    }

    public void deleteTeamById(String id) {
        teamRepository.deleteById(id);
    }

    public Team updateIntoList(String empId, String managerId, int teamId){
        Team team = new Team();
        team = teamRepository.findByManagerIdAndTeamId(managerId, teamId);
        List<String> ids = new ArrayList<>();
        ids = team.getMembers();
        ids.add(empId);
        team.setMembers(ids);
        teamRepository.save(team);
        return teamRepository.save(team);
    }
}
