package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.MenuDao;
import com.sisu.sisu.entitys.Menu;
import com.sisu.sisu.entitys.Roles;

@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> findAll() {
        return (List<Menu>) menuDao.findAll();
    }

    @Override
    public void save(Menu menu) {
        menuDao.save(menu);
    }

    @Override
    public Menu findOne(Integer id) {
        return menuDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        menuDao.deleteById(id);
    }

	@Override
	public List<Menu> findByIdRol(Roles idRol) {
		// TODO Auto-generated method stub
		return menuDao.findByIdRol(idRol);
	}

   

}
