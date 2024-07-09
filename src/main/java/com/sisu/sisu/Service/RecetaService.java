package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.Receta;
import com.sisu.sisu.entitys.RecetaRemedios;

public interface RecetaService {
    public List<Receta> listarTodo();
    public void registrarReceta(Receta receta);
    public Receta buscarRecetaId(Integer id);
    public void eliminarReceta(Receta receta);
    List<Object[]>  listaRecetasPendientes();
    List<Object[]>  listaRecetasGeneral();
    
}
