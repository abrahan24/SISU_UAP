package com.sisu.sisu.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sisu.sisu.entitys.TipoRegistroMedico;

public interface TipoRegistroMedicoDao extends CrudRepository<TipoRegistroMedico, Integer> {
    @Query(value = "SELECT * FROM tipo_registro_medico trm WHERE trm.tipo_registro_medico = :nombre", nativeQuery = true)
public TipoRegistroMedico buscarPorNombre(@Param("nombre") String nombre);

}
