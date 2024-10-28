package fr.bankwiz.server.infrastructure.apirest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.bankwiz.server.domain.api.SimpleApi;
import fr.bankwiz.server.infrastructure.apirest.controller.data.dto.SimpleDTO;
import fr.bankwiz.server.infrastructure.apirest.controller.data.mapper.RestSimpleDataMapper;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/simple")
@RequiredArgsConstructor
public class SimpleController {

    private final RestSimpleDataMapper restSimpleDataMapper;
    private final SimpleApi simpleApi;

    @GetMapping
    public ResponseEntity<List<SimpleDTO>> simple() {
        final var result = simpleApi.sayHello();
        final var dto = result.stream().map(restSimpleDataMapper::toSimpleDTO).toList();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
