package fr.bankwiz.server.infrastructure.apirest;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;

@Component
public class ApiTestHelper {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mvc;

    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    private <T> T getRequest(
            final String url,
            final HttpStatus httpStatus,
            final Class<T> T,
            final Boolean authenticated,
            final String... scopes) {
        try {

            final MockHttpServletRequestBuilder builder;

            if (authenticated) {

                final var authorities =
                        Arrays.stream(scopes).map(SimpleGrantedAuthority::new).toArray(SimpleGrantedAuthority[]::new);
                final SecurityMockMvcRequestPostProcessors.JwtRequestPostProcessor jwtRequestPostProcessor =
                        jwt().authorities(authorities);
                builder = MockMvcRequestBuilders.get(url).with(jwtRequestPostProcessor);
            } else {
                builder = MockMvcRequestBuilders.get(url);
            }

            final var mvcResult = this.mvc.perform(builder).andReturn();

            final Integer statusCode = mvcResult.getResponse().getStatus();

            Assertions.assertThat(statusCode).isEqualTo(httpStatus.value());

            final String resultAsString = mvcResult.getResponse().getContentAsString();

            if (String.class.equals(T)) {
                return (T) resultAsString;
            } else if (Void.class.equals(T)) {
                return null;
            } else {
                return objectMapper.readValue(resultAsString, T);
            }

        } catch (final Exception e) {
            Assertions.fail(String.valueOf(e));
            return null;
        }
    }

    public <T> T getRequest(final String url, final HttpStatus httpStatus, final Class<T> T, final String... scopes) {
        return this.getRequest(url, httpStatus, T, true, scopes);
    }

    public void getRequest(final String url, final HttpStatus httpStatus, final String... scopes) {
        this.getRequest(url, httpStatus, Void.class, true, scopes);
    }

    public void getRequestWithoutAuthentication(final String url, final HttpStatus httpStatus) {
        this.getRequest(url, httpStatus, Void.class, false);
    }
}
