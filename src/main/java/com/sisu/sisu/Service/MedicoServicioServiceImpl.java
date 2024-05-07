package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.MedicoServicioDao;
import com.sisu.sisu.entitys.MedicoServicio;

@Service
public class MedicoServicioServiceImpl implements MedicoServicioService {

    @Autowired
    private MedicoServicioDao medicoServicioDao;

    @Override
    public List<MedicoServicio> findAll() {
        return (List<MedicoServicio>) medicoServicioDao.findAll();
    }

    @Override
    public void save(MedicoServicio medicoServicio) {
        medicoServicioDao.save(medicoServicio);

    }

    @Override
    public MedicoServicio findOne(Integer id) {
        return medicoServicioDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        medicoServicioDao.deleteById(id);
    }
}
