package fr.bankwiz.server.domain.mockhelper;

import java.util.Optional;

import org.mockito.Mockito;

import fr.bankwiz.server.domain.model.data.CurrencyDomain;
import fr.bankwiz.server.domain.spi.CurrencyDomainSpi;

public class MockCurrencyDomainSpi extends MockHelper<CurrencyDomainSpi> {
    public MockCurrencyDomainSpi() {
        super(CurrencyDomainSpi.class);
    }

    public void mockFindByIsoCode(String isoCode, Optional<CurrencyDomain> optional) {
        Mockito.when(this.mock.findByIsoCode(isoCode)).thenReturn(optional);
    }
}
