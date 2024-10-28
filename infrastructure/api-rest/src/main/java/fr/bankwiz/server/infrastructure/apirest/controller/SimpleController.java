package fr.bankwiz.server.infrastructure.apirest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.bankwiz.server.domain.api.SimpleApi;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/simple")
@RequiredArgsConstructor
public class SimpleController {

    private final SimpleApi simpleApi;

    @GetMapping
    public ResponseEntity<String> simple() {
        final var result = simpleApi.sayHello();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
