package za.co.account.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import za.co.account.outbound.AccountOutboundPayload;
import za.co.account.processor.AccountProcessor;
import za.co.account.service.impl.AccountServiceImpl;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceImplTest {

    @InjectMocks
    AccountServiceImpl accountServiceImpl;

    @MockBean
    AccountProcessor accountProcessor;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAccountByIdPositive() {
        ResponseEntity<AccountOutboundPayload> applicationsByOfferId = accountServiceImpl.getAccountById(1L);
        assertThat(applicationsByOfferId.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
