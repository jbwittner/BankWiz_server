package fr.bankwiz.server.infrastructure.apirest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User Service", description = "User Service API")
@RequestMapping(Endpoints.User.BASE)
public interface UserController {

    @Operation(
            summary = "Authenticate user",
            description = "Authenticate user to the service",
            security = @SecurityRequirement(name = "security_auth"))
    @GetMapping(Endpoints.User.AUTHENTICATE)
    ResponseEntity<UserDTO> authenticationUser();
}
