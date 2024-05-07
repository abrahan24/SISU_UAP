package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sisu.sisu.Dao.UsuarioDao;
import com.sisu.sisu.entitys.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> findAll() {

        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    public void save(Usuario usuario) {

        usuarioDao.save(usuario);
    }

    @Override
    public Usuario findOne(Integer id) {

        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {

        usuarioDao.deleteById(id);
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer id) {
        return usuarioDao.buscarUsuarioPorId(id);
    }

    @Override
    public Usuario loguearse(String usuario, String clave) {
        // TODO Auto-generated method stub
        return usuarioDao.loguearse(usuario, clave);
    }

    
    
}
