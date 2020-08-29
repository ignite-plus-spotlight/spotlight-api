package spring.spot.trial.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import spring.spot.trial.Entity.Roles;
import spring.spot.trial.Repository.RolesRepository;

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



}