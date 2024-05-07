package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.HistorialReceta;

public interface HistorialRecetaService {

     public List<HistorialReceta> findAll();

    public void save (HistorialReceta historiaLiname);

    public HistorialReceta findOne(Integer id);

    public void delete (Integer id);
}
