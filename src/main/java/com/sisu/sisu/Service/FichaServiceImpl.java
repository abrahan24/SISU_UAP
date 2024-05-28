package com.sisu.sisu.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.FichaDao;
import com.sisu.sisu.entitys.Ficha;

@Service
public class FichaServiceImpl implements FichaService{

    @Autowired
    private FichaDao fichaDao;

    @Override
    public List<Ficha> findAll() {
       return (List<Ficha>) fichaDao.findAll();
    }

    @Override
    public void save(Ficha ficha) {
        fichaDao.save(ficha);
    }

    @Override
    public Ficha findOne(Integer id) {
        
       return fichaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        
        fichaDao.deleteById(id);
    }

    @Override
    public void cambiarEstadoById(Integer idFicha) {
        
        fichaDao.cambiarEstadoById(idFicha);
    }

    @Override
    public Ficha findFichaByAseguradoId(Integer aseguradoId,Date fecha) {
        // TODO Auto-generated method stub
        return fichaDao.findFichaByAseguradoId(aseguradoId, fecha);
    }

    @Override
    public List<Ficha> listaFichasFechaActual(Date fecha) {
        return (List<Ficha>) fichaDao.listaFichasFechaActual(fecha);
    }

    @Override
    public List<Ficha> listaFichasSinAsignar(Integer id_servicio_medico) {
        return (List<Ficha>) fichaDao.listaFichasSinAsignar(id_servicio_medico);
    }

    @Override
    public List<Ficha> listaFichasSeguimientoPersona(String ci) {
        return (List<Ficha>) fichaDao.listaFichasSeguimientoPersona(ci);
    }

    @Override
    public List<Ficha> listaFichasAsignadas(Integer id_personal_medico) {
        return (List<Ficha>) fichaDao.listaFichasAsignadas(id_personal_medico);
    }
}
