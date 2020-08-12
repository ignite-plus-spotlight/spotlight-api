package spring.spot.trial.dto;

import lombok.Data;
import spring.spot.trial.Entity.Employee;

@Data
public class NominationDTO {
    private String nominationId;
    private String emp_id;
    private String description;
    private String manager_id;
    private Employee employee;

}
