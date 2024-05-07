package com.sisu.sisu.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sisu.sisu.entitys.Persona;
import java.util.List;


public interface IPersonaDao extends CrudRepository<Persona, Integer> {

    @Query(value = "SELECT * FROM persona WHERE persona.ci = ?1 AND persona.estado IN ('X', 'RU', 'RA', 'RD')", nativeQuery = true)
    List<Persona> findByCii(String ci);

    @Query(value = "SELECT * FROM persona WHERE persona.ci = ?1 AND persona.estado IN ('X', 'RU', 'RA', 'RD')", nativeQuery = true)
    Persona findByCi(String ci);

    @Query(value = "SELECT * FROM persona WHERE persona.ci = ?1 AND persona.estado='RA'", nativeQuery = true)
    Persona findByCiA(String ci);

    // @Query(value = "SELECT * FROM persona WHERE persona.ci = ?1 AND persona.estado='RD'", nativeQuery = true)
    // Persona findByCiD(String ci);

    @Query("SELECT p FROM Persona p WHERE p.ci = :ci")
    Persona validarCI(@Param("ci") String ci);


}


