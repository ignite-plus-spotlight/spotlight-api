package spring.spot.trial.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import spring.spot.trial.Entity.EmpRoles;
import spring.spot.trial.Repository.EmpRolesRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmpRolesServiceTest {
    EmpRolesRepository empRolesRepository=mock(EmpRolesRepository.class);

    @InjectMocks
    EmpRolesService empRolesService;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createEmpRoles(){
        EmpRoles empRoles=new EmpRoles();
        empRoles.setEmpId("123");
        empRoles.setRoleName("Manager");

        when(empRolesRepository.save(any())).thenReturn(empRoles);
        EmpRoles response = empRolesService.createEmpRoles(empRoles);
        assertEquals("Manager",response.getRoleName());
    }

    @Test
    public  void getAllEmpRoles(){
        List<EmpRoles> empRoles = new ArrayList<>();
        EmpRoles empRoles1 = new EmpRoles();
        empRoles1.setEmpId("123");
        empRoles1.setRoleName("Manager");


       EmpRoles empRoles2= new EmpRoles();
        empRoles2.setEmpId("456");
        empRoles2.setRoleName("Team Member");

        empRoles.add(empRoles1);
        empRoles.add(empRoles2);
        when(empRolesRepository.findAll()).thenReturn(empRoles);
        List<EmpRoles> response =empRolesService.getAllEmpRoles();
        assertEquals(2,response.size());
    }
    @Test
    public void getEmpRolesById(){
        List<EmpRoles> empRoles= new ArrayList<>();
        EmpRoles empRoles1= new EmpRoles();
        empRoles1.setEmpId("123");
        empRoles1.setRoleName("Manager");
        empRoles.add(empRoles1);

        when(empRolesRepository.findByEmpId("123")).thenReturn(empRoles);
        List<EmpRoles> response = empRolesService.getEmpRolesById("123");
        assertNotNull(response);
    }

    }

