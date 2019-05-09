package za.co.account.dao;

import za.co.account.model.Account;

import java.util.List;

public interface AccountDAO {

    Account createAccount(Account account);

    List<Account> getAccounts();

    Account getAccountById(Long accountId);

}
