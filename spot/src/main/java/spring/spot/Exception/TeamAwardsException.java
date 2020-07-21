package spring.spot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import spring.spot.Entity.TeamAwards;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TeamAwardsException extends RuntimeException {

    private static final long serialVersionId = 1L;
    public TeamAwardsException(String message) {
        super(message);
    }
}
