package fr.bankwiz.server.domain.service;

import fr.bankwiz.server.domain.annotation.DomainService;
import fr.bankwiz.server.domain.exception.DataModelNotFound;
import fr.bankwiz.server.domain.model.data.BankAccountDomain;
import fr.bankwiz.server.domain.model.data.CurrencyDomain;
import fr.bankwiz.server.domain.model.request.BankAccountCreationRequest;
import fr.bankwiz.server.domain.spi.BankAccountDomainSpi;
import fr.bankwiz.server.domain.spi.CurrencyDomainSpi;
import fr.bankwiz.server.domain.tools.UUIDGenerator;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class BankAccountService {
    private final BankAccountDomainSpi bankAccountDomainSpi;
    private final CurrencyDomainSpi currencyDomainSpi;

    public BankAccountDomain createBankAccount(BankAccountCreationRequest request) {

        final var optionalCurrency = currencyDomainSpi.findByIsoCode(request.isoCurrencyCode());

        if (optionalCurrency.isEmpty()) {
            throw new DataModelNotFound(CurrencyDomain.class, request.isoCurrencyCode());
        }

        final var currency = optionalCurrency.get();
        final BankAccountDomain bankAccountDomain = BankAccountDomain.builder()
                .id(UUIDGenerator.generateUUID())
                .accountName(request.accountName())
                .currency(currency)
                .initialDecimalBalance(request.initialDecimalBalance())
                .build();

        return this.bankAccountDomainSpi.save(bankAccountDomain);
    }
}
