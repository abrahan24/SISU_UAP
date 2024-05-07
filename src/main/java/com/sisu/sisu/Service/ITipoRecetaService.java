package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sisu.sisu.entitys.TipoReceta;

@Service
public interface ITipoRecetaService {

    public List<TipoReceta> findAll(); // MOSTRAR TODOS LOS REGSITROS

    public void save(TipoReceta tipoReceta); // GUARDAR REGISTRO

    public TipoReceta findOne(Integer id); // MOSTRAR UN REGSITRO

    public void delete(Integer id); // ELIMINAR REGISTRO
}
