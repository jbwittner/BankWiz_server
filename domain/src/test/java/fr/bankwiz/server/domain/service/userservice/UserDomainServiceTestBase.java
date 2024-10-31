package fr.bankwiz.server.domain.service.userservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import fr.bankwiz.server.domain.mockhelper.MockAuthenticationSpi;
import fr.bankwiz.server.domain.mockhelper.MockUserDomainSpi;
import fr.bankwiz.server.domain.service.UserDomainService;

@DisplayName("UserDomainService Test Base")
class UserDomainServiceTestBase {

    protected MockUserDomainSpi mockUserDomainSpi = new MockUserDomainSpi();
    protected MockAuthenticationSpi mockAuthenticationSpi = new MockAuthenticationSpi();
    protected UserDomainService userDomainService =
            new UserDomainService(mockAuthenticationSpi.getMock(), mockUserDomainSpi.getMock());

    @BeforeEach
    public void setUp() {
        mockAuthenticationSpi.resetMock();
        mockUserDomainSpi.resetMock();
    }
}
