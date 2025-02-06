package fr.bankwiz.server.domain.spi;

import java.util.List;
import java.util.UUID;

import fr.bankwiz.server.domain.model.data.BankAccountDomain;
import fr.bankwiz.server.domain.model.data.UserDomain;

public interface BankAccountDomainSpi extends BaseDomainSpi<BankAccountDomain, UUID> {
    List<BankAccountDomain> findByUser(UserDomain userDomain);
}
