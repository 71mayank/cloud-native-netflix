package za.co.account.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.account.model.Account;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void whenCreateAccount_thenReturnAccount() {
        // given
        Account account = buildAccount();
        entityManager.persist(account);
        entityManager.flush();
        // when
        Account found = accountRepository.findOne(account.getAccountId());
        // then
        String firstName = found.getFirstName();
        assertThat(firstName).isEqualTo("Mayank");
    }

    private Account buildAccount() {
        return Account.builder()
                .firstName("Mayank")
                .lastName("Tantuway")
                .build();
    }



}


