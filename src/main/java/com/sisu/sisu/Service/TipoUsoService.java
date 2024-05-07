package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.TipoUso;

public interface TipoUsoService {
    
    public List<TipoUso> findAll();

    public void save(TipoUso tipoUso);

    public TipoUso findOne(Integer id);

    public void delete(Integer id);
}
