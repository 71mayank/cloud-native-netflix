package za.co.account.gateway;

import com.netflix.hystrix.exception.HystrixTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BankGatewayFallbackService implements BankGateway {
    @Override
    public String getAccountDetailsByAccountId(Long accountId) throws HystrixTimeoutException {
        throw new HystrixTimeoutException();

    }
}
