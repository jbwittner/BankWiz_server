package fr.bankwiz.server.infrastructure.apirest;

import fr.bankwiz.server.domain.api.CurrencyDomainApi;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import fr.bankwiz.server.domain.api.BankAccountDomainApi;
import fr.bankwiz.server.domain.api.UserDomainApi;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = {"test"})
public class ApiRestTestsBase {

    @Autowired
    protected ApiTestHelper apiTestHelper;

    @MockitoBean
    protected UserDomainApi userDomainApi;

    @MockitoBean
    protected BankAccountDomainApi bankAccountDomainApi;

    @MockitoBean
    protected CurrencyDomainApi currencyDomainApi;

    @BeforeEach
    void beforeEach() {
        Mockito.reset(this.userDomainApi, this.bankAccountDomainApi);
        this.apiTestHelper.setup();
    }
}
