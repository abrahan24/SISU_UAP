package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.FarmaceuticaDao;
import com.sisu.sisu.entitys.FormaFarmaceutica;

@Service
public class FarmaceuticaServiceImpl implements FarmaceuticaService{

    @Autowired
    private FarmaceuticaDao farmaceuticaDao;

    @Override
    public List<FormaFarmaceutica> findAll() {
       
        return (List<FormaFarmaceutica>) farmaceuticaDao.findAll();
    }

    @Override
    public void save(FormaFarmaceutica farmaceutica) {
       
        farmaceuticaDao.save(farmaceutica);
    }

    @Override
    public FormaFarmaceutica findOne(Integer id) {
       
        return farmaceuticaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
       
        farmaceuticaDao.deleteById(id);
    }



   
    
}
