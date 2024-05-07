package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.Institucion;

public interface InstitucionService {

    public List<Institucion> findAll(); //Muestra todos los registros

    public void save(Institucion institucion); //Guarda registro

    public Institucion findOne(Integer id); //Muestra un registro

    public void delete(Integer id); //Elimina registro
    
}
