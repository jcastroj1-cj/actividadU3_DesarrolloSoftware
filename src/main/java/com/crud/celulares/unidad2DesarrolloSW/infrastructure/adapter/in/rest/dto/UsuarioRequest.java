package com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.in.rest.dto;

import lombok.Data;

@Data
public class UsuarioRequest {
    private String cedula;
    private String clave;
    private String nombre;
    private String email;
}
