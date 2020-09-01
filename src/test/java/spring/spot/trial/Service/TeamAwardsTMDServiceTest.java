package spring.spot.trial.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import spring.spot.trial.Entity.TeamAwardsTMD;
import spring.spot.trial.Repository.TeamAwardsTMDRepository;
import spring.spot.trial.Repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TeamAwardsTMDServiceTest {
    TeamAwardsTMDRepository teamAwardsTMDRepository = mock(TeamAwardsTMDRepository.class);
    TeamRepository teamRepository=mock(TeamRepository.class);
    @InjectMocks
    TeamAwardsTMDService teamAwardsTMDService;
    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void  createTeam_test(){
        TeamAwardsTMD team = new TeamAwardsTMD();
        team.setAwardName("Award Hulk");
        team.setDepartment("Technology");
        team.setDescription("Amazing");
        team.setEmployeeId("123");
        team.setImgsrc("http");
        team.setTeamId(12);
        team.setTeamName("spotlight");
        team.setTeamPoints(10);

        when(teamAwardsTMDRepository.save(team)).thenReturn(team);
        TeamAwardsTMD response = teamAwardsTMDService.createTeamAwards(team);
        assertNotNull(response);
    }

    @Test
    public void  getAllTeamAwards_test(){
        List<TeamAwardsTMD> teams=new ArrayList<>();
        TeamAwardsTMD team = new TeamAwardsTMD();
        team.setAwardName("Award hulk");
        team.setDepartment("Technology");
        team.setDescription("Amazing");
        team.setEmployeeId("123");
        team.setImgsrc("http");
        team.setTeamId(10);
        team.setTeamName("Spotlight");
        team.setTeamPoints(100);

        when(teamAwardsTMDRepository.findAll()).thenReturn(teams);
        List<TeamAwardsTMD> response = teamAwardsTMDService.getAllTeamAwards();
        assertNotNull(response);
    }

    @Test
    public void  getTeamAwardsById_test(){
        List<TeamAwardsTMD> teams=new ArrayList<>();
        TeamAwardsTMD team = new TeamAwardsTMD();
        team.setAwardName("Award hulk");
        team.setDepartment("Technology");
        team.setDescription("Amazing");
        team.setEmployeeId("123");
        team.setImgsrc("http");
        team.setTeamId(10);
        team.setTeamName("Spotlight");
        team.setTeamPoints(100);

        when(teamAwardsTMDRepository.findByEmployeeId(any())).thenReturn(teams);
        List<TeamAwardsTMD> response = teamAwardsTMDService.getTeamAwardsById(any());
        assertNotNull(response);
    }

    @Test
    public void  updateTeamAwardsById_test(){
        TeamAwardsTMD team = new TeamAwardsTMD();
        team.setAwardName("Award Hulk");
        team.setDepartment("Technology");
        team.setDescription("Amazing");
        team.setEmployeeId("123");
        team.setImgsrc("http");
        team.setTeamId(12);
        team.setTeamName("spotlight");
        team.setTeamPoints(10);

        when(teamAwardsTMDRepository.save(team)).thenReturn(team);
        TeamAwardsTMD response = teamAwardsTMDService.updateTeamAwardsById("456",12,team);
        assertNotNull(response);
    }

}