package com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.in.rest;

import com.crud.celulares.unidad2DesarrolloSW.domain.model.Celular;
import com.crud.celulares.unidad2DesarrolloSW.domain.port.in.CelularServicePort;
import com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.in.rest.dto.CelularRequest;
import com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.in.rest.dto.CelularResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/celulares")
@RequiredArgsConstructor
public class CelularRestController {

    private final CelularServicePort celularService;

    @GetMapping
    public ResponseEntity<List<CelularResponse>> listar() {
        return ResponseEntity.ok(celularService.listarCelulares().stream()
                .map(this::toResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CelularResponse> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(toResponse(celularService.buscarCelular(id)));
    }

    @PostMapping
    public ResponseEntity<CelularResponse> crear(@RequestBody CelularRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(toResponse(celularService.crearCelular(toModel(request))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CelularResponse> actualizar(@PathVariable Long id,
                                                       @RequestBody CelularRequest request) {
        return ResponseEntity.ok(toResponse(celularService.actualizarCelular(id, toModel(request))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        celularService.eliminarCelular(id);
        return ResponseEntity.noContent().build();
    }

    private Celular toModel(CelularRequest r) {
        Celular c = new Celular();
        c.setMarca(r.getMarca()); c.setImei(r.getImei());
        c.setPulgadas(r.getPulgadas()); c.setMegapixeles(r.getMegapixeles());
        c.setRam(r.getRam()); c.setAlmacenamientoPrincipal(r.getAlmacenamientoPrincipal());
        c.setAlmacenamientoSecundario(r.getAlmacenamientoSecundario());
        c.setSistemaOperativo(r.getSistemaOperativo()); c.setOperador(r.getOperador());
        c.setTecnologiaBanda(r.getTecnologiaBanda()); c.setWifi(r.getWifi());
        c.setBluetooth(r.getBluetooth()); c.setCamaras(r.getCamaras());
        c.setMarcaCpu(r.getMarcaCpu()); c.setVelocidadCpu(r.getVelocidadCpu());
        c.setNfc(r.getNfc()); c.setHuella(r.getHuella()); c.setIr(r.getIr());
        c.setResteAgua(r.getResteAgua()); c.setCantidadSim(r.getCantidadSim());
        return c;
    }

    private CelularResponse toResponse(Celular c) {
        return CelularResponse.builder()
                .id(c.getId()).marca(c.getMarca()).imei(c.getImei())
                .pulgadas(c.getPulgadas()).megapixeles(c.getMegapixeles())
                .ram(c.getRam()).almacenamientoPrincipal(c.getAlmacenamientoPrincipal())
                .almacenamientoSecundario(c.getAlmacenamientoSecundario())
                .sistemaOperativo(c.getSistemaOperativo()).operador(c.getOperador())
                .tecnologiaBanda(c.getTecnologiaBanda()).wifi(c.getWifi())
                .bluetooth(c.getBluetooth()).camaras(c.getCamaras())
                .marcaCpu(c.getMarcaCpu()).velocidadCpu(c.getVelocidadCpu())
                .nfc(c.getNfc()).huella(c.getHuella()).ir(c.getIr())
                .resteAgua(c.getResteAgua()).cantidadSim(c.getCantidadSim())
                .build();
    }
}
