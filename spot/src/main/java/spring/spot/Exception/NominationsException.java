package spring.spot.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class NominationsException extends RuntimeException {

    private static final long serialVersionId = 1L;
    public NominationsException(String message) {
        super(message);
    }
}