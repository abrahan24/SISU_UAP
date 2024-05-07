package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sisu.sisu.Dao.ServicioMedicoDao;
import com.sisu.sisu.entitys.ServicioMedico;

@Service
public class ServicioMedicoServiceImpl implements ServicioMedicoService {
    @Autowired

    private ServicioMedicoDao servicioMedicoDao;

    @Override
    public List<ServicioMedico> findAll() {
        return (List<ServicioMedico>) servicioMedicoDao.findAll();
    }

    @Override
    public void save(ServicioMedico serviciomedico) {
        servicioMedicoDao.save(serviciomedico);

    }

    @Override
    public ServicioMedico findOne(Integer id) {
        return servicioMedicoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        servicioMedicoDao.deleteById(id);
    }
}
