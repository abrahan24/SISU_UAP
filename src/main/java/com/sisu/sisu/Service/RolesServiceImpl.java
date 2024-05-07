package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.IRolesDao;
import com.sisu.sisu.entitys.Roles;

@Service
public class RolesServiceImpl implements IRolesService {

    @Autowired
    private IRolesDao rolesDao;

    @Override
    public List<Roles> findAll() {
        return (List<Roles>) rolesDao.findAll();
    }

    @Override
    public void save(Roles roles) {
        rolesDao.save(roles);
    }

    @Override
    public Roles findOne(Integer id) {
        return rolesDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        rolesDao.deleteById(id);
    }

    @Override
    public Roles validarRoles(String rol) {
        return rolesDao.validarRoles(rol);
    }


}

   

    

