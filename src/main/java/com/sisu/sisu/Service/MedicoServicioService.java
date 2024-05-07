package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.MedicoServicio;

public interface MedicoServicioService {

    public List<MedicoServicio> findAll(); // Muestra todos los registros

    public void save(MedicoServicio medicoServicio); // Guarda registro

    public MedicoServicio findOne(Integer id); // Muestra un registro

    public void delete(Integer id); // Elimina registro

}
