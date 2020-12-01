package spring.spot.trial.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

//notifying manager and director that a nomination process has been started
@Data
public class PopUpDTO {
    String pollName;
    String description;
    LocalDateTime nominationStartDate;
    LocalDateTime nominationEndDate;
    UUID processId;
}