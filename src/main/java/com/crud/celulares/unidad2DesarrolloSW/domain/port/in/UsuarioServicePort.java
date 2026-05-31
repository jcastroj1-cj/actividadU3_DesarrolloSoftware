package com.crud.celulares.unidad2DesarrolloSW.domain.port.in;

import com.crud.celulares.unidad2DesarrolloSW.domain.model.Usuario;
import java.util.List;

public interface UsuarioServicePort {
    List<Usuario> listarUsuarios();
    Usuario buscarUsuario(String cedula);
    Usuario crearUsuario(Usuario usuario);
    Usuario actualizarUsuario(String cedula, Usuario usuario);
    void eliminarUsuario(String cedula);
}
