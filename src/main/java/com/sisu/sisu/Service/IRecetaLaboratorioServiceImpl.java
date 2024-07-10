package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.IRecetaLaboratorioDao;
import com.sisu.sisu.entitys.RecetaLaboratorios;


@Service
public class IRecetaLaboratorioServiceImpl implements RecetaLaboratorioService{

    @Autowired
    private IRecetaLaboratorioDao recetaLaboratorioDao;

    @Override
    public List<RecetaLaboratorios> listarTodo() {
        return (List<RecetaLaboratorios>) recetaLaboratorioDao.findAll();
    }

    @Override
    public void registrar(RecetaLaboratorios recetaLaboratorios) {
        recetaLaboratorioDao.save(recetaLaboratorios);
    }

    @Override
    public RecetaLaboratorios buscarId(Integer id) {
        return recetaLaboratorioDao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(RecetaLaboratorios recetaLaboratorios) {
        recetaLaboratorios.setEstado("X");
        recetaLaboratorioDao.save(recetaLaboratorios);
    }

    

}
