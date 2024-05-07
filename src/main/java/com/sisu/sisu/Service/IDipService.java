package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sisu.sisu.entitys.Dip;

@Service
public interface IDipService {

    public List<Dip> findAll(); //Muestra todos los registros
    public void save(Dip dip); //Guarda registro
    public Dip findOne(Integer id); //Muestra un registro
    public void delete(Integer id); //Elimina registro
    
}
