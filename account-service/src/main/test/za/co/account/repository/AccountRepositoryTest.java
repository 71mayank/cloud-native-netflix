package za.co.account.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.account.model.Account;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {


    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void whenCreateAccount_thenReturnAccount() {
        Account accountCreated = accountRepository.save(buildAccount());
        assertThat(accountCreated.getFirstName()).isEqualTo("Mayank");
    }

    private Account buildAccount() {
        return Account.builder()
                .firstName("Mayank")
                .lastName("Tantuway")
                .build();
    }


}


