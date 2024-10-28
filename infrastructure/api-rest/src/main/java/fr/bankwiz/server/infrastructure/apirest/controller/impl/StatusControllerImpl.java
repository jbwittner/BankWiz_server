package fr.bankwiz.server.infrastructure.apirest.controller.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.bankwiz.server.infrastructure.apirest.controller.StatusController;

@RestController
public class StatusControllerImpl implements StatusController {

    @Override
    public ResponseEntity<String> getPublicStatus() {
        return new ResponseEntity<>("Public_status_ok", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getPrivateStatus() {
        return new ResponseEntity<>("Private_status_ok", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getAdminStatus() {
        return new ResponseEntity<>("Admin_status_ok", HttpStatus.OK);
    }
}
