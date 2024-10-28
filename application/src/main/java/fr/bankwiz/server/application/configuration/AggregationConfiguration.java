package fr.bankwiz.server.application.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScans({
    @ComponentScan(basePackages = "fr.bankwiz.server.infrastructure.apirest"),
    @ComponentScan(basePackages = "fr.bankwiz.server.infrastructure.spijpa"),
})
@EntityScan("fr.bankwiz.server.infrastructure.spijpa.spi.database.entity")
@EnableJpaRepositories("fr.bankwiz.server.infrastructure.spijpa.spi.database.repository")
public class AggregationConfiguration {}