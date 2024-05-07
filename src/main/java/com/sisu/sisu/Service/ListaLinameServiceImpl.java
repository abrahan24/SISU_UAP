package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.ListaLinameDao;
import com.sisu.sisu.entitys.ListaLiname;

@Service
public class ListaLinameServiceImpl implements ListaLinameService{


    @Autowired
    private ListaLinameDao linameDao;

    @Override
    public List<ListaLiname> findAll() {
         
        return (List<ListaLiname>) linameDao.findAll();
    }

    @Override
    public void save(ListaLiname listaLiname) {
        
        linameDao.save(listaLiname);
    }

    @Override
    public ListaLiname findOne(Integer id) {
        
        return linameDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        
        linameDao.deleteById(id);
    }
    
}
