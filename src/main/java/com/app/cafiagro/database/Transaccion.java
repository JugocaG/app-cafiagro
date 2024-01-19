package com.app.cafiagro.database;
import com.app.cafiagro.vo.TipoCafeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "transaccion")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "secuencia_transaccion")
    @SequenceGenerator(name = "secuencia_transaccion", sequenceName = "secuencia_transaccion", allocationSize = 1, initialValue = 1000)
    private Long idTransaccion;

    private TipoCafeEnum tipoCafeEnum;

    private Integer idComprador;

    private String nombreComprador;

    private Integer idVendendor;

    private Integer cantidadKg;

    private Integer valorKg;

    private Integer valorPrestamo;

    private Integer numeroTulas;

    private Integer totalFactura;


    private LocalDateTime fechaTransaccion;
}

