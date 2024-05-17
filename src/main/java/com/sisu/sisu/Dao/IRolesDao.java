package com.sisu.sisu.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sisu.sisu.entitys.Roles;

public interface IRolesDao extends JpaRepository<Roles, Integer>{

    @Query(value = "SELECT id_rol, estado FROM ROLES WHERE UPPER(ROL) = UPPER(:rol) LIMIT 1", nativeQuery = true)
    Roles findByRol(@Param("rol") String rol);


    @Query(value = "SELECT ro FROM Roles ro WHERE ro.rol=?1 AND ro.descripcion=?2 AND ro.estado='A'")
	public Roles validarRoles(String rol,String descripcion);

   
}
