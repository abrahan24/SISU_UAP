package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.HistorialSeguro;

public interface HistorialSeguroService {
    
    public List<HistorialSeguro> findAll(); //Muestra todos los registros

    public void save(HistorialSeguro historialSeguro); //Guarda registro

    public HistorialSeguro findOne(Integer id); //Muestra un registro

    public void delete(Integer id); //Elimina registro

    public HistorialSeguro getHistorial_por_id_seguro(Integer id_asegurado);

}
