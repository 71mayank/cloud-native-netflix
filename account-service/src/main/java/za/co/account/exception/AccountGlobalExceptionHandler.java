package za.co.account.exception;


import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AccountGlobalExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(AccountNotFoundException ex, WebRequest request) {
        AccountErrorDetails accountErrorDetails = new AccountErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(accountErrorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        AccountErrorDetails accountErrorDetails = new AccountErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(accountErrorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

