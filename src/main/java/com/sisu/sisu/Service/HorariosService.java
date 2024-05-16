package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.Horarios;

public interface HorariosService {

    public List<Horarios> findAll();

    public void save(Horarios horarios);

    public Horarios findOne(Integer id);

    public void delete(Integer id);
}
