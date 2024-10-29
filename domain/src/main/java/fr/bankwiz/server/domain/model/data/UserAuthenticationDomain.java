package fr.bankwiz.server.domain.model.data;

import lombok.Builder;

@Builder
public record UserAuthenticationDomain(String sub, String email, String fullName, String nickname) {}
