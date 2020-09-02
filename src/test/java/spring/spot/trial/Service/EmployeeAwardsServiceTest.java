package spring.spot.trial.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import spring.spot.trial.Entity.*;
import spring.spot.trial.Repository.*;


import java.util.ArrayList;
import java.util.List;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeAwardsServiceTest {

    EmployeeAwardsTMRepository employeeAwardsTMRepository = mock(EmployeeAwardsTMRepository.class);
    EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
    AwardToIndividualRepository awardToIndividualRepository = mock(AwardToIndividualRepository.class);
    ActivityFeedRepository activityFeedRepository = mock(ActivityFeedRepository.class);
    TeamRepository teamRepository = mock(TeamRepository.class);
    EmployeeAwardsMRepository employeeAwardsMRepository = mock(EmployeeAwardsMRepository.class);

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @InjectMocks
    EmployeeAwardsService employeeAwardsService;

    /*@Test
    public void createEmployeeAwards() throws Exception {
        List<EmployeeAwardsTM> awardsTMS = new ArrayList<>();
        EmployeeAwardsTM awardsTM = new EmployeeAwardsTM();
        awardsTM.setAwardedById("111");
        awardsTM.setAwardName("Employee Of The Year");
        awardsTM.setDepartment("Technology");
        awardsTM.setDescription("Well done");
        awardsTM.setEmpId("222");
        awardsTM.setEmpPoints(200);
        awardsTM.setImgsrc("http:");
        awardsTM.setManagerName("Ayan");
        awardsTM.setPeriodName("yearly");
        awardsTMS.add(awardsTM);

        List<EmployeeAwardsMD> awardsMDS = new ArrayList<>();
        EmployeeAwardsMD awardsMD = new EmployeeAwardsMD();
        awardsMD.setAwardedById("100");
        awardsMD.setAwardName("Employee Of The Quarter");
        awardsMD.setDepartment("Technology");
        awardsMD.setDescription("Good");
        awardsMD.setEmpId("200");
        awardsMD.setEmpPoints(200);
        awardsMD.setImgsrc("http:");
        awardsMD.setManagerName("Ayan");
        awardsMD.setPeriodName("yearly");
        awardsMDS.add(awardsMD);


        List<Employee> employees= new ArrayList<>();
        Employee employee1= new Employee();
        employee1.setEmpId("100");
        employee1.setDob("12-12-2020");
        employee1.setEmpEmail("sree@gmail.com");
        employee1.setFirstName("sree");
        employee1.setImageUrl("http:");
        employee1.setLastName("M");
        employee1.setProviderName("google");
        employee1.setTimestamp(LocalDateTime.now());
        employees.add(employee1);


        ActivityFeed activity1 = new ActivityFeed();
        activity1.setAwardeeId("111");
        activity1.setUuid(UUID.randomUUID());
        activity1.setAwardeeName("Ayan");
        activity1.setAwardName("Employee Of The Year");
        activity1.setDescription("Best Performer");
        activity1.setImgsrc("http:");
        activity1.setLikes(2);
        activity1.setPoints(200);


        AwardToIndividual awardToIndividual = new AwardToIndividual();
        awardToIndividual.setAwardName("Employee of the month");
        awardToIndividual.setDescription("Best Performer");
        awardToIndividual.setImgsrc("http:");
        awardToIndividual.setPoints(100);

        when(awardToIndividualRepository.findByAwardName(awardToIndividual.getAwardName())).thenReturn(awardToIndividual);
        when(employeeAwardsTMRepository.save(any())).thenReturn(awardsTM);
        when(employeeAwardsMRepository.save(any())).thenReturn(awardsMD);
        when(employeeAwardsTMRepository.findByEmpId(any())).thenReturn(awardsTMS);
        when(employeeRepository.findByEmpId(any())).thenReturn(employees);
        when(activityFeedRepository.save(any())).thenReturn(activity1);

        EmployeeAwardsTM response = employeeAwardsService.createEmployeeAwards(awardsTM.empId, awardsTM.getAwardedById(), awardsTM.awardName, awardsTM.periodName, awardsTM.department);
        assertEquals("Technology", response.getDepartment());

    }*/

    @Test
    public void getAllEmployeeAwards() {
        List<EmployeeAwardsTM> awardsTM = new ArrayList<>();

        EmployeeAwardsTM awardsTM1 = new EmployeeAwardsTM();
        awardsTM1.setEmpId("111");
        awardsTM1.setDepartment("Technology");
        awardsTM1.setPeriodName("Monthly");
        awardsTM1.setAwardedById("222");
        awardsTM1.setManagerName("Anusha");
        awardsTM1.setImgsrc("http:");
        awardsTM1.setAwardName("Hulk Award");
        awardsTM1.setDescription("Well done");
        awardsTM1.setEmpPoints(200);

        EmployeeAwardsTM awardsTM2 = new EmployeeAwardsTM();
        awardsTM2.setEmpId("111");
        awardsTM2.setDepartment("Technology");
        awardsTM2.setPeriodName("Monthly");
        awardsTM2.setAwardedById("222");
        awardsTM2.setManagerName("Anusha");
        awardsTM2.setImgsrc("http:");
        awardsTM2.setAwardName("Dashing Debut");
        awardsTM2.setDescription("Well done");
        awardsTM2.setEmpPoints(200);

        awardsTM.add(awardsTM1);
        awardsTM.add(awardsTM2);

        when(employeeAwardsTMRepository.findAll()).thenReturn(awardsTM);
        List<EmployeeAwardsTM> response = employeeAwardsService.getAllEmployeeAwards();
        assertEquals(2, response.size());

    }

    @Test
    public void getEmployeeAwardsById() {
        List<EmployeeAwardsTM> awardsTM = new ArrayList<>();

        EmployeeAwardsTM awardsTM1 = new EmployeeAwardsTM();
        awardsTM1.setEmpId("111");
        awardsTM1.setDepartment("Technology");
        awardsTM1.setPeriodName("Monthly");
        awardsTM1.setAwardedById("222");
        awardsTM1.setManagerName("Anusha");
        awardsTM1.setImgsrc("http:");
        awardsTM1.setAwardName("Hulk Award");
        awardsTM1.setDescription("Well done");
        awardsTM1.setEmpPoints(200);

        awardsTM.add(awardsTM1);

        when(employeeAwardsTMRepository.findByEmpId(awardsTM1.empId)).thenReturn(awardsTM);
        List<EmployeeAwardsTM> employeeAwardsTMS = employeeAwardsService.getEmployeeAwardsById(awardsTM1.getEmpId());
        assertEquals("Technology", employeeAwardsTMS.get(0).getDepartment());


    }

    /*@Test
    public void getEmployeeAwardsByManagerId(){

        List<EmployeeAwardsMD> awardsMDS = new ArrayList<>();

        EmployeeAwardsMD awardsMD1 = new EmployeeAwardsMD();
        awardsMD1.setAwardedById("111");
        awardsMD1.setManagerName("Anusha");
        awardsMD1.setAwardName("Hulk Award");
        awardsMD1.setDepartment("Technology");
        awardsMD1.setDescription("Well done");
        awardsMD1.setEmpId("222");
        awardsMD1.setEmpPoints(200);
        awardsMD1.setPeriodName("Monthly");

        awardsMDS.add(awardsMD1);

        when(employeeAwardsMRepository.findByAwardedById(any())).thenReturn(awardsMDS);
        List<EmployeeAwardsMD> awardsMDList = employeeAwardsService.getEmployeeAwardsMByManagerId(awardsMD1.awardedById);
        assertEquals("Anusha",awardsMDList.get(0).getManagerName());

    }*/
}
