package za.co.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import za.co.account.model.Account;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
