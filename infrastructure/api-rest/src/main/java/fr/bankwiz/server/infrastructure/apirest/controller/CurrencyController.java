package fr.bankwiz.server.infrastructure.apirest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.CurrencyDTO;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Currency", description = "Currency API")
@RequestMapping(Endpoints.Currency.BASE)
public interface CurrencyController {

    @GetMapping(Endpoints.Currency.GET_ALL)
    ResponseEntity<List<CurrencyDTO>> getAll();
}
