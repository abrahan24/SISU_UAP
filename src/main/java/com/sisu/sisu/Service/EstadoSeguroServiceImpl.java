package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.EstadoSeguroDao;
import com.sisu.sisu.entitys.EstadoSeguro;

@Service
public class EstadoSeguroServiceImpl implements EstadoSeguroService{

    @Autowired
    private EstadoSeguroDao estadoSeguroDao;

    @Override
    public List<EstadoSeguro> findAll() {
        
        return (List<EstadoSeguro>) estadoSeguroDao.findAll();
    }

    @Override
    public void save(EstadoSeguro estadoSeguro) {

        estadoSeguroDao.save(estadoSeguro);
    }

    @Override
    public EstadoSeguro findOne(Integer id) {
       
        return estadoSeguroDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
       
        estadoSeguroDao.deleteById(id);
    }
    
}
