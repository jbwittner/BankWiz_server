package fr.bankwiz.server.infrastructure.apirest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Bank Account", description = "Bank Account API")
@RequestMapping(Endpoints.BankAccount.BASE)
public interface BankAccountController {

    @GetMapping()
    ResponseEntity<Void> getPublicStatus();
}
