package fr.bankwiz.server.infrastructure.apirest.spi;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.bankwiz.server.domain.model.data.UserAuthenticationDomain;
import fr.bankwiz.server.infrastructure.apirest.exception.Auth0ErrorException;

@Component
public class Oauth2AuthenticationSpi {

    private final String issuer;
    private final ObjectMapper objectMapper;

    public Oauth2AuthenticationSpi(
            @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}") final String issuer,
            final ObjectMapper objectMapper) {
        this.issuer = issuer;
        this.objectMapper = objectMapper;
    }

    public UserAuthenticationDomain getCurrentUserAuthentication() {
        final String accessToken = this.getAuthentication().getToken().getTokenValue();
        final String url = this.issuer + "userinfo";
        final Oauth2AuthenticationSpi.Auth0IdData idData =
                this.sampleApiRequest(url, accessToken, Oauth2AuthenticationSpi.Auth0IdData.class);
        return new UserAuthenticationDomain(idData.sub(), idData.email(), idData.fullName(), idData.nickname());
    }

    private JwtAuthenticationToken getAuthentication() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (JwtAuthenticationToken) authentication;
    }

    private <T> T sampleApiRequest(final String url, final String token, final Class<T> valueType) {

        final HttpClient client = HttpClient.newHttpClient();
        final T result;

        try {
            final HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(url))
                    .header("Authorization", "Bearer " + token)
                    .GET()
                    .build();
            final var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            result = objectMapper.readValue(response.body(), valueType);
        } catch (final InterruptedException e) {
            Thread.currentThread().interrupt();
            client.close();
            throw new Auth0ErrorException(e);
        } catch (final URISyntaxException | IOException e) {
            client.close();
            throw new Auth0ErrorException(e);
        }

        client.close();
        return result;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Auth0IdData(
            String sub,
            @JsonProperty("given_name") String firstName,
            @JsonProperty("family_name") String lastName,
            @JsonProperty("name") String fullName,
            String nickname,
            String email) {}
}
