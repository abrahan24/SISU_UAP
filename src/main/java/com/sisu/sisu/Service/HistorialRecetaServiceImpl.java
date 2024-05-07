package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.HistorialRecetaDao;
import com.sisu.sisu.entitys.HistorialReceta;

@Service
public class HistorialRecetaServiceImpl implements HistorialRecetaService{
  
    @Autowired
    private HistorialRecetaDao historialRecetaDao;

    @Override
    public List<HistorialReceta> findAll() {
        return (List<HistorialReceta>) historialRecetaDao.findAll();
    }

    @Override
    public void save(HistorialReceta historialReceta) {
        historialRecetaDao.save(historialReceta);
    }

    @Override
    public HistorialReceta findOne(Integer id) {
        return historialRecetaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
       historialRecetaDao.deleteById(id);
    }

}
