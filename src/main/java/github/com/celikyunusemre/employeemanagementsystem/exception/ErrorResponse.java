package github.com.celikyunusemre.employeemanagementsystem.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private String message;
    public ErrorResponse(String message) {
        super();
        this.message = message;
    }
}