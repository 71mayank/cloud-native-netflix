package za.co.account.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.account.outbound.AccountOutboundPayload;
import za.co.account.service.impl.AccountServiceImpl;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceImplIntegrationTest {

    @Autowired
    AccountServiceImpl accountService;

    @Test
    public void testGetAccountByIdPositive() {
        ResponseEntity<AccountOutboundPayload> applicationsByOfferId = accountService.getAccountById(1L);
        AccountOutboundPayload accountOutboundPayload = applicationsByOfferId.getBody();
        assertThat(applicationsByOfferId.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(accountOutboundPayload).isNotNull();
    }

}
