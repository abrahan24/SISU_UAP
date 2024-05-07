package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.ITipoProveedorDao;
import com.sisu.sisu.entitys.TipoProveedor;

@Service
public class TipoProveedorServiceImpl implements ITipoProveedorService{

    @Autowired
    private ITipoProveedorDao tipoProveedorDao;
    
    @Override
    public List<TipoProveedor> findAll() {
        return (List<TipoProveedor>)tipoProveedorDao.findAll();
    }

    @Override
    public void save(TipoProveedor tipoProveedor) {
        tipoProveedorDao.save(tipoProveedor);
    }

    @Override
    public TipoProveedor findOne(Integer id) {
        return tipoProveedorDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        tipoProveedorDao.deleteById(id);
    }
    
}
