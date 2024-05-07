package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sisu.sisu.entitys.UsrRoles;
import com.sisu.sisu.entitys.Usuario;


@Service
public interface UsrRolesService {

	
	public List<UsrRoles> findAll(); // MOSTRAR TODOS LOS REGSITROS

	public void delete(Integer id); // ELIMINAR REGISTRO

	// public void save(Usuario usuario); // GUARDAR REGISTRO



	public UsrRoles findOne(Integer id);
	
	 void registrarUsrRoles(UsrRoles usrRoles);
	 public void save(UsrRoles usrRoles);
	 
	 List<UsrRoles>listRolesUsuario(Usuario usuario);
	 
	 UsrRoles findByIdUsrRol(int idUsrRol);


}
