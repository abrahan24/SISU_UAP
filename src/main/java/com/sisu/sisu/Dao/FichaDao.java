package com.sisu.sisu.Dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sisu.sisu.entitys.Ficha;
import com.sisu.sisu.entitys.Persona;

public interface FichaDao extends CrudRepository<Ficha, Integer>{

    @Modifying
    @Query("UPDATE Ficha f SET f.estado = 'E' WHERE f.idFicha = ?1")
    void cambiarEstadoById(@Param("idFicha") Integer idFicha);

    @Query(value = "SELECT * FROM ficha WHERE ficha.id_asegurado = ?1 AND ficha.estado = 'A' AND DATE(fecha_registro_ficha) = DATE(?2)", nativeQuery = true)
    Ficha findFichaByAseguradoId(Integer aseguradoId, Date fecha);

    @Query(value = "SELECT * FROM ficha WHERE ficha.estado = 'A' AND DATE(fecha_registro_ficha) = DATE(?1)", nativeQuery = true)
    List<Ficha> listaFichasFechaActual(Date fecha);

    @Query(value = "select * from ficha f \n" + //
                "left join servicio_medico sm on sm.id_servicio_medico = f.id_servicio_medico\n" + //
                "where f.estado = 'A' and sm.id_servicio_medico = ?1 AND DATE(fecha_registro_ficha) = DATE(?2)", nativeQuery = true)
    List<Ficha> listaFichasSinAsignar(Integer id_servicio_medico, Date fecha);

    @Query(value = "select * from ficha f \n" + //
                "left join personal_medico_ficha pmf on pmf.id_ficha = f.id_ficha \n" + //
                "where f.estado = 'AA' and pmf.id_personal_medico = ?1", nativeQuery = true)
List<Ficha> listaFichasAsignadas(Integer id_personal_medico);

    @Query(value = "select * from ficha f \n" + //
                "left join asegurado a on a.id_asegurado = f.id_asegurado \n" + //
                "left join persona p on p.id_persona = a.id_persona \n" + //
                "where p.ci = ?1", nativeQuery = true)
    List<Ficha> listaFichasSeguimientoPersona(String ci);
}
