package fr.bankwiz.server.infrastructure.apirest.controller.impl;

import fr.bankwiz.server.domain.api.CurrencyDomainApi;
import fr.bankwiz.server.infrastructure.apirest.controller.CurrencyController;
import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.CurrencyDTO;
import fr.bankwiz.server.infrastructure.apirest.controller.data.mapper.RestCurrencyMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CurrencyControllerImpl implements CurrencyController {

    private final CurrencyDomainApi currencyDomainApi;
    private final RestCurrencyMapper restCurrencyMapper;

    @Override
    public ResponseEntity<List<CurrencyDTO>> getAll() {
        final var currency = this.currencyDomainApi.getCurrencies();
        final var dto = this.restCurrencyMapper.toCurrencyDTOs(currency);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
