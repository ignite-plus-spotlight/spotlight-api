package spring.spot.trial.dto;

import lombok.Data;
import spring.spot.trial.Entity.Employee;

import java.time.LocalDateTime;
import java.util.UUID;

//head views the history of nominations done by him or her
@Data
public class NominationHistoryDto {
    private UUID nominationId;
    private String emp_id;
    private Employee employee;
    private String manager_id;
    private LocalDateTime createDate;
    private String pollName;
    private String description;
}
