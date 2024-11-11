package fr.bankwiz.server.infrastructure.apirest.configuration;

import java.util.ArrayList;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@Configuration
@SecurityScheme(
        name = "security_auth",
        type = SecuritySchemeType.OAUTH2,
        flows =
                @OAuthFlows(
                        implicit =
                                @OAuthFlow(
                                        authorizationUrl = "${application.oauth2.issuer-uri}"
                                                + "authorize?audience="
                                                + "${application.oauth2.audience}",
                                        scopes = {
                                            @OAuthScope(name = "openid", description = "openid scope"),
                                            @OAuthScope(name = "profile", description = "profile scope"),
                                            @OAuthScope(name = "email", description = "email scope")
                                        })))
@OpenAPIDefinition(
        info =
        @Info(
                title = "${application.title}",
                version = "${application.version}",
                description = "${application.description}",
                contact = @Contact(email = "jeanbaptiste.wittner@outlook.com", name = "WITTNER Jean-Baptiste")))
public class OpenApiConfiguration {
}
