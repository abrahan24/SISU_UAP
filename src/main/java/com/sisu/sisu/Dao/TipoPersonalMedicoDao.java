package com.sisu.sisu.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sisu.sisu.entitys.TipoPersonalMedico;

public interface TipoPersonalMedicoDao extends CrudRepository<TipoPersonalMedico, Integer>{



    @Query(value = "select * from tipo_personal_medico tpm where tpm.tipo_personal = ?1", nativeQuery = true)
public TipoPersonalMedico buscarPorNombre(String nombre);
}
