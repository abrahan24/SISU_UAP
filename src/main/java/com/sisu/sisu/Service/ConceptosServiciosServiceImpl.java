package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.ConceptosServiciosDao;
import com.sisu.sisu.entitys.ConceptosServicios;

@Service
public class ConceptosServiciosServiceImpl implements ConceptosServiciosService{

    @Autowired
    private ConceptosServiciosDao conceptosServiciosDao;

    @Override
    public List<ConceptosServicios> findAll() {
       return (List<ConceptosServicios>) conceptosServiciosDao.findAll();
    }

    @Override
    public void save(ConceptosServicios historiaLiname) {
      conceptosServiciosDao.save(historiaLiname);
    }

    @Override
    public ConceptosServicios findOne(Integer id) {
        return conceptosServiciosDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
      conceptosServiciosDao.deleteById(id);
    }
    
}
