package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.LaboratorioDao;
import com.sisu.sisu.entitys.Laboratorio;
import com.sisu.sisu.entitys.Receta;


@Service
public class ILaboratorioServiceImlp implements LaboratorioService{

    @Autowired
    private LaboratorioDao laboratorioDao;

    @Override
    public List<Laboratorio> listarTodo() {
          return (List<Laboratorio>) laboratorioDao.findAll();
    }

    @Override
    public void registrarLaboratorio(Laboratorio laboratorio) {
        laboratorioDao.save(laboratorio);
    }

    @Override
    public Laboratorio buscarLaboratorioId(Integer id) {
        return laboratorioDao.findById(id).orElse(null);
    }

    @Override
    public void eliminarLaboratorio(Laboratorio laboratorio) {
        laboratorio.setEstado("X");
        laboratorioDao.save(laboratorio);
    }

  

}
