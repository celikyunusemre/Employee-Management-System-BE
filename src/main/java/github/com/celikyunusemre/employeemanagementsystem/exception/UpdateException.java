package github.com.celikyunusemre.employeemanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UpdateException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UpdateException(String message) {
        super(message);
    }
    public UpdateException(String message, Throwable cause) {
        super(message, cause);
    }
}
