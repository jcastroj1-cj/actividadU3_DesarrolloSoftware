package com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.out.jpa.mapper;

import com.crud.celulares.unidad2DesarrolloSW.domain.model.Celular;
import com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.out.jpa.entity.CelularEntity;

public class CelularMapper {

    public static Celular toDomain(CelularEntity e) {
        Celular c = new Celular();
        c.setId(e.getId());
        c.setMarca(e.getMarca());
        c.setImei(e.getImei());
        c.setPulgadas(e.getPulgadas());
        c.setMegapixeles(e.getMegapixeles());
        c.setRam(e.getRam());
        c.setAlmacenamientoPrincipal(e.getAlmacenamientoPrincipal());
        c.setAlmacenamientoSecundario(e.getAlmacenamientoSecundario());
        c.setSistemaOperativo(e.getSistemaOperativo());
        c.setOperador(e.getOperador());
        c.setTecnologiaBanda(e.getTecnologiaBanda());
        c.setWifi(e.getWifi());
        c.setBluetooth(e.getBluetooth());
        c.setCamaras(e.getCamaras());
        c.setMarcaCpu(e.getMarcaCpu());
        c.setVelocidadCpu(e.getVelocidadCpu());
        c.setNfc(e.getNfc());
        c.setHuella(e.getHuella());
        c.setIr(e.getIr());

        c.setResteAgua(e.getResisteAgua()); // ← corregido

        c.setCantidadSim(e.getCantidadSim());
        return c;
    }

    public static CelularEntity toEntity(Celular d) {
        CelularEntity e = new CelularEntity();
        e.setId(d.getId());
        e.setMarca(d.getMarca());
        e.setImei(d.getImei());
        e.setPulgadas(d.getPulgadas());
        e.setMegapixeles(d.getMegapixeles());
        e.setRam(d.getRam());
        e.setAlmacenamientoPrincipal(d.getAlmacenamientoPrincipal());
        e.setAlmacenamientoSecundario(d.getAlmacenamientoSecundario());
        e.setSistemaOperativo(d.getSistemaOperativo());
        e.setOperador(d.getOperador());
        e.setTecnologiaBanda(d.getTecnologiaBanda());
        e.setWifi(d.getWifi());
        e.setBluetooth(d.getBluetooth());
        e.setCamaras(d.getCamaras());
        e.setMarcaCpu(d.getMarcaCpu());
        e.setVelocidadCpu(d.getVelocidadCpu());
        e.setNfc(d.getNfc());
        e.setHuella(d.getHuella());
        e.setIr(d.getIr());

        e.setResisteAgua(d.getResteAgua()); // ← corregido

        e.setCantidadSim(d.getCantidadSim());
        return e;
    }
}
