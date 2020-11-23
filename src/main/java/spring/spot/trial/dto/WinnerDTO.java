package spring.spot.trial.dto;

import lombok.Data;
import spring.spot.trial.Entity.Employee;

import java.util.UUID;

@Data
public class WinnerDTO {
    private String empId;
    private UUID nominationId;
    private UUID pollId;
    private Employee employee;
    private String pollName;
}
