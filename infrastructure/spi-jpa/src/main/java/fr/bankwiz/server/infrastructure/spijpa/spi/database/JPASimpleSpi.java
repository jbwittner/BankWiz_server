package fr.bankwiz.server.infrastructure.spijpa.spi.database;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.bankwiz.server.domain.spi.SimpleSpi;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.entity.SimpleEntity;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.repository.SimpleEntityRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JPASimpleSpi implements SimpleSpi {

    private final SimpleEntityRepository simpleEntityRepository;

    @Override
    public List<String> getAll() {
        return simpleEntityRepository.findAll().stream()
                .map(SimpleEntity::getSimpleData)
                .toList();
    }
}
