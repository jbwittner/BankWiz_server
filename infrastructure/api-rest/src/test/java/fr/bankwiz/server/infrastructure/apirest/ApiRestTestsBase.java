package fr.bankwiz.server.infrastructure.apirest;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import fr.bankwiz.server.domain.api.UserDomainApi;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = {"test"})
public class ApiRestTestsBase {

    @MockBean
    protected UserDomainApi userDomainApi;

    @Autowired
    protected ApiTestHelper apiTestHelper;

    @BeforeEach
    void beforeEach() {
        Mockito.reset(userDomainApi);
        apiTestHelper.setup();
    }
}
