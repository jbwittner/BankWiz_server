package fr.bankwiz.server.domain.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record BankAccountCreationRequest(
        @NotBlank String accountName,
        @NotBlank @Pattern(regexp = "[A-Z]{3}") String isoCurrencyCode,
        @NotNull Integer initialDecimalBalance) {}
