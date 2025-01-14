package fr.bankwiz.server.domain.model.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CurrencyDomain(
        @NotBlank String isoCode, @NotBlank String name, @NotBlank String symbol, @NotNull int decimalDigits) {}
