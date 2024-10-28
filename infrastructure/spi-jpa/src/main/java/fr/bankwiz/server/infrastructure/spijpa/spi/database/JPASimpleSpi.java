package fr.bankwiz.server.infrastructure.spijpa.spi.database;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.bankwiz.server.domain.model.data.SimpleData;
import fr.bankwiz.server.domain.spi.SimpleSpi;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.mapper.JPASimpleDataMapper;
import fr.bankwiz.server.infrastructure.spijpa.spi.database.repository.SimpleEntityRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JPASimpleSpi implements SimpleSpi {

    private final JPASimpleDataMapper jpaSimpleDataMapper;
    private final SimpleEntityRepository simpleEntityRepository;

    @Override
    public List<SimpleData> getAll() {
        return simpleEntityRepository.findAll().stream()
                .map(jpaSimpleDataMapper::toSimpleData)
                .toList();
    }
}
