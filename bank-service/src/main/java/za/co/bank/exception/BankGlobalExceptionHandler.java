package za.co.bank.exception;


import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BankGlobalExceptionHandler {

    @ExceptionHandler(BankDetailsNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(BankDetailsNotFoundException ex, WebRequest request) {
        BankErrorDetails bankErrorDetails = new BankErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(bankErrorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
        BankErrorDetails bankErrorDetails = new BankErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(bankErrorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

