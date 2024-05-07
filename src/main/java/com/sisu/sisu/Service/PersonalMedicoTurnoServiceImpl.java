package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.PersonalMedicoTurnoDao;
import com.sisu.sisu.entitys.PersonalMedicoTurno;

@Service
public class PersonalMedicoTurnoServiceImpl implements PersonalMedicoTurnoService{
    @Autowired
    private PersonalMedicoTurnoDao personalMedicoTurnoDao;

    @Override
    public List<PersonalMedicoTurno> listarTodo() {
        return (List<PersonalMedicoTurno>) personalMedicoTurnoDao.findAll();
    }

    @Override
    public void registrar(PersonalMedicoTurno personalMedicoTurno) {
        personalMedicoTurnoDao.save(personalMedicoTurno);
    }

    @Override
    public PersonalMedicoTurno buscarId(Integer id) {
        return personalMedicoTurnoDao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(PersonalMedicoTurno personalMedicoTurno) {
        personalMedicoTurno.setEstado("X");
        personalMedicoTurnoDao.save(personalMedicoTurno);
    }
}
