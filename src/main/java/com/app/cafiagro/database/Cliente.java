package com.app.cafiagro.database;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencia_cliente")
    @SequenceGenerator(name = "secuencia_cliente", sequenceName = "secuencia_cliente", allocationSize = 1, initialValue = 1000)
    private Long id;

    private String cedula;

    private String nombre;

    private String telefono;

    private String direccion;

    private String municipio;

}

