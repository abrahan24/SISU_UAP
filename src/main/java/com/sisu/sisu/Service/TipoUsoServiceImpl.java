package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.TipoUsoDao;
import com.sisu.sisu.entitys.TipoUso;

@Service
public class TipoUsoServiceImpl implements TipoUsoService{


    @Autowired
    private TipoUsoDao tipoUsoDao;


    @Override
    public List<TipoUso> findAll() {
      
        return (List<TipoUso>) tipoUsoDao.findAll();
    }

    @Override
    public void save(TipoUso tipoUso) {
       
        tipoUsoDao.save(tipoUso); 
    }

    @Override
    public TipoUso findOne(Integer id) {
        
        return tipoUsoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        
        tipoUsoDao.deleteById(id);
    }
    
}
