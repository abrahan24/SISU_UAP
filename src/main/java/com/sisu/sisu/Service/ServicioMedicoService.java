package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sisu.sisu.entitys.ServicioMedico;

@Service
public interface ServicioMedicoService {

    public List<ServicioMedico> findAll(); // Muestra todos los registros

    public void save(ServicioMedico servicioMedico); // Guarda registro

    public ServicioMedico findOne(Integer id); // Muestra un registro

    public void delete(Integer id); // Elimina registro
}
