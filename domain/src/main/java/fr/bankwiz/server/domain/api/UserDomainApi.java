package fr.bankwiz.server.domain.api;

import java.util.List;

import fr.bankwiz.server.domain.model.data.UserDomain;

public interface UserDomainApi {
    UserDomain authenticationUser();

    List<UserDomain> findAll();
}
