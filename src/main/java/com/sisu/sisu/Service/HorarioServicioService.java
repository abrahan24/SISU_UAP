package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.HorarioServicio;

public interface HorarioServicioService {
    
     
    public List<HorarioServicio> findAll(); //Muestra todos los registros

    public void save(HorarioServicio horarioServicio); //Guarda registro

    public HorarioServicio findOne(Integer id); //Muestra un registro

    public void delete(Integer id); //Elimina registro
}
