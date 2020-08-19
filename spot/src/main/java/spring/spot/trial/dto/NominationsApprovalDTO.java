package spring.spot.trial.dto;

import lombok.Data;
import spring.spot.trial.Entity.Employee;

import java.time.LocalDateTime;
import java.util.UUID;

//director gets the nominations done by his managers (this list consists of team members)
@Data
public class NominationsApprovalDTO {
    private UUID pollId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String processName;
    private String headId; //whoever nominated (manager or director)
    private Employee head;
    private String description;
    private UUID nominationId;
    private String nomineeId;
    private Employee nominee;
    private String period;
}
//start date and end date of process
//poll id
//process name
//nominated_by's details Or approved_by's details
    //Nominee details
