package com.app.cafiagro.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransaccionRepository extends JpaRepository <Transaccion, Long> {

    @Query(value = "SELECT next_val FROM cafiagrodb.secuencia_transaccion", nativeQuery = true)
    public Long getNextValTransaccion();
}
