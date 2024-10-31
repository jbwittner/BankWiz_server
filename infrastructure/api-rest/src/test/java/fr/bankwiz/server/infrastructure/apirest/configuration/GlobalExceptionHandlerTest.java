package fr.bankwiz.server.infrastructure.apirest.configuration;

import org.assertj.core.api.Assertions;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import fr.bankwiz.server.domain.exception.FunctionalException;
import fr.bankwiz.server.infrastructure.apirest.ApiRestTestsBase;
import fr.bankwiz.server.infrastructure.apirest.controller.Endpoints;
import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.FunctionalExceptionDTO;

class GlobalExceptionHandlerTest extends ApiRestTestsBase {

    static class TestException extends FunctionalException {

        public TestException(final String value1, final String value2) {
            super("value1 : " + value1 + " / value2 : " + value2);
            this.attributes.put("value1", value1);
            this.attributes.put("value2", value2);
        }
    }

    @Test
    void handle_functional_exception() {
        // ⚙ Given that
        final String value1 = Instancio.create(String.class);
        final String value2 = Instancio.create(String.class);
        Mockito.when(this.userDomainApi.authenticationUser())
                .thenThrow(new GlobalExceptionHandlerTest.TestException(value1, value2));

        final String url = "/" + Endpoints.User.BASE + "/" + Endpoints.User.AUTHENTICATE;

        // 👉 When
        final var resultCall = this.apiTestHelper.getRequest(url, FunctionalExceptionDTO.class);

        // ✅ Then
        Assertions.assertThat(resultCall.httpStatus()).isEqualTo(HttpStatus.BAD_REQUEST);
        final var exceptionDTO = resultCall.result();
        Assertions.assertThat(exceptionDTO.exception()).isEqualTo("TestException");
        Assertions.assertThat(exceptionDTO.message()).isEqualTo("value1 : " + value1 + " / value2 : " + value2);
        Assertions.assertThat(exceptionDTO.attributes().get("value1")).isEqualTo(value1);
        Assertions.assertThat(exceptionDTO.attributes().get("value2")).isEqualTo(value2);
    }
}
