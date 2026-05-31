package com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.out.jpa;

import com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.out.jpa.entity.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioJpaRepository extends CrudRepository<UsuarioEntity, String> {
}
