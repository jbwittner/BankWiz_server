package fr.bankwiz.server.infrastructure.apirest.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import fr.bankwiz.server.infrastructure.apirest.ApiRestTestsBase;

class StatusControllerTest extends ApiRestTestsBase {

    final String base_url = "/" + Endpoints.Status.BASE + "/";

    @Test
    void public_unauthenticated() {
        final String url = base_url + Endpoints.Status.PUBLIC;
        final String value = this.apiTestHelper.getRequest(url, HttpStatus.OK, String.class);
        Assertions.assertThat(value).isEqualTo("Public_status_ok");
    }

    @Test
    void private_unauthenticated() {
        final String url = base_url + Endpoints.Status.PRIVATE;
        this.apiTestHelper.getRequestWithoutAuthentication(url, HttpStatus.UNAUTHORIZED);
    }

    @Test
    void admin_unauthenticated() {
        final String url = base_url + Endpoints.Status.ADMIN;
        this.apiTestHelper.getRequestWithoutAuthentication(url, HttpStatus.UNAUTHORIZED);
    }

    @Test
    void private_ok() {
        final String url = base_url + Endpoints.Status.PRIVATE;
        final String value = this.apiTestHelper.getRequest(url, HttpStatus.OK, String.class);
        Assertions.assertThat(value).isEqualTo("Private_status_ok");
    }

    @Test
    void admin_without_good_right() {
        final String url = base_url + Endpoints.Status.ADMIN;
        this.apiTestHelper.getRequest(url, HttpStatus.FORBIDDEN, "SCOPE_admin:other");
    }

    @Test
    void admin_ok() {
        final String url = base_url + Endpoints.Status.ADMIN;
        this.apiTestHelper.getRequest(url, HttpStatus.OK, String.class, "SCOPE_admin:configuration");
    }
}
