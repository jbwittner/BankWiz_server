package fr.bankwiz.server.infrastructure.apirest.controller.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import fr.bankwiz.server.domain.api.UserDomainApi;
import fr.bankwiz.server.infrastructure.apirest.controller.UserController;
import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.UserDTO;
import fr.bankwiz.server.infrastructure.apirest.controller.data.mapper.RestUserMapper;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserDomainApi userDomainApi;
    private final RestUserMapper restUserMapper;

    @Override
    public ResponseEntity<UserDTO> authenticationUser() {
        final var result = this.userDomainApi.authenticationUser();
        final var userDTO = this.restUserMapper.toUserDTO(result);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        final var result = this.userDomainApi.findAll();
        final var userDTOs = this.restUserMapper.toUserDTO(result);
        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }
}
