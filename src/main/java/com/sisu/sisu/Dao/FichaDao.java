package com.sisu.sisu.Dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sisu.sisu.entitys.Ficha;
import com.sisu.sisu.entitys.Persona;

public interface FichaDao extends CrudRepository<Ficha, Integer>{

    @Modifying
    @Query("UPDATE Ficha f SET f.estado = 'E' WHERE f.idFicha = ?1")
    void cambiarEstadoById(@Param("idFicha") Integer idFicha);

    @Query(value = "SELECT * FROM ficha WHERE ficha.id_asegurado = ?1 AND ficha.estado = 'A' AND DATE(fecha_registro_ficha) = DATE(?2)", nativeQuery = true)
    Ficha findFichaByAseguradoId(Integer aseguradoId, Date fecha);

    @Query(value = "SELECT * FROM ficha WHERE ficha.estado = 'A' AND DATE(fecha_registro_ficha) = DATE(?1)", nativeQuery = true)
    List<Ficha> listaFichasFechaActual(Date fecha);
}
