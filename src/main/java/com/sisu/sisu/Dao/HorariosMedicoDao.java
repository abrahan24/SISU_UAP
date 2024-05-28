package com.sisu.sisu.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sisu.sisu.entitys.HorarioMedico;



public interface HorariosMedicoDao extends CrudRepository<HorarioMedico, Integer>{
    

        @Query(value = "SELECT * from horario_medico hm \n" + //
                        "left join personal_medico pm on pm.id_personal_medico  = hm.id_personal_medico\n" + //
                        "where pm.id_personal_medico = ?1", nativeQuery = true)
    List<HorarioMedico> listaHorariosMedicos(int id_personal_medico);
}
