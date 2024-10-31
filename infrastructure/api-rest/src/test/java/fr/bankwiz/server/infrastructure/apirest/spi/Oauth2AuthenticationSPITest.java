package fr.bankwiz.server.infrastructure.apirest.spi;

import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;

import fr.bankwiz.server.domain.model.data.UserAuthenticationDomain;
import fr.bankwiz.server.infrastructure.apirest.ApiRestTestsBase;
import fr.bankwiz.server.infrastructure.apirest.exception.Auth0ErrorException;

import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.instancio.Select.field;

public class Oauth2AuthenticationSPITest extends ApiRestTestsBase {

    @Autowired
    private ObjectMapper objectMapper;

    private Oauth2AuthenticationSpi oauth2AuthenticationSpi;

    private static WireMockServer wireMockServer;

    @BeforeAll
    public static void beforeAll() {
        wireMockServer = new WireMockServer(options().port(8080).notifier(new ConsoleNotifier(true)));
        wireMockServer.start();
        configureFor(wireMockServer.port());
    }

    @BeforeEach
    public void beforeEach() {
        wireMockServer.resetAll();
        oauth2AuthenticationSpi = new Oauth2AuthenticationSpi("http://localhost:8080/", objectMapper);
    }

    @Test
    void get_current_user_authentication_ok() {
        // ⚙ Given that
        final SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        final Jwt jwt =
                Instancio.of(Jwt.class).set(field(Jwt::getTokenValue), "200OK").create();
        Mockito.when(securityContext.getAuthentication()).thenReturn(new JwtAuthenticationToken(jwt, null));
        SecurityContextHolder.setContext(securityContext);

        // 👉 When
        final UserAuthenticationDomain userAuthenticationDomain =
                oauth2AuthenticationSpi.getCurrentUserAuthentication();

        // ✅ Then
        assertThat(userAuthenticationDomain).isNotNull();
        assertThat(userAuthenticationDomain.sub()).isEqualTo("google-oauth2|123456789");
        assertThat(userAuthenticationDomain.email()).isEqualTo("toto@email.com");
        assertThat(userAuthenticationDomain.fullName()).isEqualTo("totoName");
        assertThat(userAuthenticationDomain.nickname()).isEqualTo("totoNickname");
    }

    @Test
    void get_current_user_authentication_401() {
        // ⚙ Given that
        final SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        final Jwt jwt =
                Instancio.of(Jwt.class).set(field(Jwt::getTokenValue), "401NOK").create();
        Mockito.when(securityContext.getAuthentication()).thenReturn(new JwtAuthenticationToken(jwt, null));
        SecurityContextHolder.setContext(securityContext);

        // 👉 When
        assertThatExceptionOfType(Auth0ErrorException.class)
                .isThrownBy(() -> oauth2AuthenticationSpi.getCurrentUserAuthentication());
    }
}
