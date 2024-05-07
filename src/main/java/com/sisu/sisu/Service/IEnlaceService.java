package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sisu.sisu.entitys.Enlace;

@Service
public interface IEnlaceService {
    public List<Enlace> findAll(); // Muestra todos los registros

    public void save(Enlace enlace); // Guarda registro

    public Enlace findOne(Integer id); // Muestra un registro

    public void delete(Integer id); // Elimina registros
    
    List<Enlace>listaEnlacePadre();

    List<Enlace>listaEnlaceHijo(int idEnlacePadre);

    
}
