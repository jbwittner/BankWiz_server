package fr.bankwiz.server.infrastructure.apirest.configuration;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

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
        servers = @Server(url = "${application.web.url}"),
        info =
                @Info(
                        title = "${application.general.title}",
                        version = "${application.general.version}",
                        description = "${application.general.description}",
                        license =
                                @License(
                                        name = "${application.general.license}",
                                        url = "${application.general.license-url}"),
                        contact = @Contact(email = "jeanbaptiste.wittner@outlook.com", name = "WITTNER Jean-Baptiste")))
public class OpenApiConfiguration {}
