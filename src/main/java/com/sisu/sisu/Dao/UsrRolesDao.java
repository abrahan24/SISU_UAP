package com.sisu.sisu.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sisu.sisu.entitys.UsrRoles;
import com.sisu.sisu.entitys.Usuario;

public interface UsrRolesDao extends JpaRepository<UsrRoles, Integer> {
	
	@Query("SELECT u FROM Usuario u WHERE u.idUsuario = ?1")
    List<Usuario> buscarUsuarioPorId(Integer id);
	
	
	@Query ("select d from UsrRoles d where d.idUsuario =?1 and d.estado='A'")
    List<UsrRoles>listRolesUsuario(Usuario usuario);
	
	
	@Query("select d from UsrRoles d where d.idUsrRol =?1 and d.estado='A'")
	UsrRoles findByIdUsrRol(int idUsrRol);
	

}
