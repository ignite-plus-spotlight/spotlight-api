package spring.spot.trial.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import spring.spot.trial.Entity.Roles;
import spring.spot.trial.Repository.RolesRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RolesServiceTest {

    RolesRepository rolesRepository=mock(RolesRepository.class);

    @InjectMocks
    RolesService rolesService;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createRoles(){

        Roles roles= new Roles();
        roles.setDescription("Manages the team");
        roles.setRoleName("Manager");

        when(rolesRepository.save(any())).thenReturn(roles);
        Roles response = rolesService.createRoles(roles);
        assertEquals("Manager",response.getRoleName());
    }

    @Test
    public void getAllRoles()
    {
        List<Roles> roles = new ArrayList<>();
        Roles roles1 = new Roles();

        roles1.setDescription("manages team");
        roles1.setRoleName("Manager");
        roles1.setTimestamp(LocalDateTime.now());

        roles.add(roles1);

        Roles roles2 = new Roles();

        roles2.setTimestamp(LocalDateTime.now());
        roles2.setRoleName("Team Member");
        roles2.setDescription("Member of the team");

        roles.add(roles2);

        when(rolesRepository.findAll()).thenReturn(roles);
        List<Roles> response = rolesService.getAllRoles();
        assertEquals(2,response.size());


    }


}