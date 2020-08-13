package spring.spot.trial.dto;

import lombok.Data;

import java.util.Date;

//to manager dashboard telling there is a poll/nomination started
@Data
public class PopUpDTO {
    String pollName;
    String description;
    Date nominationStartDate;
    Date nominationEndDate;
}
