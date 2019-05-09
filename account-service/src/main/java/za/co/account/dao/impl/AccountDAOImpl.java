package za.co.account.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import za.co.account.dao.AccountDAO;
import za.co.account.model.Account;
import za.co.account.repository.AccountRepository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(Long accountId) {
        return accountRepository.getOne(accountId);
    }
}