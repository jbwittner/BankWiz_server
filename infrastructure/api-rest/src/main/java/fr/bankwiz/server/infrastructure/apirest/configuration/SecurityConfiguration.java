package fr.bankwiz.server.infrastructure.apirest.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        final JwtGrantedAuthoritiesConverter converter = new JwtGrantedAuthoritiesConverter();
        converter.setAuthoritiesClaimName("permissions");
        converter.setAuthorityPrefix("SCOPE_");

        final JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
        jwtConverter.setJwtGrantedAuthoritiesConverter(converter);
        return jwtConverter;
    }

    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http, final WebProperties webProperties)
            throws Exception {

        if(webProperties.isEnableCors()){
            http.cors(cors -> cors.configurationSource(corsConfigurationSource(webProperties)));
        }

        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                "/status/public",
                                "/v3/api-docs/**",
                                "/v3/api-docs.yaml",
                                "/swagger-ui/**",
                                "/actuator/**")
                        .permitAll()
                        .requestMatchers("/status/admin")
                        .hasAuthority("SCOPE_admin:configuration")
                        .anyRequest()
                        .authenticated())
                .oauth2ResourceServer(
                        oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())));
        return http.build();
    }

    @Bean
    @Primary
    CorsConfigurationSource corsConfigurationSource(final WebProperties webProperties) {

        final CorsConfiguration configuration = new CorsConfiguration();
        final List<String> allowedOriginList = new ArrayList<>(webProperties.getCorsAllowedOrigins());
        configuration.setAllowedOrigins(allowedOriginList);
        configuration.setAllowedMethods(List.of("*"));
        configuration.setAllowedHeaders(List.of("*"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
