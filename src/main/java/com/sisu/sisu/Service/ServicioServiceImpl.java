package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.ServicioDao;
import com.sisu.sisu.entitys.Servicio;

@Service
public class ServicioServiceImpl implements ServicioService {
    @Autowired

    private ServicioDao servicioDao;

    @Override
    public List<Servicio> findAll() {
        return (List<Servicio>) servicioDao.findAll();
    }

    @Override
    public void save(Servicio servicio) {
        servicioDao.save(servicio);

    }

    @Override
    public Servicio findOne(Integer id) {
        return servicioDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        servicioDao.deleteById(id);
    }
}
