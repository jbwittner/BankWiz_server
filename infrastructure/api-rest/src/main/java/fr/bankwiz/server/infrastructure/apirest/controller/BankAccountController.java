package fr.bankwiz.server.infrastructure.apirest.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.BankAccountCreationRequestDTO;
import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.BankAccountDTO;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Bank Account", description = "Bank Account API")
@RequestMapping(Endpoints.BankAccount.BASE)
public interface BankAccountController {

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BankAccountDTO> create(@RequestBody BankAccountCreationRequestDTO bankAccountCreationRequest);
}
