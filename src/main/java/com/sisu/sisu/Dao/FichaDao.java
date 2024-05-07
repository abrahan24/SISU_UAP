package com.sisu.sisu.Dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sisu.sisu.entitys.Ficha;

public interface FichaDao extends CrudRepository<Ficha, Integer>{

    @Modifying
    @Query("UPDATE Ficha f SET f.estado = 'E' WHERE f.idFicha = ?1")
    void cambiarEstadoById(@Param("idFicha") Integer idFicha);

    @Query(value = "SELECT * FROM ficha WHERE ficha.id_asegurado =?1 AND  ficha.estado='A'", nativeQuery = true)
    Ficha findFichaByAseguradoId(Integer aseguradoId);
}
