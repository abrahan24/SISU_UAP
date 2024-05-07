package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.PersonalMedico;

public interface PersonalMedicoService {
    public List<PersonalMedico> listarTodo();
    public void registrar(PersonalMedico personalMedico);
    public PersonalMedico buscarId(Integer id);
    public void eliminar(PersonalMedico personalMedico);
}
