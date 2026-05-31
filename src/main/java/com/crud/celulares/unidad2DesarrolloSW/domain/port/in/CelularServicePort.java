package com.crud.celulares.unidad2DesarrolloSW.domain.port.in;

import com.crud.celulares.unidad2DesarrolloSW.domain.model.Celular;
import java.util.List;

public interface CelularServicePort {
    List<Celular> listarCelulares();
    Celular buscarCelular(Long id);
    Celular crearCelular(Celular celular);
    Celular actualizarCelular(Long id, Celular celular);
    void eliminarCelular(Long id);
}
