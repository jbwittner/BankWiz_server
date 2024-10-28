package fr.bankwiz.server.infrastructure.spijpa.spi.database.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.bankwiz.server.infrastructure.spijpa.spi.database.entity.SimpleEntity;

public interface SimpleEntityRepository extends JpaRepository<SimpleEntity, UUID> {}
