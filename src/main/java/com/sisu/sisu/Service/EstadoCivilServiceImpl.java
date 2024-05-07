package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.EstadoCivilDao;
import com.sisu.sisu.entitys.TiposEstadoCivil;

@Service
public class EstadoCivilServiceImpl implements EstadoCivilService {

    @Autowired
    private EstadoCivilDao estadoCivilDao;

    @Override
    public List<TiposEstadoCivil> findAll() {

        return (List<TiposEstadoCivil>) estadoCivilDao.findAll();
    }

    @Override
    public void save(TiposEstadoCivil estadoCivil) {

        estadoCivilDao.save(estadoCivil);
    }

    @Override
    public TiposEstadoCivil findOne(Integer id) {

        return estadoCivilDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {

        estadoCivilDao.deleteById(id);
    }

}
