package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.TipoSeguroDao;
import com.sisu.sisu.entitys.TipoSeguro;

@Service
public class TipoSeguroServiceImpl implements TipoSeguroService{

    @Autowired
    private TipoSeguroDao tipoSeguroDao;

    @Override
    public List<TipoSeguro> findAll() {
        
        return (List<TipoSeguro>) tipoSeguroDao.findAll();
    }

    @Override
    public void save(TipoSeguro tipoSeguro) {
         
        tipoSeguroDao.save(tipoSeguro);
    }

    @Override
    public TipoSeguro findOne(Integer id) {
        
        return tipoSeguroDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        tipoSeguroDao.deleteById(id);
    }
    
}
