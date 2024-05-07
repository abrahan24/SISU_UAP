package com.sisu.sisu.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sisu.sisu.entitys.Asegurado;

public interface AseguradoDao extends CrudRepository<Asegurado, Integer>{
    
    @Query("SELECT a FROM Asegurado a WHERE a.id = ?1")
    Asegurado obtenerIdAsegurado(@Param("id") Integer id);
}
