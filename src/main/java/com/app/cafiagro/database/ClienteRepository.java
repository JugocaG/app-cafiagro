package com.app.cafiagro.database;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {

    Optional<Cliente> findByCedula(String cedula);

    @Query(value = "SELECT next_val FROM cafiagrodb.secuencia_cliente", nativeQuery = true)
    public Long getNextValCliente();

    @Query(value = "SELECT id FROM cafiagrodb.cliente WHERE cedula = :cedula", nativeQuery = true)
    public Long findIdByCedula(@Param("cedula") String cedula);


}

