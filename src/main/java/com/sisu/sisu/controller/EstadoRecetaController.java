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

import com.sisu.sisu.Service.EstadoRecetaService;
import com.sisu.sisu.entitys.EstadoReceta;

@Controller
public class EstadoRecetaController {

    @Autowired
    private EstadoRecetaService estadoRecetaService;

    /* guardar */
    @PostMapping(value = "/guardarEstadoR")
    public String RegistrarEstadoR(@Validated EstadoReceta estadoReceta) {
        estadoReceta.setEstado("A");
        estadoRecetaService.save(estadoReceta);
        return "redirect:/ListaEstadoR";
    }

    /* Eliminar */

    @RequestMapping(value = "/eliminarEstadoR/{idEstadoReceta}")
    public String eliminarEstadoR(@PathVariable("idEstadoReceta") Integer idEstadoReceta) {
        EstadoReceta estadoReceta = estadoRecetaService.findOne(idEstadoReceta);
        estadoReceta.setEstado("X");
        estadoRecetaService.save(estadoReceta);
        return "redirect:/ListaEstadoR";

    }

    /* lista */
    @GetMapping(value = "/ListaEstadoR")
    public String listarEstadoR(Model model) {

        model.addAttribute("estadosReceta", estadoRecetaService.findAll());

        return "listas/listaEstadoReceta";
    }

    /* modificar con el modal */

    @RequestMapping(value = "/estadoReceta/{idEstadoReceta}")
    public String getContentEstadoReceta(@PathVariable(value = "idEstadoReceta") Integer idEstadoReceta, Model model,
            HttpServletRequest request) {
        model.addAttribute("estadoReceta", estadoRecetaService.findOne(idEstadoReceta));

        return "contentRE :: contentEstadoReceta";
    }
    /* Registrar con el modal */

    @RequestMapping(value = "/registrarEstadoReceta")
    public String getRegistroEstadoReceta(Model model) {
        model.addAttribute("estadoReceta", new EstadoReceta());
        model.addAttribute("estadosReceta", estadoRecetaService.findAll());

        return "contentRE :: contentEstadoReceta";
    }

}
