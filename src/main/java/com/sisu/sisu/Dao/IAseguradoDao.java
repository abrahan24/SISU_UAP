package com.sisu.sisu.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sisu.sisu.entitys.Asegurado;

public interface IAseguradoDao extends CrudRepository<Asegurado, Integer> {
    @Query(value = "SELECT * FROM asegurado WHERE asegurado.id_persona = ?1 AND asegurado.estado = 'A'", nativeQuery = true)
    Asegurado findAseguradoByPersonaId(Integer personaId);

    @Query(value = "SELECT id_asegurado FROM asegurado WHERE asegurado.id_persona = ?1", nativeQuery = true)
    Asegurado findAseguradoByIdPersona(Integer idAsegurado);
}
