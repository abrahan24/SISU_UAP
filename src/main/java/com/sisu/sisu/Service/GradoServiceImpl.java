package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.IGradoDao;
import com.sisu.sisu.entitys.GradoAcademico;

@Service
public class GradoServiceImpl implements IGradoService {

	@Autowired
	private IGradoDao iGradoDao;;

	@Override
	public List<GradoAcademico> findAll() {

		return (List<GradoAcademico>) iGradoDao.findAll();
	}

	@Override
	public void save(GradoAcademico gradoAcademico) {

		iGradoDao.save(gradoAcademico);
	}

	@Override
	public GradoAcademico findOne(Integer id) {

		return iGradoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {

		iGradoDao.deleteById(id);
	}

}
