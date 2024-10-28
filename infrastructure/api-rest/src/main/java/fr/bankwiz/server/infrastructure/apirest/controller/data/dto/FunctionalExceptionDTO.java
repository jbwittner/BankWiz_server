package fr.bankwiz.server.infrastructure.apirest.controller.data.dto;

import java.time.OffsetDateTime;
import java.util.Map;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FunctionalExceptionDTO(
        @NotBlank String exception,
        @NotNull Map<String, Object> attributes,
        @NotBlank String message,
        @NotNull @Valid OffsetDateTime timestamp) {}
