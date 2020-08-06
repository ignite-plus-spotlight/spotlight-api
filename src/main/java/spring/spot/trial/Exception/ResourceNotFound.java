package spring.spot.trial.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends Exception{

    private static final long serialVersionUID = 1L;
        String message;
   /* public ResourceNotFound(String message){
        super(message);
    }
*/
    public ResourceNotFound(String message)
    {
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
//compare
//public InvalidEmployeeIdException(ExceptionResponse exceptionResponse, HttpStatus httpStatus) {
   // super(exceptionResponse, httpStatus);
//}

