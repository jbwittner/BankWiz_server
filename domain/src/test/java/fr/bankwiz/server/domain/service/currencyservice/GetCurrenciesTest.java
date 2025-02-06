package fr.bankwiz.server.domain.service.currencyservice;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fr.bankwiz.server.domain.model.data.CurrencyDomain;

class GetCurrenciesTest extends CurrencyDomainServiceTestBase {

    @Test
    @DisplayName("Should return all currencies")
    void should_return_all_currencies() {
        // Given
        final List<CurrencyDomain> expectedCurrencies = Instancio.createList(CurrencyDomain.class);
        this.mockCurrencyDomainSpi.mockFindAll(expectedCurrencies);

        // When
        final var currencies = this.currencyDomainService.getCurrencies();

        // Then
        Assertions.assertThat(currencies).containsExactlyInAnyOrderElementsOf(expectedCurrencies);
    }
}
