package za.co.account.gateway;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "bank-service", fallback = BankGatewayFallbackService.class)
public interface BankGateway {

    @RequestMapping("/api/bank/{id}")
    String getAccountDetailsByAccountId(@PathVariable("id") Long accountId);

}
