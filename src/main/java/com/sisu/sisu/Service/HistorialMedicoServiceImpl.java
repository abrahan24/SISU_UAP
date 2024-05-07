package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.HistorialMedicoDao;
import com.sisu.sisu.entitys.HistorialMedico;

@Service
public class HistorialMedicoServiceImpl implements HistorialMedicoService{

    @Autowired
    private HistorialMedicoDao historialMedicoDao;

    @Override
    public List<HistorialMedico> findAll() {
       return (List<HistorialMedico>) historialMedicoDao.findAll();
    }

    @Override
    public void save(HistorialMedico historialMedico) {
      historialMedicoDao.save(historialMedico);
    }

    @Override
    public HistorialMedico findOne(Integer id) {
        return historialMedicoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
      historialMedicoDao.deleteById(id);
    }
    
}
