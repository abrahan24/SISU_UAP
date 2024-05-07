package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.EstadoRecetaDao;
import com.sisu.sisu.entitys.EstadoReceta;

@Service
public class EstadoRecetaServiceImpl implements EstadoRecetaService {
    @Autowired

    private EstadoRecetaDao estadoRecetaDao;

    @Override
    public List<EstadoReceta> findAll() {
        return (List<EstadoReceta>) estadoRecetaDao.findAll();
    }

    @Override
    public void save(EstadoReceta estadoReceta) {
        estadoRecetaDao.save(estadoReceta);

    }

    @Override
    public EstadoReceta findOne(Integer id) {
        return estadoRecetaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        estadoRecetaDao.deleteById(id);
    }
}
