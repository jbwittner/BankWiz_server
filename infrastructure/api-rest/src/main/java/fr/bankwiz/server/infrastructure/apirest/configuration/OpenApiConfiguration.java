package fr.bankwiz.server.infrastructure.apirest.configuration;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.OAuthScope;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

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
public class OpenApiConfiguration {

    @Bean
    OpenAPI customOpenAPI(@Value("${application.url}") final String applicationUrl) {

        final ArrayList<Server> servers = new ArrayList<>();
        servers.add(new Server().url(applicationUrl));
        return new OpenAPI()
                .components(new Components())
                .servers(servers)
                .info(new Info()
                        .title("Bankwiz API")
                        .description("Bankwiz - API Swagger documentation")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
