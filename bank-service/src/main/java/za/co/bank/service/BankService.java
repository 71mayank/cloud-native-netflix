package za.co.bank.service;

import org.springframework.http.ResponseEntity;
public interface BankService {
    ResponseEntity<String> getAccountById(Long accountId);
}
