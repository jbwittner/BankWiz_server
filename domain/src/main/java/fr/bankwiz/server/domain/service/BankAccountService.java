package fr.bankwiz.server.domain.service;

import fr.bankwiz.server.domain.annotation.DomainService;
import fr.bankwiz.server.domain.spi.BankAccountDomainSpi;
import fr.bankwiz.server.domain.spi.CurrencyDomainSpi;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class BankAccountService {
    private final BankAccountDomainSpi bankAccountDomainSpi;
    private final CurrencyDomainSpi currencyDomainSpi;

    public void createBankAccount(String accountNumber, String currencyCode) {}
}
