package com.app.cafiagro.service;

import com.app.cafiagro.database.Transaccion;
import com.app.cafiagro.database.TransaccionRepository;
import com.app.cafiagro.dto.TransaccionDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class TransaccionService {

    private TransaccionRepository transaccionRepository;


    public List<Transaccion> verTransacciones(){
        return transaccionRepository.findAll();
    }

    public Transaccion realizarTransaccion(TransaccionDTO transaccionDTO){

        Transaccion transaccion = new Transaccion();
        transaccion.setTipoCafeEnum(transaccionDTO.getTipoCafeEnum());
        transaccion.setIdComprador(transaccionDTO.getIdComprador());
        transaccion.setNombreComprador(transaccionDTO.getNombreComprador());
        transaccion.setIdVendendor(transaccionDTO.getIdVendendor());
        transaccion.setCantidadKg(transaccionDTO.getCantidadKg());
        transaccion.setValorKg(transaccionDTO.getValorKg());
        transaccion.setTotalFactura((transaccionDTO.getCantidadKg()*transaccionDTO.getValorKg()));
        transaccion.setValorPrestamo(transaccionDTO.getValorPrestamo());
        transaccion.setNumeroTulas(transaccionDTO.getNumeroTulas());
        transaccion.setFechaTransaccion(LocalDateTime.now());
        transaccionRepository.save(transaccion);
        return transaccion;
    }

}
