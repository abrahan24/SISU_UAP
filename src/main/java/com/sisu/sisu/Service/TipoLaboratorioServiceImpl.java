package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.TipoLaboratorioDao;
import com.sisu.sisu.entitys.TipoLaboratorio;

@Service
public class TipoLaboratorioServiceImpl implements TipoLaboratorioService{

    @Autowired
    private TipoLaboratorioDao tipoLaboratorioDao;

    @Override
    public List<TipoLaboratorio> listarTipoLaboratorios() {
        return (List<TipoLaboratorio>)tipoLaboratorioDao.findAll();
    }

    @Override
    public void save(TipoLaboratorio tipoLaboratorio) {
        tipoLaboratorioDao.save(tipoLaboratorio);
    }

    @Override
    public TipoLaboratorio findOne(Integer id) {
        return tipoLaboratorioDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        tipoLaboratorioDao.deleteById(id);
    }
    
}
