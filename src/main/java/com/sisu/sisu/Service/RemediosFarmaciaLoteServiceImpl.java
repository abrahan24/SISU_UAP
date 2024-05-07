package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.IRemediosFarmaciaLoteDao;
import com.sisu.sisu.entitys.RemediosFarmaciaLote;

@Service
public class RemediosFarmaciaLoteServiceImpl implements IRemediosFarmaciaLoteService {

    @Autowired
    private IRemediosFarmaciaLoteDao remediosFarmaciaLoteDao;
    
    @Override
    public List<RemediosFarmaciaLote> findAll() {
        return (List<RemediosFarmaciaLote>) remediosFarmaciaLoteDao.findAll();
    }

    @Override
    public void save(RemediosFarmaciaLote remediosFarmaciaLote) {
        remediosFarmaciaLoteDao.save(remediosFarmaciaLote);
    }

    @Override
    public RemediosFarmaciaLote findOne(Integer id) {
        return remediosFarmaciaLoteDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        remediosFarmaciaLoteDao.deleteById(id);
    }
    
}
