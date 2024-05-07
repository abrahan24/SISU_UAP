package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.HistorialMedico;

public interface HistorialMedicoService {

    public List<HistorialMedico> findAll();

    public void save (HistorialMedico historiaLiname);

    public HistorialMedico findOne(Integer id);

    public void delete (Integer id);
    
}
