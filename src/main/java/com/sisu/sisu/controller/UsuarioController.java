package com.sisu.sisu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sisu.sisu.Service.IPersonaService;
import com.sisu.sisu.Service.UsuarioService;
import com.sisu.sisu.entitys.Usuario;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private IPersonaService personaService;

    @GetMapping(value = "/formUs")
    public String vistaUs(Model model, @Validated Usuario usuarios) {

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());


        return "usuarios";
    }

    // -------------------------GUARDAR---------------------------------------

    @PostMapping(value = "/saveUs")
    public String saveUsiario(@Validated Usuario usuarios) {

        usuarios.setEstado_usuario("A");

        usuarioService.save(usuarios);

        return "redirect:/listaUs";

    }

    // -------------------------LISTAR---------------------------------------

    @GetMapping(value = "/listaUs")
    public String listaUs(Model model, @Validated Usuario usuarios) {

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        return "listas/listaUs";

    }
// 
    // -------------------------EDITAR---------------------------------------

    @GetMapping(value = "/editarUs/{idUsuario}")
    public String editarUs(Model model, @PathVariable("idUsuario") Integer idUsuario) {

        Usuario usuario = usuarioService.findOne(idUsuario);

        usuario.setEstado_usuario("A");

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        return "redirect:/listaUs";
    }

    // -------------------------ELIMINAR---------------------------------------

    @GetMapping(value = "/eliminarUs/{idUsuario}")
    public String deleteUs(@PathVariable("idUsuario") Integer idUsuario) {

        Usuario usuario = usuarioService.findOne(idUsuario);

        usuario.setEstado_usuario("X");

        usuarioService.save(usuario);

        return "redirect:/listaUs";

    }

}
