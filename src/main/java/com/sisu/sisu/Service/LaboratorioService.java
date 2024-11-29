package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.Laboratorio;


public interface LaboratorioService {


    public List<Laboratorio> listarTodo();
    public void save(Laboratorio laboratorio);
    public Laboratorio findOne(Integer id);
    public void registrarLaboratorio(Laboratorio laboratorio);
    public Laboratorio buscarLaboratorioId(Integer id);
    public void eliminarLaboratorio(Laboratorio laboratorio);

    
}
