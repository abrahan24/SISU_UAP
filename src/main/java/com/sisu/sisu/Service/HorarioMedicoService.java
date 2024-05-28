package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.HorarioMedico;
import com.sisu.sisu.entitys.HorarioServicio;

public interface HorarioMedicoService {
    
    public List<HorarioMedico> findAll(); //Muestra todos los registros

    public void save(HorarioMedico horarioMedico); //Guarda registro

    public HorarioMedico findOne(Integer id); //Muestra un registro

    public void delete(Integer id); //Elimina registro

    List<HorarioMedico> listaHorariosMedicos(int id_personal_medico);
}
