package za.co.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.account.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
