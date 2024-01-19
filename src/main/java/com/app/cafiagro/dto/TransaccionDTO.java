package com.app.cafiagro.dto;
import com.app.cafiagro.vo.TipoCafeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TransaccionDTO {

    private TipoCafeEnum tipoCafeEnum;

    private Integer idComprador;

    private String nombreComprador;

    private Integer idVendendor;

    private Integer cantidadKg;

    private Integer valorKg;

    private Integer totalFactura;

    private Integer valorPrestamo;

    private Integer numeroTulas;
}

