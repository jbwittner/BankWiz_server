package fr.bankwiz.server.domain.mockhelper;

import java.util.List;
import java.util.Optional;

import org.mockito.Mockito;

import fr.bankwiz.server.domain.model.data.CurrencyDomain;
import fr.bankwiz.server.domain.spi.CurrencyDomainSpi;

public class MockCurrencyDomainSpi extends MockHelper<CurrencyDomainSpi> {
    public MockCurrencyDomainSpi() {
        super(CurrencyDomainSpi.class);
    }

    public void mockFindByIsoCode(final String isoCode, final Optional<CurrencyDomain> optional) {
        Mockito.when(this.mock.findByIsoCode(isoCode)).thenReturn(optional);
    }

    public void mockFindAll(final List<CurrencyDomain> currencies) {
        Mockito.when(this.mock.findAll()).thenReturn(currencies);
    }
}
