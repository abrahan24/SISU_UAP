package com.sisu.sisu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sisu.sisu.Service.IRolesService;
import com.sisu.sisu.entitys.Roles;

@Controller
public class RolesController {
    
    @Autowired
    private IRolesService rolesService;

    @GetMapping(value = "/formRegristroRoles")
    public String registroRoles(@Validated Roles roles, Model model) {
        model.addAttribute("role", new Roles());
        model.addAttribute("roles", rolesService.findAll());

        return "formularios/formRoles";
    }

    @PostMapping(value = "/guardarRoles")
    public String RegistroRol(@Validated Roles roles, RedirectAttributes flash, HttpServletRequest request,
            Model model) {

        String mensaje = "";

        Roles existeRol = rolesService.validarRoles(roles.getRol());

        if (existeRol == null || existeRol.getEstado().equals("X")) {
            // System.out.println("Se guardo el rol que no existe bb uwu");
            if (!roles.getDescripcion().isEmpty() && !roles.getSimbolo().isEmpty() && !roles.getRol().isEmpty()) {

                roles.setDescripcion(roles.getDescripcion().toUpperCase());
                roles.setSimbolo(roles.getSimbolo().toUpperCase());
                roles.setRol(roles.getRol().toUpperCase());
                roles.setObservacion(roles.getObservacion().toUpperCase());

                roles.setEstado("A");
                rolesService.save(roles);
                rolesService.findAll();
                mensaje = "Se registro correctamente";
                System.out.println("-----------1");

                model.addAttribute("roles", rolesService.findAll());
                return "redirect:/ListaDeRoles";

            }

        } else {
            mensaje = "ya existe el rol en la base de datos";
            System.out.println("-----------2");

            flash.addFlashAttribute("error", mensaje); // Agrega el mensaje como atributo flash
            System.out.println("Ya hay un rol existente en la base de datos");
            return "redirect:/ListaDeRoles";
        }
        mensaje = "No se ha registrado el rol";
        System.out.println("-----------3");

        model.addAttribute("roles", rolesService.findAll());
        model.addAttribute("mensaje", mensaje);
        return "listas/listaRoles";
    }

    @RequestMapping(value = "/eliminarRoles/{idRol}")
    public String eliminarRol(@PathVariable("idRol") Integer idRol) {
        Roles roles = rolesService.findOne(idRol);
        roles.setEstado("X");
        rolesService.save(roles);
        return "redirect:/ListaDeRoles";
    }

    @GetMapping(value = "/ListaDeRoles")
    public String listarRol(Model model) {
        model.addAttribute("roles", rolesService.findAll());
        
        return "listas/listaRoles";
    }

    /* modificar con el modal */
    @RequestMapping(value = "/roles/{idRol}")
    public String getContentRoless(@PathVariable(value = "idRol") Integer idRol, Model model,
            HttpServletRequest request) {

        model.addAttribute("role", rolesService.findOne(idRol));

        System.out.println("datos optenidos" + idRol);
        return "content :: contentRol";
    }

    /* registrar con el modal */
    @RequestMapping(value = "/registrarRoles")
    public String getRegistroRoles(Model model) {
        model.addAttribute("role", new Roles());
        return "content :: contentRol";
    }
}
