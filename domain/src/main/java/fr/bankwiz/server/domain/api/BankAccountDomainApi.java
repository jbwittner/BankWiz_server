package fr.bankwiz.server.domain.api;

import java.util.List;
import java.util.UUID;

import fr.bankwiz.server.domain.model.data.BankAccountDomain;
import fr.bankwiz.server.domain.model.request.BankAccountCreationRequest;
import fr.bankwiz.server.domain.model.request.BankAccountUpdateRequest;

public interface BankAccountDomainApi {
    BankAccountDomain createBankAccount(BankAccountCreationRequest request);

    BankAccountDomain getBankAccount(UUID id);

    BankAccountDomain updateBankAccount(UUID id, BankAccountUpdateRequest request);

    List<BankAccountDomain> getBankAccounts();
}
