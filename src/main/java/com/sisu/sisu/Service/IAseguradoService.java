package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.sisu.sisu.entitys.Asegurado;
import com.sisu.sisu.entitys.Persona;

/**
 * IAseguradoService
 */

@Service
public interface IAseguradoService {

    public List<Asegurado> findAll();

    public void save(Asegurado asegurado);

    public Asegurado findOne(Integer id);

    public void delete(Integer id);

    Asegurado obtenerIdAsegurado(@Param("id") Integer id);

    Asegurado findAseguradoByPersonaId(Integer personaId);

    Asegurado findAseguradoByIdPersona(Integer idAsegurado);
}