package spring.spot.trial.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import spring.spot.trial.Entity.TeamDepartments;
import spring.spot.trial.Repository.TeamDepartmentsRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TeamDepartmentServiceTest {
    TeamDepartmentsRepository teamDepartmentsRepository = mock(TeamDepartmentsRepository.class);

    @InjectMocks
    TeamDepartmentsService teamDepartmentsService;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createTeamDepartments(){
        TeamDepartments teamDepartments= new TeamDepartments();

        teamDepartments.setDepartment("Technology");
        teamDepartments.setTeamId(100);

        when(teamDepartmentsRepository.save(any())).thenReturn(teamDepartments);
        TeamDepartments response= teamDepartmentsService.createTeamDepartments(teamDepartments);
        assertEquals("Technology",response.getDepartment());

    }

    @Test
    public void getAllTeamDepartments(){
        List<TeamDepartments> teamDepartments = new ArrayList<>();

        TeamDepartments teamDepartments1= new TeamDepartments();
        teamDepartments1.setTeamId(100);
        teamDepartments1.setDepartment("Technology");
        teamDepartments.add(teamDepartments1);

        TeamDepartments teamDepartments2= new TeamDepartments();
        teamDepartments2.setDepartment("Management");
        teamDepartments2.setTeamId(200);
        teamDepartments.add(teamDepartments2);

        when(teamDepartmentsRepository.findAll()).thenReturn(teamDepartments);
        List<TeamDepartments> response = teamDepartmentsService.getAllTeamDepartments();
        assertEquals(2,response.size());

    }

    @Test
    public void getTeamDepartmentsByName(){
        List<TeamDepartments> teamDepartments = new ArrayList<>();

        TeamDepartments teamDepartments1 = new TeamDepartments();
        teamDepartments1.setTeamId(100);
        teamDepartments1.setDepartment("Technology");
        teamDepartments.add(teamDepartments1);

        when(teamDepartmentsRepository.findByDepartment(any())).thenReturn(teamDepartments);
        List<TeamDepartments> response = teamDepartmentsService.getTeamDepartmentsByName(any());
        assertNotNull(response);
    }


}
