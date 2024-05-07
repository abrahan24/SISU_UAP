package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.TipoRegistroMedico;

public interface TipoRegistroMedicoService {
    public List<TipoRegistroMedico> listarTodo();
    public void registrar(TipoRegistroMedico tipoRegistroMedico);
    public TipoRegistroMedico buscarId(Integer id);
    public void eliminar(TipoRegistroMedico tipoRegistroMedico);
    public TipoRegistroMedico buscarPorNombre(String nombre);
}
