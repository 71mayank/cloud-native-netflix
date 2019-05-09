package za.co.bank.service;

import org.springframework.http.ResponseEntity;
import za.co.bank.outbound.BankOutboundPayload;
public interface BankService {
    ResponseEntity<BankOutboundPayload> getAccountById(Long accountId);
}
