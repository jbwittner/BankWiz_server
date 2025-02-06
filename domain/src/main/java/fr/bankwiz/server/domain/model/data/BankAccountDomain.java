package fr.bankwiz.server.domain.model.data;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record BankAccountDomain(
        @NotNull UUID id,
        @NotBlank String accountName,
        @NotNull CurrencyDomain currency,
        @NotNull Integer initialDecimalBalance,
        @NotNull UserDomain user) {

    public BankAccountDomain updateAccount(String newAccountName, CurrencyDomain newCurrency, Integer newBalance) {
        return new BankAccountDomain(
                this.id,
                newAccountName != null ? newAccountName : this.accountName,
                newCurrency != null ? newCurrency : this.currency,
                newBalance != null ? newBalance : this.initialDecimalBalance,
                this.user);
    }
}
