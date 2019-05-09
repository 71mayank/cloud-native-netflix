package za.co.bank.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BankErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
}
