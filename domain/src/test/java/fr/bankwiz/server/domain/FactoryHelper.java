package fr.bankwiz.server.domain;

import org.instancio.Instancio;

import fr.bankwiz.server.domain.model.data.CurrencyDomain;
import fr.bankwiz.server.domain.model.data.UserDomain;

import static org.instancio.Select.field;

public class FactoryHelper {

    private FactoryHelper() {
        // Utility class
    }

    public static UserDomain createUserDomain() {
        return Instancio.create(UserDomain.class);
    }

    public static CurrencyDomain createCurrencyDomain() {
        return Instancio.of(CurrencyDomain.class)
                .generate(field("isoCode"), gen -> gen.text().pattern("[A-Z]{3}"))
                .create();
    }
}
