package fr.bankwiz.server.domain.model.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CurrencyDomain(@NotBlank @Size(min = 2, max = 4) String isoCode, @NotBlank String name, @NotBlank String symbol, int decimalDigits) {}
