package fr.bankwiz.server.domain.api;

import fr.bankwiz.server.domain.model.data.BankAccountDomain;
import fr.bankwiz.server.domain.model.request.BankAccountCreationRequest;

public interface BankAccountDomainApi {
    BankAccountDomain createBankAccount(BankAccountCreationRequest request);
}
