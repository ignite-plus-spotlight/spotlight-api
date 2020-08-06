package spring.spot.trial;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import spring.spot.trial.Entity.Employee;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeServiceCntrollerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void createEmployee() throws Exception {
        String uri = "/employee";
        Employee employee = new Employee();
        employee.setEmpId("1");
        employee.setEmpEmail("Ginger@gmail.com");
        employee.setDob("2-08-1999");
        employee.setFirstName("Ginger");
        employee.setLastName("Scot");
        employee.setImageUrl("http:");
        employee.setProviderName("Google");
        employee.setTeamId(null);

        String inputJson = super.mapToJson(employee);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Employee is created successfully");
    }
}
