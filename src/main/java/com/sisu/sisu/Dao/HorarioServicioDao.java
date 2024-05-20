package com.sisu.sisu.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sisu.sisu.entitys.HorarioServicio;
import com.sisu.sisu.entitys.PersonalMedico;

public interface HorarioServicioDao extends CrudRepository<HorarioServicio, Integer>{

      @Query(value = "SELECT * FROM horario_servicio hs\n" + //
                    "left join servicio_medico sm on sm.id_servicio_medico = hs.id_servicio_medico \n" + //
                    "left join ficha f on f.id_servicio_medico  = sm.id_servicio_medico \n" + //
                    "where f.id_ficha  = ?1", nativeQuery = true)
    List<HorarioServicio> listaHorariosServicios(int id_ficha);
}
