package fr.bankwiz.server.infrastructure.apirest.configuration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.http.HttpStatus;

import fr.bankwiz.server.infrastructure.apirest.ApiRestTestsBase;

class OpenApiConfigurationTest extends ApiRestTestsBase {

    @ParameterizedTest
    @ValueSource(
            strings = {
                "/v3/api-docs",
                "/v3/api-docs.yaml",
                "/v3/api-docs/swagger-config",
                "/swagger-ui/index.html",
                "/swagger-ui/index.css",
                "/swagger-ui/swagger-ui.css",
                "/swagger-ui/swagger-ui-bundle.js",
                "/swagger-ui/swagger-ui-standalone-preset.js",
                "/swagger-ui/favicon-32x32.png",
                "/swagger-ui/swagger-initializer.js"
            })
    void testOpenApi(final String path) {
        final var resultCall = this.apiTestHelper.getRequestWithoutAuthentication(path);
        Assertions.assertThat(resultCall.httpStatus()).isEqualTo(HttpStatus.OK);
    }
}
