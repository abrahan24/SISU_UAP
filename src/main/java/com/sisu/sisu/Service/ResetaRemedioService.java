package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.RecetaRemedios;

public interface ResetaRemedioService {
    public List<RecetaRemedios> listarTodo();
    public void registrar(RecetaRemedios recetaRemedios);
    public RecetaRemedios buscarId(Integer id);
    public void eliminar(RecetaRemedios recetaRemedios);
}
