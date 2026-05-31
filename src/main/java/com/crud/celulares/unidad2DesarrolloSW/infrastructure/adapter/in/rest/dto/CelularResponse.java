package com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.in.rest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CelularResponse {
    private Long id;
    private String marca;
    private String imei;
    private Double pulgadas;
    private Double megapixeles;
    private String ram;
    private String almacenamientoPrincipal;
    private String almacenamientoSecundario;
    private String sistemaOperativo;
    private String operador;
    private String tecnologiaBanda;
    private Boolean wifi;
    private Boolean bluetooth;
    private Integer camaras;
    private String marcaCpu;
    private String velocidadCpu;
    private Boolean nfc;
    private Boolean huella;
    private Boolean ir;
    private Boolean resteAgua;
    private Integer cantidadSim;
}
