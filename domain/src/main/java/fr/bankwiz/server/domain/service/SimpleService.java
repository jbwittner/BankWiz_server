package fr.bankwiz.server.domain.service;

import java.util.List;

import fr.bankwiz.server.domain.api.SimpleApi;
import fr.bankwiz.server.domain.model.data.SimpleData;
import fr.bankwiz.server.domain.spi.SimpleSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SimpleService implements SimpleApi {

    private final SimpleSpi simpleSpi;

    @Override
    public List<SimpleData> sayHello() {
        return simpleSpi.getAll();
    }
}
