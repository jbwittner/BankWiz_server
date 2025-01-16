package fr.bankwiz.server.infrastructure.spijpa.spi.database.mapper;

import fr.bankwiz.server.domain.model.data.BankAccountDomain;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.entity.BankAccountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JPABankAccountMapper {
    BankAccountEntity toBankAccountEntity(BankAccountDomain bankAccountDomain);
    BankAccountDomain toBankAccountDomain(BankAccountEntity bankAccountEntity);
}
