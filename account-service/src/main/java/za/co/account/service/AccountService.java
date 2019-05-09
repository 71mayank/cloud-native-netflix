package za.co.account.service;

import org.springframework.http.ResponseEntity;
import za.co.account.outbound.AccountOutboundPayload;

import java.util.List;

public interface AccountService {

    ResponseEntity<AccountOutboundPayload> createAccount(Long id);

    ResponseEntity<List<AccountOutboundPayload>> getAccounts();

    ResponseEntity<AccountOutboundPayload> getAccountById(Long accountId);

}
