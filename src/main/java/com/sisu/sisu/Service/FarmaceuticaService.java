package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.FormaFarmaceutica;

public interface FarmaceuticaService {
    
    public List<FormaFarmaceutica> findAll();

    public void save (FormaFarmaceutica farmaceutica);

    public FormaFarmaceutica findOne(Integer id);

    public void delete(Integer id);
}
