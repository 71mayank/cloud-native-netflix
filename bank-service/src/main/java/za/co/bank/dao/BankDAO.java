package za.co.bank.dao;

import za.co.bank.model.Bank;

public interface BankDAO {
    Bank getAccountById(Long accountId);
}
