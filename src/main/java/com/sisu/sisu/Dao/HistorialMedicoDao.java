package com.sisu.sisu.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sisu.sisu.entitys.HistorialMedico;
import com.sisu.sisu.entitys.HistorialSeguro;

public interface HistorialMedicoDao extends CrudRepository<HistorialMedico, Integer>{
    


    @Query(value = "SELECT * FROM historial_medico AS hm INNER JOIN asegurado AS a ON hm.id_asegurado=a.id_asegurado WHERE a.id_asegurado = ?1",nativeQuery = true)
    public HistorialMedico getHistorialMedico_por_id_seguro(Integer id_asegurado);
}
