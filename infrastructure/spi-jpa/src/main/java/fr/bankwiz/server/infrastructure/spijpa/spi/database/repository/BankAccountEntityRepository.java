package fr.bankwiz.server.infrastructure.spijpa.spi.database.repository;

import fr.bankwiz.server.infrastructure.spijpa.spi.database.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BankAccountEntityRepository extends JpaRepository<BankAccountEntity, UUID> {
}
