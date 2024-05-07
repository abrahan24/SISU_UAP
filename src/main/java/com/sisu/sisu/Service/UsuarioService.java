package com.sisu.sisu.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sisu.sisu.entitys.Usuario;

@Service
public interface UsuarioService {

    public List<Usuario> findAll(); // MOSTRAR TODOS LOS REGSITROS

    public void save(Usuario usuario); // GUARDAR REGISTRO

    public Usuario findOne(Integer id); // MOSTRAR UN REGSITRO

    public void delete(Integer id); // ELIMINAR REGISTRO

    Usuario buscarUsuarioPorId(Integer id);
    
    Usuario loguearse( String usuario, String clave);

}
