package fr.bankwiz.server.infrastructure.apirest.controller;

import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.CurrencyDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Bank Account", description = "Bank Account API")
@RequestMapping(Endpoints.Currency.BASE)
public interface CurrencyController {

    @GetMapping()
    ResponseEntity<List<CurrencyDTO>> getAll();

}
