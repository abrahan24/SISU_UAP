package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.HistoriaLinameDao;
import com.sisu.sisu.entitys.HistorialLiname;

@Service
public class HistoriaLinameServiceImpl implements HistoriaLinameService{


    @Autowired
    private HistoriaLinameDao historiaLinameDao;


    @Override
    public List<HistorialLiname> findAll() {
       
        return (List<HistorialLiname>) historiaLinameDao.findAll();
    }

    @Override
    public void save(HistorialLiname historiaLiname) {
        
        historiaLinameDao.save(historiaLiname);
    }

    @Override
    public HistorialLiname findOne(Integer id) {
         
        return historiaLinameDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
       
        historiaLinameDao.deleteById(id);
        
    }
    
}
