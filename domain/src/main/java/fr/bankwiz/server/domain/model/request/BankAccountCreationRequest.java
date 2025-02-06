package fr.bankwiz.server.domain.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BankAccountCreationRequest(
        @NotBlank String accountName, @NotBlank String isoCurrencyCode, @NotNull Integer initialDecimalBalance) {}
