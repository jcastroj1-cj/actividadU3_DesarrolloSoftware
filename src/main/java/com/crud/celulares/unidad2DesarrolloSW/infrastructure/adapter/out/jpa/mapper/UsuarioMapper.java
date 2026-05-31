package com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.out.jpa.mapper;

import com.crud.celulares.unidad2DesarrolloSW.domain.model.Usuario;
import com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.out.jpa.entity.UsuarioEntity;

public class UsuarioMapper {

    public static Usuario toDomain(UsuarioEntity entity) {
        return Usuario.builder()
                .cedula(entity.getCedula())
                .clave(entity.getClave())
                .nombre(entity.getNombre())
                .email(entity.getEmail())
                .build();
    }

    public static UsuarioEntity toEntity(Usuario domain) {
        return UsuarioEntity.builder()
                .cedula(domain.getCedula())
                .clave(domain.getClave())
                .nombre(domain.getNombre())
                .email(domain.getEmail())
                .build();
    }
}
