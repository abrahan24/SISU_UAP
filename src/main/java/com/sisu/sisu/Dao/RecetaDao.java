package com.sisu.sisu.Dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sisu.sisu.entitys.PersonalMedico;
import com.sisu.sisu.entitys.Receta;
import com.sisu.sisu.entitys.RecetaRemedios;

public interface RecetaDao extends CrudRepository<Receta, Integer>{
    
    @Query(value = "select p.nombres, p.ap_paterno, p.ap_materno, p.ci, a.codigo_asegurado, r.fecha, r.estado, r.id_receta, tr.descripcion_receta from receta r \n" + //
                "left join tipo_receta tr on tr.id_t_receta = r.id_tipo_re \n" + //
                "left join historial_receta hr on hr.id_receta = r.id_receta \n" + //
                "left join historial_medico hm on hm.id_historial_medico = hr.id_historial_medico \n" + //
                "left join asegurado a on a.id_asegurado = hm.id_asegurado \n" + //
                "left join persona p on p.id_persona = a.id_persona \n" + //
                "where r.estado = 'S'", nativeQuery = true)
                List<Object[]>  listaRecetasPendientes();

                @Query(value = "select p.nombres, p.ap_paterno, p.ap_materno, p.ci, a.codigo_asegurado, r.fecha, r.id_receta, tr.descripcion_receta from receta r \n" + //
                "left join tipo_receta tr on tr.id_t_receta = r.id_tipo_re \n" + //
                "left join historial_receta hr on hr.id_receta = r.id_receta \n" + //
                "left join historial_medico hm on hm.id_historial_medico = hr.id_historial_medico \n" + //
                "left join asegurado a on a.id_asegurado = hm.id_asegurado \n" + //
                "left join persona p on p.id_persona = a.id_persona \n" + //
                "where r.estado = 'A'", nativeQuery = true)
                List<Object[]>  listaRecetasGeneral();


          
            
}
