package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.IRemedioLoteDao;
import com.sisu.sisu.entitys.RemedioLote;

@Service
public class RemedioLoteServiceImpl implements IRemedioLoteService{

    @Autowired
    private IRemedioLoteDao remedioLoteDao;
    
    @Override
    public List<RemedioLote> findAll() {
        return (List<RemedioLote>) remedioLoteDao.findAll();
    }

    @Override
    public void save(RemedioLote remedioLote) {
        remedioLoteDao.save(remedioLote);
    }

    @Override
    public RemedioLote findOne(Integer id) {
        return remedioLoteDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        remedioLoteDao.deleteById(id);
    }
    
}
