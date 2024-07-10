package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.RecetaLaboratorios;



public interface RecetaLaboratorioService {


    public List<RecetaLaboratorios> listarTodo();
    public void registrar(RecetaLaboratorios recetaLaboratorios);
    public RecetaLaboratorios buscarId(Integer id);
    public void eliminar(RecetaLaboratorios recetaLaboratorios);

}
