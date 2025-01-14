package fr.bankwiz.server.infrastructure.apirest.controller.impl;

import fr.bankwiz.server.domain.api.BankAccountDomainApi;
import fr.bankwiz.server.domain.spi.BankAccountDomainSpi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import fr.bankwiz.server.domain.model.request.BankAccountCreationRequest;
import fr.bankwiz.server.domain.service.BankAccountService;
import fr.bankwiz.server.infrastructure.apirest.controller.BankAccountController;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BankAccountControllerImpl implements BankAccountController {

    private final BankAccountDomainApi bankAccountDomainApi;

    @Override
    public ResponseEntity<Void> getPublicStatus() {
        BankAccountCreationRequest bankAccountCreationRequest = new BankAccountCreationRequest("toto", "EURs", 1000);
        bankAccountDomainApi.createBankAccount(bankAccountCreationRequest);
        return null;
    }
}
