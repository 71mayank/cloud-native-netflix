package za.co.bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.bank.outbound.BankOutboundPayload;
import za.co.bank.processor.BankProcessor;
import za.co.bank.service.BankService;

import java.util.List;
import java.util.Objects;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    BankProcessor bankProcessor;

    @Override
    public ResponseEntity<BankOutboundPayload> getAccountById(Long accountId) {
        try {
            BankOutboundPayload bankOutboundPayload = bankProcessor.getAccountById(accountId);
            if (Objects.nonNull(bankOutboundPayload)) {
                return new ResponseEntity<>(bankOutboundPayload, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
