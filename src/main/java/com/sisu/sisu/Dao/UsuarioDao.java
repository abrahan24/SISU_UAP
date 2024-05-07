package com.sisu.sisu.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sisu.sisu.entitys.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Integer> {
	
    @Query("SELECT u FROM Usuario u WHERE u.idUsuario = ?1")
    Usuario buscarUsuarioPorId(Integer id);

    @Query("select d from Usuario d where d.apodo=?1 and d.clave=?2 and d.estado_usuario='A'")
	Usuario loguearse( String usuario,String clave);

}
