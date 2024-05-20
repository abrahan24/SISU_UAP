package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.HorarioServicioDao;
import com.sisu.sisu.entitys.HorarioServicio;

@Service
public class HorariosServicioServiceImpl implements HorarioServicioService{

    @Autowired
    private HorarioServicioDao horarioServicioDao;

    @Override
    public List<HorarioServicio> findAll() {
          return (List<HorarioServicio>) horarioServicioDao.findAll();
    }

    @Override
    public void save(HorarioServicio horarioServicio) {
        horarioServicioDao.save(horarioServicio);
    }

    @Override
    public HorarioServicio findOne(Integer id) {
        return horarioServicioDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        horarioServicioDao.deleteById(id);
    }

    @Override
    public List<HorarioServicio> listaHorariosServicios(int id_ficha) {
        return (List<HorarioServicio>) horarioServicioDao.listaHorariosServicios(id_ficha);
    }

}
