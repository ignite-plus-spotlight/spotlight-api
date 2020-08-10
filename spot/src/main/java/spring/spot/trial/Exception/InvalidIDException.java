package spring.spot.trial.Exception;

public class InvalidIDException extends RuntimeException{
    public InvalidIDException(String message) {
        super(message);
    }
    public InvalidIDException(String message, Throwable cause) {
        super(message, cause);
    }
}
