package com.app.cafiagro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ClienteDTO {
    private Long id;
    private String cedula;

    private String nombre;

    private String telefono;

    private String direccion;

    private String municipio;
}
