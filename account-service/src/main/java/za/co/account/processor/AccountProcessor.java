package za.co.account.processor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.account.dao.impl.AccountDAOImpl;
import za.co.account.exception.AccountNotFoundException;
import za.co.account.gateway.BankGateway;
import za.co.account.model.Account;
import za.co.account.outbound.AccountOutboundPayload;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AccountProcessor {

    @Autowired
    private AccountDAOImpl applicationDAOImpl;

    @Resource
    BankGateway bankGateway;

    @Autowired
    ObjectMapper objectMapper;

    public AccountOutboundPayload createAccount(Long id) throws IOException, HystrixTimeoutException {
        AccountOutboundPayload accountOutboundPayload = objectMapper.readValue(bankGateway.getAccountDetailsByAccountId(id), AccountOutboundPayload.class);
        Account account = applicationDAOImpl.createAccount(buildAccountEntityFromAccountOutboundPayload(accountOutboundPayload));
        return mapAccountEntityToAccountOutboundPayload(account);
    }

    private AccountOutboundPayload mapAccountEntityToAccountOutboundPayload(Account account) {
        if (Objects.nonNull(account)) {
            return AccountOutboundPayload.builder()
                    .id(account.getId())
                    .firstName(account.getFirstName())
                    .lastName(account.getLastName())
                    .build();
        } else {
            return null;
        }
    }

    private Account buildAccountEntityFromAccountOutboundPayload(AccountOutboundPayload accountOutboundPayload) {
        return Account.builder()
                .firstName(accountOutboundPayload.getFirstName())
                .lastName(accountOutboundPayload.getLastName())
                .build();
    }

    public List<AccountOutboundPayload> getAccounts() {
        return applicationDAOImpl.getAccounts().stream().map(this::mapAccountEntityToAccountOutboundPayload).collect(Collectors.toList());
    }

    public AccountOutboundPayload getAccountById(Long accountId) {
        return mapAccountEntityToAccountOutboundPayload(applicationDAOImpl.getAccountById(accountId));
    }

}
