package fr.bankwiz.server.domain.model.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CurrencyDomain(
        @NotBlank @Pattern(regexp = "[A-Z]{3}") String isoCode,
        @NotBlank String name,
        @NotBlank String symbol,
        int decimalDigits) {}
