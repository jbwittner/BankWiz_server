package fr.bankwiz.server.domain.service.currencyservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import fr.bankwiz.server.domain.mockhelper.MockCurrencyDomainSpi;
import fr.bankwiz.server.domain.service.CurrencyDomainService;

@DisplayName("CurrencyDomainService Test Base")
class CurrencyDomainServiceTestBase {

    protected MockCurrencyDomainSpi mockCurrencyDomainSpi = new MockCurrencyDomainSpi();
    protected CurrencyDomainService currencyDomainService = new CurrencyDomainService(mockCurrencyDomainSpi.getMock());

    @BeforeEach
    public void setUp() {
        mockCurrencyDomainSpi.resetMock();
    }
}
