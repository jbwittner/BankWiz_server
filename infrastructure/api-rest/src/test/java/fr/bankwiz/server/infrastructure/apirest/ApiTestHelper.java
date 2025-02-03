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

import com.fasterxml.jackson.core.type.TypeReference;
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

    public record ResultCall<T>(T result, HttpStatus httpStatus) {}

    private <T> ResultCall<T> getRequest(
            final String url, final Class<T> classResult, final Boolean authenticated, final String... scopes) {

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

            final int statusCode = mvcResult.getResponse().getStatus();

            final HttpStatus httpStatus = HttpStatus.valueOf(statusCode);

            final String resultAsString = mvcResult.getResponse().getContentAsString();

            final Object result;

            if (String.class.equals(classResult)) {
                result = resultAsString;
            } else if (Void.class.equals(classResult)) {
                result = null;
            } else {
                result = objectMapper.readValue(resultAsString, classResult);
            }

            return new ResultCall<>((T) result, httpStatus);

        } catch (final Exception e) {
            Assertions.fail(String.valueOf(e));
            return null;
        }
    }

    private <T> ResultCall<T> getRequest(
            final String url, final TypeReference<T> type, final Boolean authenticated, final String... scopes) {

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

            final int statusCode = mvcResult.getResponse().getStatus();

            final HttpStatus httpStatus = HttpStatus.valueOf(statusCode);

            final String resultAsString = mvcResult.getResponse().getContentAsString();

            final Object result;

            if (String.class.equals(type.getType())) {
                result = resultAsString;
            } else if (Void.class.equals(type.getType())) {
                result = null;
            } else {
                result = objectMapper.readValue(resultAsString, type);
            }

            return new ResultCall<>((T) result, httpStatus);

        } catch (final Exception e) {
            Assertions.fail(String.valueOf(e));
            return null;
        }
    }

    public <T> ResultCall<T> getRequest(final String url, final Class<T> classResult, final String... scopes) {
        return this.getRequest(url, classResult, true, scopes);
    }

    public <T> ResultCall<T> getRequest(final String url, final TypeReference<T> type, final String... scopes) {
        return this.getRequest(url, type, true, scopes);
    }

    public ResultCall<Void> getRequest(final String url, final String... scopes) {
        return this.getRequest(url, Void.class, true, scopes);
    }

    public ResultCall<Void> getRequestWithoutAuthentication(final String url) {
        return this.getRequest(url, Void.class, false);
    }
}
