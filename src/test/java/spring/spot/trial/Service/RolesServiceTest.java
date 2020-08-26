package spring.spot.trial.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import spring.spot.trial.Entity.Roles;
import spring.spot.trial.Repository.RolesRepository;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RolesServiceTest {
    RolesRepository rolesRepository = mock(RolesRepository.class);
    @InjectMocks
    RolesService rolesService;
    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void  createRoles_test(){
        Roles roles = new Roles();
        roles.setDescription("Manages everyone");
        roles.setRoleName("Manager");


        when(rolesRepository.save(roles)).thenReturn(roles);
        Roles response = rolesService.createRoles(roles);
        assertNotNull(response);
    }

}
