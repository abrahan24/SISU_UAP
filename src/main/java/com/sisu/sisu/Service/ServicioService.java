package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sisu.sisu.entitys.Servicio;

@Service
public interface ServicioService {
    public List<Servicio> findAll(); // Muestra todos los registros

    public void save(Servicio servicio); // Guarda registro

    public Servicio findOne(Integer id); // Muestra un registro

    public void delete(Integer id); // Elimina registro
}