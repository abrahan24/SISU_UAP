package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.DipDao;
import com.sisu.sisu.entitys.Dip;

@Service
public class IDipServiceImpl implements IDipService{

    @Autowired
    private DipDao dipDao;

    @Override
    public List<Dip> findAll() {
       return (List<Dip>) dipDao.findAll();
    }

    @Override
    public void save(Dip dip) {
        dipDao.save(dip);
    }

    @Override
    public Dip findOne(Integer id) {
       return dipDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        dipDao.deleteById(id);
    }
    
}
