package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.EstadoSeguro;

public interface EstadoSeguroService {

    public List<EstadoSeguro> findAll(); // MOSTRAR TODOS LOS REGSITROS

    public void save(EstadoSeguro estadoSeguro); // GUARDAR REGISTRO

    public EstadoSeguro findOne(Integer id); // MOSTRAR UN REGSITRO

    public void delete(Integer id); // ELIMINAR REGISTRO
    
}
