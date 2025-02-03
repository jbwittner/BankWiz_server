package fr.bankwiz.server.infrastructure.apirest.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import fr.bankwiz.server.domain.api.BankAccountDomainApi;
import fr.bankwiz.server.domain.model.data.BankAccountDomain;
import fr.bankwiz.server.domain.model.request.BankAccountCreationRequest;
import fr.bankwiz.server.infrastructure.apirest.controller.BankAccountController;
import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.BankAccountCreationRequestDTO;
import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.BankAccountDTO;
import fr.bankwiz.server.infrastructure.apirest.controller.data.mapper.RestBankAccountMapper;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class BankAccountControllerImpl implements BankAccountController {

    private final BankAccountDomainApi bankAccountDomainApi;
    private final RestBankAccountMapper restBankAccountMapper;

    @Override
    public ResponseEntity<BankAccountDTO> create(final BankAccountCreationRequestDTO bankAccountCreationRequest) {
        final BankAccountCreationRequest requestDomain =
                this.restBankAccountMapper.toBankAccountCreationRequest(bankAccountCreationRequest);
        final BankAccountDomain bankAccountDomain = bankAccountDomainApi.createBankAccount(requestDomain);
        final BankAccountDTO bankAccountDTO = this.restBankAccountMapper.toBankAccountDTO(bankAccountDomain);
        return new ResponseEntity<>(bankAccountDTO, HttpStatus.CREATED);
    }
}
