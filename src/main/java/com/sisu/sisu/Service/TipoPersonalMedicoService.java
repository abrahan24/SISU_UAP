package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.sisu.sisu.entitys.TipoPersonalMedico;

public interface TipoPersonalMedicoService {
    public List<TipoPersonalMedico> listarTodo();
    public void registrar(TipoPersonalMedico tipoPersonalMedico);
    public TipoPersonalMedico buscarId(Integer id);
    public void eliminar(TipoPersonalMedico tipoPersonalMedico);
    public TipoPersonalMedico buscarPorNombre(@Param("nombre") String nombre);
}
