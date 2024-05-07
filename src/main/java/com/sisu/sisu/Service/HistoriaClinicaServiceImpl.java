package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.HistoriaClinicaDao;
import com.sisu.sisu.entitys.HistoriaClinica;

@Service
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService{

    @Autowired
    private HistoriaClinicaDao historiaClinicaDao;

    @Override
    public List<HistoriaClinica> findAll() {
       return (List<HistoriaClinica>) historiaClinicaDao.findAll();
    }

    @Override
    public void save(HistoriaClinica dip) {
        historiaClinicaDao.save(dip);
    }

    @Override
    public HistoriaClinica findOne(Integer id) {
       return historiaClinicaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        historiaClinicaDao.deleteById(id);
    }
    
}
