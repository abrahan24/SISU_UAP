package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.PersonalMedicoDao;
import com.sisu.sisu.entitys.PersonalMedico;

@Service
public class PersonalMedicoServiceImpl implements PersonalMedicoService{
    @Autowired
    private PersonalMedicoDao personalMedicoDao;

    @Override
    public List<PersonalMedico> listarTodo() {
        return (List<PersonalMedico>) personalMedicoDao.findAll();
    }

    @Override
    public void registrar(PersonalMedico personalMedico) {
        personalMedicoDao.save(personalMedico);
    }

    @Override
    public PersonalMedico buscarId(Integer id) {
        return personalMedicoDao.findById(id).orElse(null);
    }

    @Override
    public void eliminar(PersonalMedico personalMedico) {
        personalMedico.setEstado("X");
        personalMedicoDao.save(personalMedico);
    }
}
