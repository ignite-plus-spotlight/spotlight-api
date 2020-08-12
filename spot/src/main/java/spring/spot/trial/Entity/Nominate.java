package spring.spot.trial.Entity;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Nominate {
    UUID pollId; String nominationId; String employeeId; String managerId; String description; Date createdDate; String pollName;
}
