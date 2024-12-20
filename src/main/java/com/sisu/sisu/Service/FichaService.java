package com.sisu.sisu.Service;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.sisu.sisu.entitys.Ficha;

public interface FichaService {

    public List<Ficha> findAll(); //Muestra todos los registros

    public void save(Ficha ficha); //Guarda registro

    public Ficha findOne(Integer id); //Muestra un registro

    public void delete(Integer id); //Elimina registro

    void cambiarEstadoById(@Param("idFicha") Integer idFicha);  //Modificar Estado de registro

    Ficha findFichaByAseguradoId(Integer aseguradoId, Date fecha);

    List<Ficha> listaFichasFechaActual(Date fecha);
    List<Ficha> listaFichasSinAsignar(Integer id_servicio_medico, Date fecha);

    List<Ficha> listaFichasSeguimientoPersona(String ci);

    List<Ficha> listaFichasAsignadas(Integer id_personal_medico);
}
