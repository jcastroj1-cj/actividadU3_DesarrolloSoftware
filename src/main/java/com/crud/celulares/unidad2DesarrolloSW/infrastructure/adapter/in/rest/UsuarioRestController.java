package com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.in.rest;

import com.crud.celulares.unidad2DesarrolloSW.domain.model.Usuario;
import com.crud.celulares.unidad2DesarrolloSW.domain.port.in.UsuarioServicePort;
import com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.in.rest.dto.UsuarioRequest;
import com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.in.rest.dto.UsuarioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioRestController {

    private final UsuarioServicePort usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listar() {
        List<UsuarioResponse> lista = usuarioService.listarUsuarios().stream()
                .map(u -> UsuarioResponse.builder()
                        .cedula(u.getCedula())
                        .nombre(u.getNombre())
                        .email(u.getEmail())
                        .build())
                .toList();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{cedula}")
    public ResponseEntity<UsuarioResponse> buscar(@PathVariable String cedula) {
        Usuario u = usuarioService.buscarUsuario(cedula);
        return ResponseEntity.ok(UsuarioResponse.builder()
                .cedula(u.getCedula())
                .nombre(u.getNombre())
                .email(u.getEmail())
                .build());
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> crear(@RequestBody UsuarioRequest request) {
        Usuario u = usuarioService.crearUsuario(toModel(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioResponse.builder()
                .cedula(u.getCedula())
                .nombre(u.getNombre())
                .email(u.getEmail())
                .build());
    }

    @PutMapping("/{cedula}")
    public ResponseEntity<UsuarioResponse> actualizar(@PathVariable String cedula,
                                                       @RequestBody UsuarioRequest request) {
        Usuario u = usuarioService.actualizarUsuario(cedula, toModel(request));
        return ResponseEntity.ok(UsuarioResponse.builder()
                .cedula(u.getCedula())
                .nombre(u.getNombre())
                .email(u.getEmail())
                .build());
    }

    @DeleteMapping("/{cedula}")
    public ResponseEntity<Void> eliminar(@PathVariable String cedula) {
        usuarioService.eliminarUsuario(cedula);
        return ResponseEntity.noContent().build();
    }

    private Usuario toModel(UsuarioRequest r) {
        return Usuario.builder()
                .cedula(r.getCedula())
                .clave(r.getClave())
                .nombre(r.getNombre())
                .email(r.getEmail())
                .build();
    }
}
