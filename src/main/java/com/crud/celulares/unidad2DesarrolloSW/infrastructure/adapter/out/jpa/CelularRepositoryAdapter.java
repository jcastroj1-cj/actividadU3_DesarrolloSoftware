package com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.out.jpa;

import com.crud.celulares.unidad2DesarrolloSW.domain.model.Celular;
import com.crud.celulares.unidad2DesarrolloSW.domain.port.out.CelularRepositoryPort;
import com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.out.jpa.mapper.CelularMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class CelularRepositoryAdapter implements CelularRepositoryPort {

    private final CelularJpaRepository jpaRepository;

    @Override
    public List<Celular> findAll() {
        return StreamSupport.stream(jpaRepository.findAll().spliterator(), false)
                .map(CelularMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Celular> findById(Long id) {
        return jpaRepository.findById(id).map(CelularMapper::toDomain);
    }

    @Override
    public Celular save(Celular celular) {
        return CelularMapper.toDomain(jpaRepository.save(CelularMapper.toEntity(celular)));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }
}
