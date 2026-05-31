package com.crud.celulares.unidad2DesarrolloSW.domain.port.out;

import com.crud.celulares.unidad2DesarrolloSW.domain.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepositoryPort {
    List<Usuario> findAll();
    Optional<Usuario> findById(String cedula);
    Usuario save(Usuario usuario);
    void deleteById(String cedula);
    boolean existsById(String cedula);
}
