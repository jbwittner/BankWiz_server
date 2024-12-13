package fr.bankwiz.server.infrastructure.apirest.configuration;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "application.web")
public class WebProperties {
    private List<String> corsAllowedOrigins;
}
