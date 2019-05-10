package za.co.account.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BankGatewayFallbackService implements BankGateway {
    @Override
    public String getAccountDetailsByAccountId(Long accountId) {
        log.error("bank-service is down at the moment");
        return null;
    }
}
