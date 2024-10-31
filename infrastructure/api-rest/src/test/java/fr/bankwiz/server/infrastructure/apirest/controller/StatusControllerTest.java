package fr.bankwiz.server.infrastructure.apirest.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import fr.bankwiz.server.infrastructure.apirest.ApiRestTestsBase;

class StatusControllerTest extends ApiRestTestsBase {

    final String baseUrl = "/" + Endpoints.Status.BASE + "/";

    @Test
    void public_unauthenticated() {
        // ⚙ Given that
        final String url = baseUrl + Endpoints.Status.PUBLIC;

        // 👉 When
        final var resultCall = this.apiTestHelper.getRequest(url, String.class);

        // ✅ Then
        Assertions.assertThat(resultCall.httpStatus()).isEqualTo(HttpStatus.OK);
        Assertions.assertThat(resultCall.result()).isEqualTo("Public_status_ok");
    }

    @Test
    void private_unauthenticated() {
        // ⚙ Given that
        final String url = baseUrl + Endpoints.Status.PRIVATE;

        // 👉 When
        final var resultCall = this.apiTestHelper.getRequestWithoutAuthentication(url);

        // ✅ Then
        Assertions.assertThat(resultCall.httpStatus()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    void admin_unauthenticated() {
        // ⚙ Given that
        final String url = baseUrl + Endpoints.Status.ADMIN;

        // 👉 When
        final var resultCall = this.apiTestHelper.getRequestWithoutAuthentication(url);

        // ✅ Then
        Assertions.assertThat(resultCall.httpStatus()).isEqualTo(HttpStatus.UNAUTHORIZED);
    }

    @Test
    void private_ok() {
        // ⚙ Given that
        final String url = baseUrl + Endpoints.Status.PRIVATE;

        // 👉 When
        final var resultCall = this.apiTestHelper.getRequest(url, String.class);

        // ✅ Then
        Assertions.assertThat(resultCall.result()).isEqualTo("Private_status_ok");
        Assertions.assertThat(resultCall.httpStatus()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void admin_without_good_right() {
        // ⚙ Given that
        final String url = baseUrl + Endpoints.Status.ADMIN;

        // 👉 When
        final var resultCall = this.apiTestHelper.getRequest(url, "SCOPE_admin:other");

        // ✅ Then
        Assertions.assertThat(resultCall.httpStatus()).isEqualTo(HttpStatus.FORBIDDEN);
    }

    @Test
    void admin_ok() {
        // ⚙ Given that
        final String url = baseUrl + Endpoints.Status.ADMIN;

        // 👉 When
        final var resultCall = this.apiTestHelper.getRequest(url, String.class, "SCOPE_admin:configuration");

        // ✅ Then
        Assertions.assertThat(resultCall.result()).isEqualTo("Admin_status_ok");
        Assertions.assertThat(resultCall.httpStatus()).isEqualTo(HttpStatus.OK);
    }
}
