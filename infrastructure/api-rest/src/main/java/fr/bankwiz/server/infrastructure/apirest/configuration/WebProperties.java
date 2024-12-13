package fr.bankwiz.server.infrastructure.apirest.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "application.web")
public class WebProperties {
    private List<String> corsAllowedOrigins;
}
