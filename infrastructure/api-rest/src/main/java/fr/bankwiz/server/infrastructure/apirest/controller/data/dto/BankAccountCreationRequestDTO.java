package fr.bankwiz.server.infrastructure.apirest.controller.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record BankAccountCreationRequestDTO(
        @NotBlank String accountName,
        @NotBlank String isoCurrencyCode,
        @NotNull Integer initialDecimalBalance
) {
}
