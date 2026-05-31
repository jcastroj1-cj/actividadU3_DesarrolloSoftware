package com.crud.celulares.unidad2DesarrolloSW.application.usecase;

import com.crud.celulares.unidad2DesarrolloSW.domain.model.Celular;
import com.crud.celulares.unidad2DesarrolloSW.domain.port.in.CelularServicePort;
import com.crud.celulares.unidad2DesarrolloSW.domain.port.out.CelularRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CelularUseCase implements CelularServicePort {

    private final CelularRepositoryPort celularRepository;

    @Override
    public List<Celular> listarCelulares() {
        return celularRepository.findAll();
    }

    @Override
    public Celular buscarCelular(Long id) {
        return celularRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Celular no encontrado con id: " + id));
    }

    @Override
    public Celular crearCelular(Celular celular) {
        return celularRepository.save(celular);
    }

    @Override
    public Celular actualizarCelular(Long id, Celular celular) {
        if (!celularRepository.existsById(id)) {
            throw new RuntimeException("Celular no encontrado con id: " + id);
        }
        celular.setId(id);
        return celularRepository.save(celular);
    }

    @Override
    public void eliminarCelular(Long id) {
        if (!celularRepository.existsById(id)) {
            throw new RuntimeException("Celular no encontrado con id: " + id);
        }
        celularRepository.deleteById(id);
    }
}
