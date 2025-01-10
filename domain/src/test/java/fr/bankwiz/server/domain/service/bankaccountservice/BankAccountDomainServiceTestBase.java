package fr.bankwiz.server.domain.service.bankaccountservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import fr.bankwiz.server.domain.mockhelper.MockAuthenticationSpi;
import fr.bankwiz.server.domain.mockhelper.MockBankAccountDomainSpi;
import fr.bankwiz.server.domain.mockhelper.MockCurrencyDomainSpi;
import fr.bankwiz.server.domain.service.BankAccountService;

@DisplayName("BankAccountService Test Base")
class BankAccountDomainServiceTestBase {

    protected MockAuthenticationSpi mockAuthenticationSpi = new MockAuthenticationSpi();
    protected MockBankAccountDomainSpi mockBankAccountDomainSpi = new MockBankAccountDomainSpi();
    protected MockCurrencyDomainSpi mockCurrencyDomainSpi = new MockCurrencyDomainSpi();
    protected BankAccountService bankAccountService = new BankAccountService(
            mockAuthenticationSpi.getMock(), mockBankAccountDomainSpi.getMock(), mockCurrencyDomainSpi.getMock());

    @BeforeEach
    public void setUp() {
        mockAuthenticationSpi.resetMock();
        mockBankAccountDomainSpi.resetMock();
        mockCurrencyDomainSpi.resetMock();
    }
}
