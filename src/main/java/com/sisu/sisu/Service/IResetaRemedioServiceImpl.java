package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.IRecetaRemedioDao;
import com.sisu.sisu.entitys.RecetaRemedios;

@Service
public class IResetaRemedioServiceImpl implements ResetaRemedioService{

    @Autowired
    private IRecetaRemedioDao recetaRemedioDao;

    @Override
    public List<RecetaRemedios> listarTodo() {
        return (List<RecetaRemedios>) recetaRemedioDao.findAll();
    }

    @Override
    public void registrar(RecetaRemedios recetaRemedios) {
        recetaRemedioDao.save(recetaRemedios);
    }

    @Override
    public RecetaRemedios buscarId(Integer id) {
        return recetaRemedioDao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(RecetaRemedios recetaRemedios) {
        recetaRemedios.setEstado("X");
        recetaRemedioDao.save(recetaRemedios);
    }

}
