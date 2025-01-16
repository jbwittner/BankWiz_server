package fr.bankwiz.server.infrastructure.spijpa.spi.database.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.bankwiz.server.infrastructure.spijpa.spi.database.entity.BankAccountEntity;

public interface BankAccountEntityRepository extends JpaRepository<BankAccountEntity, UUID> {}
