package com.sisu.sisu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sisu.sisu.Service.IEnlaceService;
import com.sisu.sisu.Service.IRolesService;
import com.sisu.sisu.Service.UsuarioService;
import com.sisu.sisu.entitys.Enlace;
import com.sisu.sisu.entitys.Roles;
import com.sisu.sisu.entitys.Usuario;

@Controller
public class EnlaceController {

    @Autowired
    private IEnlaceService enlaceService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private IRolesService rolesService;
    @RequestMapping(value = "formEnlace")
    public String registroEnlace(@Validated Enlace enlace, Model model) {

        model.addAttribute("enlace", new Enlace());
        model.addAttribute("enlaces", enlaceService.findAll());

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        System.out.print("ESTA SALIENDO DESDE ESTE CONTROLADOR");

        return "formularios/formEnlace";
    }

    /* GUARDAR */
    @PostMapping(value = "/guardarEnlace")
    public String RegistrarEnlace(@Validated Enlace enlace, RedirectAttributes flash, HttpServletRequest request, Model model) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(1);
        // Usuario usuario = usuarioService.buscarUsuarioPorId(1l);
        System.out.println("El nombre del enlace es: " + enlace.getNombre_enlace());
        if (enlace.getNombre_enlace() == "") {
            System.out.println("Está mandando un valor vacío");
            String mensaje = "No se puede registrar enlaces vacíos";
            flash.addFlashAttribute("mensaje", mensaje);
            return "redirect:formEnlace";
        } else {
            enlace.setId_usuario(usuario);
            System.out.println("++++++teste1++++++");
            enlace.setEstado("A");
            System.out.println(enlace.getNombre_enlace());
            enlace.setTabla(1);
            enlace.setObs("0");
            enlaceService.save(enlace);
            System.out.println("seGuardó1");
            return "redirect:formEnlace";
        }
    }
    @GetMapping(value = "formEnlaceHijo")
    public String registroEnlaceHijo(@Validated Enlace enlace, Model model) {

        model.addAttribute("enlace", new Enlace());
        model.addAttribute("enlaces", enlaceService.findAll());

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        model.addAttribute("listaEnlace", enlaceService.listaEnlacePadre());
        System.out.println(enlaceService.listaEnlacePadre().size());
        System.out.println("++++++++K+++++++++");

        return "formularios/formEnlaceHijo";
    }
    /* GUARDAR */

    @PostMapping(value = "/guardarEnlaceHijo2")
    public String registroEnlaceHijo(@Validated Enlace enlace, @RequestParam(name = "idEnlace2",required = false) Integer idEnlace, RedirectAttributes flash, HttpServletRequest request, Model model) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(1);
        System.out.println("El nombre del enlace es: " + enlace.getNombre_enlace());
        if (enlace.getNombre_enlace().isEmpty() || enlace.getRuta().isEmpty()) {
            System.out.println("Está mandando un valor vacío");
            String mensaje2 = "No se puede registrar enlaces vacíos";
            flash.addFlashAttribute("mensaje2", mensaje2);
            return "redirect:formEnlaceHijo";        
        
        }else{
            enlace.setId_usuario(usuario);
            System.out.println("+++++++teste2+++++++");
            enlace.setEstado("A");
            System.out.println(enlace.getNombre_enlace());
            // enlace.setRuta(null);
            if (idEnlace != null) {
                 enlace.setTabla(idEnlace);
            }
            // System.out.println(idEnlace);
            enlace.setObs("1");
            // System.out.println(enlace.getIdEnlace());
            // System.out.println("Guardado uwuuwuwuwuw" + idEnlace);
            enlaceService.save(enlace);
            System.out.println("+++++++++seGuardó2+++++++");
            return "redirect:formEnlaceHijo";
 }
 
    }

    /* LISTAR */
    @GetMapping(value = "/ListaEnlace")
    public String listarEnlace(Model model) {

        model.addAttribute("enlace", new Enlace());
        model.addAttribute("enlaces", enlaceService.findAll());

        System.out.println(enlaceService.findAll().size());
        model.addAttribute("listaEnlace", enlaceService.listaEnlacePadre());

        return "listas/listaEnlace";
    }

    @GetMapping(value = "/ListaEnlaceDisponibles")
    public String listarEnlaceDisponibles(Model model) {

        model.addAttribute("enlaces", rolesService.findAll());

        Roles roles = new Roles();

        return "listas/listaEnlaceDisponibles";
    }

}
