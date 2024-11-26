package fr.bankwiz.server.infrastructure.apirest.configuration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.http.HttpStatus;

import fr.bankwiz.server.infrastructure.apirest.ApiRestTestsBase;

public class OpenApiConfigurationTest extends ApiRestTestsBase {

    @ParameterizedTest
    @ValueSource(strings = {"/v3/api-docs", "/v3/api-docs.yaml"})
    void testOpenApi(final String path) {
        final var resultCall = this.apiTestHelper.getRequestWithoutAuthentication(path);
        Assertions.assertThat(resultCall.httpStatus()).isEqualTo(HttpStatus.OK);
    }
}
