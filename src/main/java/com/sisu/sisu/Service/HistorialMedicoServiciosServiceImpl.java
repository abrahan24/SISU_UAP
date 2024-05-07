package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.HistorialMedicoServicioDao;
import com.sisu.sisu.entitys.HistorialMedicoServicio;

@Service
public class HistorialMedicoServiciosServiceImpl implements HistorialMedicoServiciosService{

    @Autowired
    private HistorialMedicoServicioDao historialMedicoServicioDao;

    @Override
    public List<HistorialMedicoServicio> findAll() {
       return (List<HistorialMedicoServicio>) historialMedicoServicioDao.findAll();
    }

    @Override
    public void save(HistorialMedicoServicio historialMedicoServicio) {
      historialMedicoServicioDao.save(historialMedicoServicio);
    }

    @Override
    public HistorialMedicoServicio findOne(Integer id) {
        return historialMedicoServicioDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
      historialMedicoServicioDao.deleteById(id);
    }
    
}
