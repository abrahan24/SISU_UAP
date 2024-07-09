package com.sisu.sisu.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sisu.sisu.entitys.RecetaRemedios;

public interface IRecetaRemedioDao extends CrudRepository<RecetaRemedios, Integer> {

           @Query(value = "SELECT * FROM receta_remedios rr\r\n" + //
                  "     where rr.id_receta  = ?1", nativeQuery = true)
    List<RecetaRemedios> listaRecetaRemediosPorIdReceta(int id_receta);
}
