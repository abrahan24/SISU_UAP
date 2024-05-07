package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sisu.sisu.entitys.Menu;
import com.sisu.sisu.entitys.Roles;

@Service
public interface IMenuService {
    public List<Menu> findAll(); // Muestra todos los registros

    public void save(Menu menu); // Guarda registro

    public Menu findOne(Integer id); // Muestra un registro

    public void delete(Integer id); // Elimina registro


    List<Menu> findByIdRol(Roles idRol);

}