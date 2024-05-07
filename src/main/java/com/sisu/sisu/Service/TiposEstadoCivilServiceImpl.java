package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.ITiposEstadoCivilDao;
import com.sisu.sisu.entitys.TiposEstadoCivil;

@Service
public class TiposEstadoCivilServiceImpl implements ITiposEstadoCivilService {

    @Autowired

    private ITiposEstadoCivilDao TiposEstadoCivilDao;

    @Override
    public List<TiposEstadoCivil> findAll() {
        return (List<TiposEstadoCivil>) TiposEstadoCivilDao.findAll();
    }

    @Override
    public void save(TiposEstadoCivil tipos_estado_civil) {
        TiposEstadoCivilDao.save(tipos_estado_civil);

    }

    @Override
    public TiposEstadoCivil findOne(Integer id) {
        return TiposEstadoCivilDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        TiposEstadoCivilDao.deleteById(id);
    }
}