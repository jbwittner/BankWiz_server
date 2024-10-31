package fr.bankwiz.server.domain;

import org.instancio.Instancio;

import fr.bankwiz.server.domain.model.data.UserDomain;

public class FactoryHelper {

    private FactoryHelper() {
        // Utility class
    }

    public static UserDomain createUserDomain() {
        return Instancio.create(UserDomain.class);
    }
}
