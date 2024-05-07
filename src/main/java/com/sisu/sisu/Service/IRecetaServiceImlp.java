package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.RecetaDao;
import com.sisu.sisu.entitys.Receta;

@Service
public class IRecetaServiceImlp implements RecetaService{

    @Autowired
    private RecetaDao recetaDao;

    @Override
    public List<Receta> listarTodo() {
        return (List<Receta>) recetaDao.findAll();
    }

    @Override
    public void registrarReceta(Receta receta) {
        recetaDao.save(receta);
    }

    @Override
    public Receta buscarRecetaId(Integer id) {
        return recetaDao.findById(id).orElse(null);
    }

    @Override
    public void eliminarReceta(Receta receta) {
        receta.setEstado("X");
        recetaDao.save(receta);
    }

}
