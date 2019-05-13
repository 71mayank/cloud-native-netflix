package za.co.account.gateway;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "bank-service", fallback = BankGatewayFallbackService.class)
public interface BankGateway {

    @RequestMapping(value = "/api/bank/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getAccountDetailsByAccountId")
    String getAccountDetailsByAccountId(@PathVariable("id") Long accountId) throws HystrixTimeoutException;

}
