package fr.bankwiz.server.infrastructure.apirest.controller.currencycontroller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import fr.bankwiz.server.infrastructure.apirest.controller.Endpoints;

class GetAllTest extends CurrencyControllerTestBase {

    final String url = this.baseUrl + Endpoints.Currency.GET_ALL;

    @Test
    @DisplayName("User not authenticated")
    void user_not_authenticated() {
        // 👉 When
        final var resultCall = this.apiTestHelper.getRequestWithoutAuthentication(url);

        Assertions.assertThat(resultCall.httpStatus()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }
}
