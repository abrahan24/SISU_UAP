package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.InstitucionDao;
import com.sisu.sisu.entitys.Institucion;

@Service
public class InstitucionServiceImpl implements InstitucionService{

    @Autowired
    private InstitucionDao institucionDao;

    @Override
    public List<Institucion> findAll() {
        
        return (List<Institucion>) institucionDao.findAll();
    }

    @Override
    public void save(Institucion institucion) {
       
        institucionDao.save(institucion);
    }

    @Override
    public Institucion findOne(Integer id) {
        
        return institucionDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        
        institucionDao.deleteById(id);
    }
    
}
