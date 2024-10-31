package fr.bankwiz.server.infrastructure.apirest.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import fr.bankwiz.server.domain.api.UserDomainApi;
import fr.bankwiz.server.infrastructure.apirest.controller.UserController;
import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.UserDTO;
import fr.bankwiz.server.infrastructure.apirest.controller.data.mapper.RESTUserDomainMapper;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserDomainApi userDomainApi;
    private final RESTUserDomainMapper restUserDomainMapper;

    @Override
    public ResponseEntity<UserDTO> authenticationUser() {
        final var result = this.userDomainApi.authenticationUser();
        final var userDTO = this.restUserDomainMapper.toDTO(result);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
