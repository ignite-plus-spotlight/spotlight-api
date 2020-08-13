package spring.spot.trial.dto;

import lombok.Data;
import spring.spot.trial.Entity.Employee;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class NominationHistoryDto {
    private UUID nominationId;
    private String emp_id;
    private Employee employee;
    private String manager_id;
    private LocalDateTime createDate;
}
