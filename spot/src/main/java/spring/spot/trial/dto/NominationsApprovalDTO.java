package spring.spot.trial.dto;

import lombok.Data;
import spring.spot.trial.Entity.Employee;

import java.time.LocalDateTime;
import java.util.UUID;

//vp gets the approved list from his directors(approval list consists of team members)
//vp gets nominations done by his directors (nominations list consists of managers)
//director gets the nominations done by his managers (this list consists of team members)
@Data
public class NominationsApprovalDTO {
    private UUID pollId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String processName;
    private String headId; //whoever nominated(manager or director) /approved(approved is always director)
    private Employee head;
    private String description;
    private UUID nominationId;
    private String nomineeId;
    private Employee nominee;
}
//start date and end date of process
//poll id
//process name
//nominated_by's details Or approved_by's details
    //Nominee details
