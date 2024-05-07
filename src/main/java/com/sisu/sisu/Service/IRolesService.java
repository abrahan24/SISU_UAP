package com.sisu.sisu.Service;

import java.util.List;

import com.sisu.sisu.entitys.Roles;

public interface IRolesService {
    public List<Roles> findAll();
    public void save(Roles roles);
    public Roles findOne(Integer id); 
    public void delete(Integer id);
	Roles validarRoles(String rol);
    
}
