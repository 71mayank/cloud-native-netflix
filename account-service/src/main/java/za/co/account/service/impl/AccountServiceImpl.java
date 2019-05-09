package za.co.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.account.outbound.AccountOutboundPayload;
import za.co.account.processor.AccountProcessor;
import za.co.account.service.AccountService;

import java.util.List;
import java.util.Objects;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountProcessor accountProcessor;

    @Override
    public ResponseEntity<AccountOutboundPayload> createAccount(Long id) {
        try {
            // TODO Call bank microservice to get account details and then persist
            // TODO BANK OUTBOUND Extract account details and then map and
            return new ResponseEntity<>(accountProcessor.createAccount(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<AccountOutboundPayload>> getAccounts() {
        try {
            return new ResponseEntity<>(accountProcessor.getAccounts(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<AccountOutboundPayload> getAccountById(Long accountId) {
        try {
            AccountOutboundPayload accountOutboundPayload = accountProcessor.getAccountById(accountId);
            if (Objects.nonNull(accountOutboundPayload)) {
                return new ResponseEntity<>(accountOutboundPayload, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
