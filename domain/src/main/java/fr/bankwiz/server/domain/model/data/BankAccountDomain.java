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
        @NotNull UserDomain user) {}
