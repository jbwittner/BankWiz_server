package fr.bankwiz.server.infrastructure.apirest.controller.data.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record UserDTO(
        @NotNull UUID id,
        @JsonProperty("auth_id") @NotBlank String authId,
        @JsonProperty("nick_name") @NotBlank String nickName,
        @NotBlank String email,
        @JsonProperty("full_name") @NotBlank String fullName) {}
