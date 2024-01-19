package com.app.cafiagro.controller;
import com.app.cafiagro.database.Transaccion;
import com.app.cafiagro.database.TransaccionRepository;
import com.app.cafiagro.dto.TransaccionDTO;
import com.app.cafiagro.service.TransaccionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping(path = "/api/v1/transaccion")
public class TransaccionController {

    final int RESTA_ULTIMO_NUMERO_SECUENCIA = 1;
    private TransaccionService transaccionService;

    private TransaccionRepository transaccionRepository;

    @GetMapping(path = ("ver-transacciones"))
    public List<Transaccion> verTransacciones(){
        return transaccionService.verTransacciones();
    }

    @PostMapping(path = ("realizar-transaccion"))
    public String realizarTransaccion(@RequestBody TransaccionDTO transaccionDTO){
        transaccionService.realizarTransaccion(transaccionDTO);
        log.info("Se realizo la transaccion No. " + transaccionRepository.getNextValTransaccion() + ". Tipo de cafe: " + transaccionDTO.getTipoCafeEnum() + ". ID comprador: " +  transaccionDTO.getIdComprador() + ". Nombre comprador: " + transaccionDTO.getNombreComprador() + ". ID vendedor: " + transaccionDTO.getIdVendendor() + ". Cantidad Kg: " + transaccionDTO.getCantidadKg() + ". Valor Kg: " + transaccionDTO.getValorKg() + ". Valor prestamo: " + transaccionDTO.getValorPrestamo() + ". Numero de tulas: " + transaccionDTO.getNumeroTulas() + ". Total factura: " + (transaccionDTO.getCantidadKg()*transaccionDTO.getValorKg()) + ". Hora: " + LocalDateTime.now() + ".");
        return null;
    }

}
