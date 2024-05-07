package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.Receta;

public interface RecetaService {
    public List<Receta> listarTodo();
    public void registrarReceta(Receta receta);
    public Receta buscarRecetaId(Integer id);
    public void eliminarReceta(Receta receta);
}
