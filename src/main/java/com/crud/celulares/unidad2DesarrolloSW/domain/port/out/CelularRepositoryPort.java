package com.crud.celulares.unidad2DesarrolloSW.domain.port.out;

import com.crud.celulares.unidad2DesarrolloSW.domain.model.Celular;
import java.util.List;
import java.util.Optional;

public interface CelularRepositoryPort {
    List<Celular> findAll();
    Optional<Celular> findById(Long id);
    Celular save(Celular celular);
    void deleteById(Long id);
    boolean existsById(Long id);
}
