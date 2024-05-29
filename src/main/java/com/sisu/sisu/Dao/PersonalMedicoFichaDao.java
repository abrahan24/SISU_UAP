package com.sisu.sisu.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sisu.sisu.entitys.Persona;
import com.sisu.sisu.entitys.PersonalMedicoFicha;

public interface PersonalMedicoFichaDao extends CrudRepository<PersonalMedicoFicha,Integer>{
    
     @Query(value = "SELECT * FROM personal_medico_ficha pmf \r\n" + //
                  "LEFT JOIN personal_medico pm ON pmf.id_personal_medico = pm.id_personal_medico \r\n" + //
                  "LEFT JOIN persona p ON pm.id_persona = p.id_persona \r\n" + //
                  "LEFT JOIN  usuarios u  ON u.id_persona = p.id_persona \r\n" + //
                  "WHERE u.id_usuario = ?1", nativeQuery = true)
    List<PersonalMedicoFicha> listaFichasAsignadasPersonalMedico(int id_usuario);

    @Query(value = "SELECT * FROM personal_medico_ficha pmf \r\n" + //
    "LEFT JOIN personal_medico pm ON pmf.id_personal_medico = pm.id_personal_medico \r\n" + //
    "LEFT JOIN persona p ON pm.id_persona = p.id_persona \r\n" + //
    "LEFT JOIN  usuarios u  ON u.id_persona = p.id_persona \r\n" + //
    "WHERE u.id_usuario = ?1", nativeQuery = true)
    List<PersonalMedicoFicha> personalMedicoFichssa(int id_usuario);

    @Query(value = " SELECT DISTINCT ON (a.id_asegurado) *\n" + //
              "FROM personal_medico_ficha pmf \n" + //
              "LEFT JOIN personal_medico pm ON pmf.id_personal_medico = pm.id_personal_medico \n" + //
              "LEFT JOIN ficha f ON f.id_ficha = pmf.id_ficha\n" + //
              "LEFT JOIN asegurado a ON a.id_asegurado = f.id_asegurado\n" + //
              "LEFT JOIN persona p ON p.id_persona = a.id_persona\n" + //
              "WHERE pm.id_personal_medico = ?1 and f.estado = 'AAA'", nativeQuery = true)
    List<PersonalMedicoFicha> personalMedicoFichasCompletadas(int id_personal_medico);

    @Query(value = "SELECT * FROM personal_medico_ficha WHERE id_ficha = ?1 ", nativeQuery = true)
   public PersonalMedicoFicha personalMedicoFicha(int id_ficha);
}
