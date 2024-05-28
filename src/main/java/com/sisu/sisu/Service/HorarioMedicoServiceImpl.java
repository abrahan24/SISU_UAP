package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.HorariosMedicoDao;
import com.sisu.sisu.entitys.HorarioMedico;


@Service
public class HorarioMedicoServiceImpl implements HorarioMedicoService{


    @Autowired
    private HorariosMedicoDao horariosMedicoDao;

    @Override
    public List<HorarioMedico> findAll() {
        return (List<HorarioMedico>) horariosMedicoDao.findAll();
    }

    @Override
    public void save(HorarioMedico horarioMedico) {
        horariosMedicoDao.save(horarioMedico);
    }

    @Override
    public HorarioMedico findOne(Integer id) {
        return horariosMedicoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        horariosMedicoDao.deleteById(id);
    }

    @Override
    public List<HorarioMedico> listaHorariosMedicos(int id_personal_medico) {
        return (List<HorarioMedico>) horariosMedicoDao.listaHorariosMedicos(id_personal_medico);
    }

   
    
}
