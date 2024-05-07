package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.PersonalMedicoTurno;

public interface PersonalMedicoTurnoService {
    public List<PersonalMedicoTurno> listarTodo();
    public void registrar(PersonalMedicoTurno personalMedicoTurno);
    public PersonalMedicoTurno buscarId(Integer id);
    public void eliminar(PersonalMedicoTurno personalMedicoTurno);
}
