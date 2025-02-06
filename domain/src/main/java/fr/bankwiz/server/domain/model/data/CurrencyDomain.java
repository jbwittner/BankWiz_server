package fr.bankwiz.server.domain.model.data;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CurrencyDomain(
        @NotNull UUID id,
        @NotBlank String isoCode,
        @NotBlank String name,
        @NotBlank String symbol,
        @NotNull int decimalDigits) {}
