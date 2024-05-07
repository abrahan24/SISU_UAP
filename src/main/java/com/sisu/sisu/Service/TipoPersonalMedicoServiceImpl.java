package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.TipoPersonalMedicoDao;
import com.sisu.sisu.entitys.TipoPersonalMedico;

@Service
public class TipoPersonalMedicoServiceImpl implements TipoPersonalMedicoService{
    @Autowired
    private TipoPersonalMedicoDao tipoPersonalMedicoDao;

    @Override
    public List<TipoPersonalMedico> listarTodo() {
        return (List<TipoPersonalMedico>) tipoPersonalMedicoDao.findAll();
    }

    @Override
    public void registrar(TipoPersonalMedico tipoPersonalMedico) {
        tipoPersonalMedicoDao.save(tipoPersonalMedico);
    }

    @Override
    public TipoPersonalMedico buscarId(Integer id) {
        return tipoPersonalMedicoDao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(TipoPersonalMedico tipoPersonalMedico) {
        tipoPersonalMedico.setEstado("X");
        tipoPersonalMedicoDao.save(tipoPersonalMedico);
    }

    @Override
    public TipoPersonalMedico buscarPorNombre(String nombre) {
        return tipoPersonalMedicoDao.buscarPorNombre(nombre);
    }
}
