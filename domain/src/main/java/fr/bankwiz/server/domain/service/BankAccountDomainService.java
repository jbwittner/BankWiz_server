package fr.bankwiz.server.domain.service;

import java.util.List;
import java.util.UUID;

import fr.bankwiz.server.domain.annotation.DomainService;
import fr.bankwiz.server.domain.api.BankAccountDomainApi;
import fr.bankwiz.server.domain.exception.DataModelNotFound;
import fr.bankwiz.server.domain.model.data.BankAccountDomain;
import fr.bankwiz.server.domain.model.data.CurrencyDomain;
import fr.bankwiz.server.domain.model.data.UserDomain;
import fr.bankwiz.server.domain.model.request.BankAccountCreationRequest;
import fr.bankwiz.server.domain.model.request.BankAccountUpdateRequest;
import fr.bankwiz.server.domain.spi.AuthenticationSpi;
import fr.bankwiz.server.domain.spi.BankAccountDomainSpi;
import fr.bankwiz.server.domain.spi.CurrencyDomainSpi;
import fr.bankwiz.server.domain.tools.UUIDGenerator;
import fr.bankwiz.server.domain.tools.ValidatorUtil;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class BankAccountDomainService implements BankAccountDomainApi {
    private final AuthenticationSpi authenticationSpi;
    private final BankAccountDomainSpi bankAccountDomainSpi;
    private final CurrencyDomainSpi currencyDomainSpi;

    public BankAccountDomain createBankAccount(final BankAccountCreationRequest request) {
        ValidatorUtil.validate(request);

        final var currency = currencyDomainSpi
                .findByIsoCode(request.isoCurrencyCode())
                .orElseThrow(() -> new DataModelNotFound(CurrencyDomain.class, request.isoCurrencyCode()));
        final UserDomain user = authenticationSpi.getCurrentUser();

        final BankAccountDomain bankAccountDomain = BankAccountDomain.builder()
                .id(UUIDGenerator.generateUUID())
                .accountName(request.accountName())
                .currency(currency)
                .initialDecimalBalance(request.initialDecimalBalance())
                .user(user)
                .build();

        return this.bankAccountDomainSpi.save(bankAccountDomain);
    }

    @Override
    public BankAccountDomain getBankAccount(final UUID id) {
        return this.bankAccountDomainSpi
                .findById(id)
                .orElseThrow(() -> new DataModelNotFound(BankAccountDomain.class, id));
    }

    @Override
    public BankAccountDomain updateBankAccount(UUID id, BankAccountUpdateRequest request) {
        final BankAccountDomain bankAccountDomain = this.bankAccountDomainSpi
                .findById(id)
                .orElseThrow(() -> new DataModelNotFound(BankAccountDomain.class, id));

        CurrencyDomain newCurrency = null; // Default value

        if (request.isoCurrencyCode() != null) {
            newCurrency = this.currencyDomainSpi
                    .findByIsoCode(request.isoCurrencyCode())
                    .orElseThrow(() -> new DataModelNotFound(CurrencyDomain.class, request.isoCurrencyCode()));
        }

        final BankAccountDomain updatedAccount =
                bankAccountDomain.updateAccount(request.accountName(), newCurrency, request.initialDecimalBalance());

        return this.bankAccountDomainSpi.save(updatedAccount);
    }

    @Override
    public List<BankAccountDomain> getBankAccounts() {
        final var currentUser = this.authenticationSpi.getCurrentUser();
        return this.bankAccountDomainSpi.findByUser(currentUser);
    }
}
