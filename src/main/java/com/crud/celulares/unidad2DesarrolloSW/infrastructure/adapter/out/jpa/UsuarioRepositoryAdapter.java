package com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.out.jpa;

import com.crud.celulares.unidad2DesarrolloSW.domain.model.Usuario;
import com.crud.celulares.unidad2DesarrolloSW.domain.port.out.UsuarioRepositoryPort;
import com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.out.jpa.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository jpaRepository;

    @Override
    public List<Usuario> findAll() {
        return StreamSupport.stream(jpaRepository.findAll().spliterator(), false)
                .map(UsuarioMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Usuario> findById(String cedula) {
        return jpaRepository.findById(cedula).map(UsuarioMapper::toDomain);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return UsuarioMapper.toDomain(jpaRepository.save(UsuarioMapper.toEntity(usuario)));
    }

    @Override
    public void deleteById(String cedula) {
        jpaRepository.deleteById(cedula);
    }

    @Override
    public boolean existsById(String cedula) {
        return jpaRepository.existsById(cedula);
    }
}
