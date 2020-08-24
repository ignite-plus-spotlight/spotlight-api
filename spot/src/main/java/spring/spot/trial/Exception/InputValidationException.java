package spring.spot.trial.Exception;

import org.apache.commons.lang3.math.NumberUtils;

public class InputValidationException extends RuntimeException {

    public InputValidationException(String message) {
        super(message);
    }
    public InputValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public static void validateInputParameter(String employeeId){
        if (! NumberUtils.isParsable(employeeId))
        {
            throw new InputValidationException("Employee id should be numeric");
        }
    }
}
