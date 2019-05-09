package za.co.account.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.account.dao.impl.AccountDAOImpl;
import za.co.account.model.Account;
import za.co.account.outbound.AccountOutboundPayload;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class AccountProcessor {

    @Autowired
    private AccountDAOImpl applicationDAOImpl;

    public AccountOutboundPayload createAccount(Long id) {
        // TODO Get Account details from Bank Using FeignClient
        // TODO Extract Account Details outbound payload
        return mapAccountEntityToAccountOutboundPayload(applicationDAOImpl.createAccount(null));
    }

    private AccountOutboundPayload mapAccountEntityToAccountOutboundPayload(Account account) {
        if (Objects.nonNull(account)) {
            return AccountOutboundPayload.builder()
                    .id(account.getAccountId())
                    .build();
        } else {
            return null;
        }
    }

    public List<AccountOutboundPayload> getAccounts() {
        return applicationDAOImpl.getAccounts().stream().map(this::mapAccountEntityToAccountOutboundPayload).collect(Collectors.toList());
    }

    public AccountOutboundPayload getAccountById(Long accountId) {
        return mapAccountEntityToAccountOutboundPayload(applicationDAOImpl.getAccountById(accountId));
    }

}
