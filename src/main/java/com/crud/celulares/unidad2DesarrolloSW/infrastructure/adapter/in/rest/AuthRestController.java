package com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.in.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthRestController {

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(Authentication authentication) {
        return ResponseEntity.ok(Map.of(
                "mensaje", "Login exitoso",
                "usuario", authentication.getName()
        ));
    }
}
