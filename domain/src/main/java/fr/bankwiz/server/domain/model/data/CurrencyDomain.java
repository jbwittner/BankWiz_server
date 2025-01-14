package fr.bankwiz.server.domain.model.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CurrencyDomain(
        @NotBlank String isoCode,
        @NotBlank String name,
        @NotBlank String symbol,
        @NotNull int decimalDigits) {}
