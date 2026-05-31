package com.crud.celulares.unidad2DesarrolloSW.infrastructure.adapter.out.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity
@Table(name = "usuarios", catalog = "crudcelulares")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "cedula", nullable = false, length = 15)
    private String cedula;

    @Column(name = "clave")
    private String clave;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "email")
    private String email;
}
