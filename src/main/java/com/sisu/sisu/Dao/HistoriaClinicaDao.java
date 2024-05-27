package com.sisu.sisu.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.sisu.sisu.entitys.HistoriaClinica;

public interface HistoriaClinicaDao extends CrudRepository<HistoriaClinica, Integer>{
    

       @Query(value = "select * from historia_clinica hc \n" + //
                      "left join historial_seguro hs on hs.id_historial_seguro = hc.id_historia_seguro \n" + //
                      "where id_historia_seguro = ?1", nativeQuery = true)
    List<HistoriaClinica> listaHistoriaClinicasValidacion(Integer id_historial_seguro);
}
