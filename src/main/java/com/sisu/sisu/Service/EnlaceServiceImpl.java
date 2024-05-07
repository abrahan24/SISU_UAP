package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.EnlaceDao;
import com.sisu.sisu.entitys.Enlace;

@Service
public class EnlaceServiceImpl implements IEnlaceService {
    @Autowired
    private EnlaceDao enlaceDao;

    @Override
    public List<Enlace> findAll() {
        return (List<Enlace>) enlaceDao.findAll();
    }

    @Override
    public void save(Enlace enlace) {
    enlaceDao.save(enlace);
    }

    @Override
    public Enlace findOne( Integer id) {
    return enlaceDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
    enlaceDao.deleteById(id);

    }

    @Override
    public List<Enlace> listaEnlacePadre( ) {
       return enlaceDao.listaEnlacePadre();
    }

    @Override
    public List<Enlace> listaEnlaceHijo(int idEnlacePadre) {
        return enlaceDao.listaEnlaceHijo(idEnlacePadre);
    }
}
