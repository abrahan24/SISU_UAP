package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.IAseguradoDao;
import com.sisu.sisu.entitys.Asegurado;
import com.sisu.sisu.entitys.Persona;

@Service
public class AseguradoServiceImpl implements IAseguradoService {

    @Autowired
    private IAseguradoDao aseguradoDao;

    @Override
    public List<Asegurado> findAll() {
        return (List<Asegurado>) aseguradoDao.findAll();
    }

    @Override
    public void save(Asegurado asegurado) {
        aseguradoDao.save(asegurado);
    }

    @Override
    public Asegurado findOne(Integer id) {
        return aseguradoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        aseguradoDao.deleteById(id);
    }

    @Override
    public Asegurado findAseguradoByPersonaId(Integer personaId) {
        // TODO Auto-generated method stub
        return aseguradoDao.findAseguradoByPersonaId(personaId);
    }

    @Override
    public Asegurado obtenerIdAsegurado(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerIdAsegurado'");
    }

    @Override
    public Asegurado findAseguradoByIdPersona(Integer idAsegurado) {
        // TODO Auto-generated method stub
        return aseguradoDao.findAseguradoByIdPersona(idAsegurado);
    }
 
}
