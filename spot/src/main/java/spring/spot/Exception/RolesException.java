package spring.spot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RolesException extends RuntimeException {

    private static final long serialVersionId = 1L;
    public RolesException(String message) {
        super(message);
    }
}
