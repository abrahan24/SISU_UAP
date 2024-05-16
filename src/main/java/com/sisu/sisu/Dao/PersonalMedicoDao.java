package com.sisu.sisu.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sisu.sisu.entitys.PersonalMedico;
import com.sisu.sisu.entitys.PersonalMedicoFicha;

public interface PersonalMedicoDao extends CrudRepository<PersonalMedico, Integer>{
    
     @Query(value = "SELECT * FROM personal_medico pm\r\n" + //
                  "     left join medico_servicio ms on ms.id_personal_medico  = pm.id_personal_medico \r\n" + //
                  "     left join servicio_medico sm on sm.id_servicio_medico = ms.id_servicio_medico \r\n" + //
                  "     left join ficha f on f.id_servicio_medico  = sm.id_servicio_medico \r\n" + //
                  "     where f.id_ficha  = ?1", nativeQuery = true)
    List<PersonalMedico> listaPersonalMedicoPorServicioFicha(int id_ficha);
}
