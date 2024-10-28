package fr.bankwiz.server.infrastructure.apirest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Status Service", description = "Status Service API")
@RequestMapping(Endpoints.Status.BASE)
public interface StatusController {

    @Operation(
            summary = "Public endpoint",
            description = "Public endpoint to check the status of the service",
            security = @SecurityRequirement(name = "security_auth"))
    @GetMapping(Endpoints.Status.PUBLIC)
    ResponseEntity<String> getPublicStatus();

    @Operation(
            summary = "Private endpoint",
            description = "Private endpoint to check the private status of the service",
            security = @SecurityRequirement(name = "security_auth"))
    @GetMapping(Endpoints.Status.PRIVATE)
    ResponseEntity<String> getPrivateStatus();

    @Operation(
            summary = "Admin endpoint",
            description = "Admin endpoint to check the admin status of the service",
            security = @SecurityRequirement(name = "security_auth"))
    @GetMapping(Endpoints.Status.ADMIN)
    ResponseEntity<String> getAdminStatus();
}
