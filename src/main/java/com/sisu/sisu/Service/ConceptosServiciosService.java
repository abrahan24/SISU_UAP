package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.ConceptosServicios;

public interface ConceptosServiciosService {

    public List<ConceptosServicios> findAll();

    public void save (ConceptosServicios historiaLiname);

    public ConceptosServicios findOne(Integer id);

    public void delete (Integer id);
    
}
