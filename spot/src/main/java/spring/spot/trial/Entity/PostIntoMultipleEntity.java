package spring.spot.trial.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostIntoMultipleEntity {
    String pollName;
    String description;
    Date nomStart;
    Date nomEnd;
    Date pollStart;
    Date pollEnd;
}
