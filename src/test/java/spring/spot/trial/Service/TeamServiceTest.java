package spring.spot.trial.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import spring.spot.trial.Entity.Team;
import spring.spot.trial.Repository.EmployeeRepository;
import spring.spot.trial.Repository.TeamRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TeamServiceTest {
    TeamRepository teamRepository = mock(TeamRepository.class);
    private EmployeeRepository employeeRepository=mock(EmployeeRepository.class);

    @InjectMocks
    TeamService teamService;
    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void  createTeam_test(){
        Team team = new Team();
        team.setManagerId("123");
        List<String> members = new ArrayList<>();
        members.add("234");
        members.add("345");
        team.setMembers(members);
        team.setTeamId(10);
        team.setTeamName("spotlight");

        when(teamRepository.save(team)).thenReturn(team);
        Team response = teamService.createTeam(team);
        assertNotNull(response);
    }

    @Test
    public void  getAllTeam_test(){
        List<Team> teams=new ArrayList<>();
        Team team = new Team();
        team.setManagerId("123");
        List<String> members = new ArrayList<>();
        members.add("234");
        members.add("345");
        team.setMembers(members);
        team.setTeamId(10);
        team.setTeamName("spotlight");
        teams.add(team);

        when(teamRepository.findAll()).thenReturn(teams);
        List<Team> response = teamService.getAllTeam();
        assertNotNull(response);
    }

    @Test
    public void  getTeamByManagerId_test(){
        List<Team> teams=new ArrayList<>();
        Team team = new Team();
        team.setManagerId("123");
        List<String> members = new ArrayList<>();
        members.add("234");
        members.add("345");
        team.setMembers(members);
        team.setTeamId(10);
        team.setTeamName("spotlight");
        teams.add(team);

        when(teamRepository.findByManagerId(any())).thenReturn(teams);
        List<Team> response = teamService.getTeamByManagerId(any());
        assertNotNull(response);
    }

    @Test
    public void  updateIntoList_test(){
        Team team = new Team();
        team.setManagerId("123");
        List<String> members = new ArrayList<>();
        members.add("234");
        members.add("345");
        team.setMembers(members);
        team.setTeamId(10);
        team.setTeamName("spotlight");

        when(teamRepository.save(team)).thenReturn(team);
        Team response = teamService.createTeam(team);
        assertNotNull(response);
    }

}