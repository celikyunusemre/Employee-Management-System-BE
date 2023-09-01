package github.com.celikyunusemre.employeemanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(
            RecordNotFoundException ex
    ) {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getLocalizedMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(MissingHeaderInfoException.class)
    public final ResponseEntity<ErrorResponse> handleInvalidTraceIdException(
            MissingHeaderInfoException ex
    ) {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getLocalizedMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(DuplicateDataException.class)
    public final ResponseEntity<ErrorResponse> handleDuplicateEntryException(
            DuplicateDataException ex
    ) {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getLocalizedMessage()),
                HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ErrorResponse> handleBadDataEntryException(
            BadRequestException ex
    ) {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getLocalizedMessage()),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(UpdateException.class)
    public final ResponseEntity<ErrorResponse> handleUpdateException(
            UpdateException ex
    ) {
        return new ResponseEntity<>(
                new ErrorResponse(ex.getLocalizedMessage()),
                HttpStatus.BAD_REQUEST
        );
    }
}
