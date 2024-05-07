package com.sisu.sisu.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sisu.sisu.entitys.Menu;
import com.sisu.sisu.entitys.Roles;

public interface MenuDao extends JpaRepository<Menu, Integer> {

    List<Menu> findByIdRol(Roles idRol);
    
    
    
}