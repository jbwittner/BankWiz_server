package fr.bankwiz.server.infrastructure.spijpa.spi.database.mapper;

import org.mapstruct.Mapper;

import fr.bankwiz.server.domain.model.data.BankAccountDomain;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.entity.BankAccountEntity;

@Mapper(componentModel = "spring")
public interface JPABankAccountMapper {
    BankAccountEntity toBankAccountEntity(BankAccountDomain bankAccountDomain);

    BankAccountDomain toBankAccountDomain(BankAccountEntity bankAccountEntity);
}
