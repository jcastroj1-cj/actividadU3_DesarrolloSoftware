package com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.out.jpa;

import com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.out.jpa.entity.CelularEntity;
import org.springframework.data.repository.CrudRepository;

public interface CelularJpaRepository extends CrudRepository<CelularEntity, Long> {
}
