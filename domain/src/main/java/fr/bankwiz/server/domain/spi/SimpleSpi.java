package fr.bankwiz.server.domain.spi;

import java.util.List;

import fr.bankwiz.server.domain.model.data.SimpleData;

public interface SimpleSpi {

    List<SimpleData> getAll();
}
