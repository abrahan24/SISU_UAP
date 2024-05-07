package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.TipoSeguro;

public interface TipoSeguroService {
    
    public List<TipoSeguro> findAll(); // MOSTRAR TODOS LOS REGSITROS

    public void save(TipoSeguro tipoSeguro); // GUARDAR REGISTRO

    public TipoSeguro findOne(Integer id); // MOSTRAR UN REGSITRO

    public void delete(Integer id); // ELIMINAR REGISTRO

}
