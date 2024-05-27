package com.sisu.sisu.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sisu.sisu.entitys.ListaLiname;

public interface ListaLinameDao extends CrudRepository<ListaLiname, Integer> {
    
    @Query(value = "SELECT li FROM ListaLiname li WHERE li.codigoLiname =?1")
    public ListaLiname getLiname_codigo(String codigoLiname);
}
