package spring.spot.trial.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

//to manager dashboard telling there is a poll/nomination started
@Data
public class PopUpDTO {
    String pollName;
    String description;
    LocalDateTime nominationStartDate;
    LocalDateTime nominationEndDate;
    UUID processId;
}