package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.HorariosDao;
import com.sisu.sisu.entitys.Horarios;

@Service
public class HorariosServiceImpl implements HorariosService{

     @Autowired
    private HorariosDao horariosDao;

    @Override
    public List<Horarios> findAll() {
       return (List<Horarios>) horariosDao.findAll();
    }

    @Override
    public void save(Horarios horarios) {
        horariosDao.save(horarios);
    }

    @Override
    public Horarios findOne(Integer id) {
        return horariosDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        horariosDao.deleteById(id);
    }

}
