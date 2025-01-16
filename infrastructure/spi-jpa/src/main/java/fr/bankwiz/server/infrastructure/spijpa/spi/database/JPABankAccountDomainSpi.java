package fr.bankwiz.server.infrastructure.spijpa.spi.database;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Component;

import fr.bankwiz.server.domain.model.data.BankAccountDomain;
import fr.bankwiz.server.domain.spi.BankAccountDomainSpi;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.entity.BankAccountEntity;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.mapper.JPABankAccountMapper;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.repository.BankAccountEntityRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JPABankAccountDomainSpi implements BankAccountDomainSpi {

    private final JPABankAccountMapper jpaBankAccountMapper;
    private final BankAccountEntityRepository bankAccountEntityRepository;

    @Override
    public BankAccountDomain save(BankAccountDomain bankAccountDomain) {
        final BankAccountEntity entity = this.jpaBankAccountMapper.toBankAccountEntity(bankAccountDomain);
        final BankAccountEntity savedEntity = this.bankAccountEntityRepository.save(entity);
        return this.jpaBankAccountMapper.toBankAccountDomain(savedEntity);
    }

    @Override
    public Optional<BankAccountDomain> findById(UUID id) {
        return this.bankAccountEntityRepository.findById(id).map(this.jpaBankAccountMapper::toBankAccountDomain);
    }
}
