package spring.spot.trial.dto;

import lombok.Data;
import spring.spot.trial.Entity.Employee;

import java.util.UUID;

@Data
public class NominationDTO {
    private UUID nominationId;
    private String empId;
    private String description;
    private String headId;
    private Employee employee;
}
