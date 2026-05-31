package com.crud.celulares.unidad2DesarrolloSW.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private String cedula;
    private String clave;
    private String nombre;
    private String email;
}
