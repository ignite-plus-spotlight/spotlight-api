package spring.spot.trial.dto;

import lombok.Data;
import spring.spot.trial.Entity.Employee;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class NominationHistoryDto {
    private UUID nominationId;
    private String empId;
    private Employee employee;
    private String headId;
    private LocalDateTime createDate;
    private String pollName;
    private String description;
}
