package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.UsrRolesDao;
import com.sisu.sisu.entitys.UsrRoles;
import com.sisu.sisu.entitys.Usuario;

@Service
public class UsrRolesServiceImpl implements UsrRolesService {
	
	@Autowired
	UsrRolesDao usrRolesDao;

	 @Override
    public UsrRoles findOne(Integer id) {

        return usrRolesDao.findById(id).orElse(null);
    }

	@Override
	public void registrarUsrRoles(UsrRoles usrRoles) {
		throw new UnsupportedOperationException("Unimplemented method 'registrarUsrRoles'");
	}

	@Override
	public void save(UsrRoles usrRoles) {

		usrRolesDao.save(usrRoles);
	}

	@Override
	public List<UsrRoles> findAll() {

		return (List<UsrRoles>) usrRolesDao.findAll();
	}

	@Override
	public List<UsrRoles> listRolesUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usrRolesDao.listRolesUsuario(usuario);
	}

	@Override
	public UsrRoles findByIdUsrRol(int idUsrRol) {
		// TODO Auto-generated method stub
		return usrRolesDao.findByIdUsrRol(idUsrRol);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}
	

	
	// @Override
	// public List<UsrRoles> listarRoles() {
	// 	// TODO Auto-generated method stub
	// 	return usrRolesDao.listarRoles() ;
	// }

	// @Override
	// public void registrarUsrRoles(UsrRoles usrRoles) {
	// 	usrRolesDao.save(usrRoles);		
	// }
	
}
