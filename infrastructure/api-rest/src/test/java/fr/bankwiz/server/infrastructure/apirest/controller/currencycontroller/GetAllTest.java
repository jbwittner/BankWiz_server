package fr.bankwiz.server.infrastructure.apirest.controller.currencycontroller;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.instancio.Instancio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.type.TypeReference;

import fr.bankwiz.server.domain.model.data.CurrencyDomain;
import fr.bankwiz.server.infrastructure.apirest.controller.Endpoints;
import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.CurrencyDTO;

class GetAllTest extends CurrencyControllerTestBase {

    final String url = super.baseUrl + Endpoints.Currency.GET_ALL;

    @Test
    @DisplayName("User not authenticated")
    void user_not_authenticated() {
        // 👉 When
        final var resultCall = this.apiTestHelper.getRequestWithoutAuthentication(url);

        Assertions.assertThat(resultCall.httpStatus()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    @DisplayName("Get all currency")
    void get_all_currency() {
        // 👉 Given
        final List<CurrencyDomain> currencyDomainList = Instancio.createList(CurrencyDomain.class);
        Mockito.when(this.currencyDomainApi.getCurrencies()).thenReturn(currencyDomainList);

        // 👉 When
        final var resultCall = this.apiTestHelper.getRequest(url, new TypeReference<List<CurrencyDTO>>() {});

        // 👉 Then
        final var expectedCurrencyList = this.currencyMapper.toCurrencyDTOs(currencyDomainList);
        Assertions.assertThat(resultCall.httpStatus()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(resultCall.result()).containsExactlyInAnyOrderElementsOf(expectedCurrencyList);
    }
}
