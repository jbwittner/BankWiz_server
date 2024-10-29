package fr.bankwiz.server.domain.model.data;

import java.util.UUID;

import lombok.Builder;

@Builder
public record UserDomain(UUID id, String authId, String nickName, String email, String fullName) {}
