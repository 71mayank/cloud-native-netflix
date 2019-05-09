package za.co.bank.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.co.bank.dao.impl.BankDAOImpl;
import za.co.bank.model.Bank;
import za.co.bank.outbound.BankOutboundPayload;

import java.util.Objects;

@Component
public class BankProcessor {

    @Autowired
    private BankDAOImpl applicationDAOImpl;

    private BankOutboundPayload mapAccountEntityToAccountOutboundPayload(Bank bank) {
        if (Objects.nonNull(bank)) {
            return BankOutboundPayload.builder()
                    .id(bank.getId())
                    .firstName(bank.getFirstName())
                    .lastName(bank.getLastName())
                    .iban(bank.getIban())
                    .build();
        } else {
            return null;
        }
    }

    public BankOutboundPayload getAccountById(Long accountId) {
        return mapAccountEntityToAccountOutboundPayload(applicationDAOImpl.getAccountById(accountId));
    }

}
