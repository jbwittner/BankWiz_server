package fr.bankwiz.server.domain.service;

import fr.bankwiz.server.domain.api.SimpleApi;
import fr.bankwiz.server.domain.spi.SimpleSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SimpleService implements SimpleApi {

    private final SimpleSpi simpleSpi;

    @Override
    public String sayHello() {
        final var all = simpleSpi.getAll();
        final StringBuilder sb = new StringBuilder();
        for (String s : all) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(s);
        }
        final String result = sb.toString();
        return result;
    }
}