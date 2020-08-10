package spring.spot.trial.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<Object> handleApiRequestException(ResourceNotFoundException e)
    {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        ErrorDetails errorDetails = new ErrorDetails(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(errorDetails,badRequest);
    }

    @ExceptionHandler(value = {InvalidIDException.class})
    public ResponseEntity<Object> handleInvalidIdException(InvalidIDException e)
    {
        HttpStatus notFound = HttpStatus.NOT_FOUND;

        ErrorDetails errorDetails = new ErrorDetails(
                e.getMessage(),
                notFound,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(errorDetails,notFound);
    }

    @ExceptionHandler(value = {InternalServerErrorException.class})
    public ResponseEntity<Object> handleInternalServerErrorException(InternalServerErrorException e)
    {
        HttpStatus internalServerError = HttpStatus.INTERNAL_SERVER_ERROR;

        ErrorDetails errorDetails = new ErrorDetails(
                e.getMessage(),
                internalServerError,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(errorDetails,internalServerError);
    }



}
