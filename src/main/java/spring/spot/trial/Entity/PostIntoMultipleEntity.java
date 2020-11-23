package spring.spot.trial.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostIntoMultipleEntity {
    String pollName;
    String description;
    LocalDateTime pollStart;
    LocalDateTime pollEnd;
    String period;
}
