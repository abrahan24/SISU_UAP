package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.HistorialMedicoServicio;

public interface HistorialMedicoServiciosService {

    public List<HistorialMedicoServicio> findAll();

    public void save (HistorialMedicoServicio historiaLiname);

    public HistorialMedicoServicio findOne(Integer id);

    public void delete (Integer id);
    
}
