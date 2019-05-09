package za.co.bank.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import za.co.bank.dao.BankDAO;
import za.co.bank.model.Bank;
import za.co.bank.repository.BankRepository;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class BankDAOImpl implements BankDAO {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public Bank getAccountById(Long accountId) {
        //TODO Add Account details to Bank
        buildBankEntity();
        return buildBankEntity();
    }

    private Bank buildBankEntity() {
        return Bank.builder().id(1L).firstName("Max").lastName("Mustermann").iban("DE89370400440532013087").build();
    }
}