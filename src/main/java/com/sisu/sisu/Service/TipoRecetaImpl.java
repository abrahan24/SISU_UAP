package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.TipoRecetaDao;
import com.sisu.sisu.entitys.TipoReceta;

@Service
public class TipoRecetaImpl implements ITipoRecetaService {

    @Autowired
    private TipoRecetaDao tipoRecetaDao;

    @Override
    public List<TipoReceta> findAll() {

        return (List<TipoReceta>) tipoRecetaDao.findAll();
    }

    @Override
    public void save(TipoReceta tipo_receta) {

        tipoRecetaDao.save(tipo_receta);
    }

    @Override
    public TipoReceta findOne(Integer id) {

        return tipoRecetaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {

        tipoRecetaDao.deleteById(id);
    }
}
