package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.TipoRegistroMedicoDao;
import com.sisu.sisu.entitys.TipoRegistroMedico;

@Service
public class TipoRegistroMedicoServiceImpl implements TipoRegistroMedicoService{
    @Autowired
    private TipoRegistroMedicoDao tipoRegistroMedicoDao;

    @Override
    public List<TipoRegistroMedico> listarTodo() {
        return (List<TipoRegistroMedico>) tipoRegistroMedicoDao.findAll();
    }

    @Override
    public void registrar(TipoRegistroMedico tipoRegistroMedico) {
        tipoRegistroMedicoDao.save(tipoRegistroMedico);
    }

    @Override
    public TipoRegistroMedico buscarId(Integer id) {
        return tipoRegistroMedicoDao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(TipoRegistroMedico tipoRegistroMedico) {
        tipoRegistroMedico.setEstado("X");
        tipoRegistroMedicoDao.save(tipoRegistroMedico);
    }

    @Override
    public TipoRegistroMedico buscarPorNombre(String nombre) {
        return tipoRegistroMedicoDao.buscarPorNombre(nombre);
    }
}
