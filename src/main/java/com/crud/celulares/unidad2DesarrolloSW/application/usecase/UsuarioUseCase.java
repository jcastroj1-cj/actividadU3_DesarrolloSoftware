package com.crud.celulares.unidad2DesarrolloSW.application.usecase;

import com.crud.celulares.unidad2DesarrolloSW.domain.model.Usuario;
import com.crud.celulares.unidad2DesarrolloSW.domain.port.in.UsuarioServicePort;
import com.crud.celulares.unidad2DesarrolloSW.domain.port.out.UsuarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioUseCase implements UsuarioServicePort {

    private final UsuarioRepositoryPort usuarioRepository;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarUsuario(String cedula) {
        return usuarioRepository.findById(cedula)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con cédula: " + cedula));
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getCedula())) {
            throw new RuntimeException("Ya existe un usuario con cédula: " + usuario.getCedula());
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(String cedula, Usuario usuario) {
        if (!usuarioRepository.existsById(cedula)) {
            throw new RuntimeException("Usuario no encontrado con cédula: " + cedula);
        }
        usuario.setCedula(cedula);
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(String cedula) {
        if (!usuarioRepository.existsById(cedula)) {
            throw new RuntimeException("Usuario no encontrado con cédula: " + cedula);
        }
        usuarioRepository.deleteById(cedula);
    }
}
