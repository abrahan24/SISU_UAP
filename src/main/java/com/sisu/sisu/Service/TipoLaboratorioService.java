package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.TipoLaboratorio;

public interface TipoLaboratorioService {
    public List<TipoLaboratorio> listarTipoLaboratorios();
    public void save(TipoLaboratorio tipoLaboratorio);
    public TipoLaboratorio findOne(Integer id);
    public void delete(Integer id);
}
