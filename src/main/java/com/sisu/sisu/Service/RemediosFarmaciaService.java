package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.IRemediosFarmaciaDao;
import com.sisu.sisu.entitys.RemediosFarmacia;

@Service
public class RemediosFarmaciaService implements IRemediosFarmaciaService {

    @Autowired
    private IRemediosFarmaciaDao remediosFarmaciaDao;

    @Override
    public List<RemediosFarmacia> findAll() {
        return (List<RemediosFarmacia>) remediosFarmaciaDao.findAll();
    }

    @Override
    public void save(RemediosFarmacia remediosFarmacia) {
        remediosFarmaciaDao.save(remediosFarmacia);
    }

    @Override
    public RemediosFarmacia findOne(Integer id) {
        return remediosFarmaciaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        remediosFarmaciaDao.deleteById(id);
    }
    
}
