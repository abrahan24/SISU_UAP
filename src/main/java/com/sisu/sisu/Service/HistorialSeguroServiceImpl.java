package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.HistorialSeguroDao;
import com.sisu.sisu.entitys.HistorialSeguro;

@Service
public class HistorialSeguroServiceImpl implements HistorialSeguroService{

    @Autowired
    private HistorialSeguroDao historialSeguroDao;

    @Override
    public List<HistorialSeguro> findAll() {
       return (List<HistorialSeguro>) historialSeguroDao.findAll();
    }

    @Override
    public void save(HistorialSeguro historialSeguro) {
        historialSeguroDao.save(historialSeguro);
    }

    @Override
    public HistorialSeguro findOne(Integer id) {
        return historialSeguroDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
       historialSeguroDao.deleteById(id);
    }

    @Override
    public HistorialSeguro getHistorial_por_id_seguro(Integer id_asegurado) {
        
        return historialSeguroDao.getHistorial_por_id_seguro(id_asegurado);
    }

    
}
