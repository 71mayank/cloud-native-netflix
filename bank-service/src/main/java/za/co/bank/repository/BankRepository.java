package za.co.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.bank.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {

}
