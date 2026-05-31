package com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.in.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioResponse {
    private String cedula;
    private String nombre;
    private String email;
}
