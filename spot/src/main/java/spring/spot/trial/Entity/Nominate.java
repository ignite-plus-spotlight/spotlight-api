package spring.spot.trial.Entity;

import lombok.Data;

import java.util.UUID;

@Data
public class Nominate {
    UUID pollId;
    String employeeId;
    String managerId;
    String description;
    String pollName;
}
