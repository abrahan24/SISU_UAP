package com.sisu.sisu.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sisu.sisu.entitys.HistorialSeguro;

public interface HistorialSeguroDao extends CrudRepository<HistorialSeguro, Integer>{

    @Query(value = "SELECT * FROM historial_seguro AS hs INNER JOIN asegurado AS a ON hs.id_asegurado=a.id_asegurado WHERE a.id_asegurado = ?1",nativeQuery = true)
    public HistorialSeguro getHistorial_por_id_seguro(Integer id_asegurado);
    
}
