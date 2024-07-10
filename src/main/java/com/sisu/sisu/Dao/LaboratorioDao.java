package com.sisu.sisu.Dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sisu.sisu.entitys.Laboratorio;
import com.sisu.sisu.entitys.PersonalMedico;
import com.sisu.sisu.entitys.Receta;
import com.sisu.sisu.entitys.RecetaRemedios;

public interface LaboratorioDao extends CrudRepository<Laboratorio, Integer>{

        
            
}
