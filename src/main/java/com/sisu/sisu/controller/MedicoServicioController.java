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

import com.sisu.sisu.Service.MedicoServicioService;
import com.sisu.sisu.entitys.MedicoServicio;

@Controller
public class MedicoServicioController {

    @Autowired
    private MedicoServicioService medicoServicioService;

    /* guardar */
    @PostMapping(value = "/guardarMedicoServicioR")
    public String RegistrarMedicoServicioR(@Validated MedicoServicio medicoServicio) {
        medicoServicio.setEstado("A");
        medicoServicioService.save(medicoServicio);
        return "redirect:/ListaMedicoServicioR";
    }

    /* Eliminar */

    @RequestMapping(value = "/eliminarMedicoServicioR/{idMedicoServicio}")
    public String eliminarMedicoServicioR(@PathVariable("idMedicoServicio") Integer idMedicoServicio) {
        MedicoServicio medicoServicio = medicoServicioService.findOne(idMedicoServicio);
        medicoServicio.setEstado("X");
        medicoServicioService.save(medicoServicio);
        return "redirect:/ListaMedicoServicioR";

    }

    /* lista */
    @GetMapping(value = "/ListaMedicoServicioR")
    public String listarMedicoServicioR(Model model) {
        model.addAttribute("medicosServicio", medicoServicioService.findAll());

        return "listas/listaMedicoServicio";
    }

    /* modificar con el modal */

    @RequestMapping(value = "/medicoServicioR/{idMedicoServicio}")
    public String getContentMedicoServicio(@PathVariable(value = "idMedicoServicio") Integer idMedicoServicio,
            Model model,
            HttpServletRequest request) {
        model.addAttribute("medicoServicio", medicoServicioService.findAll());

        return "contentRE :: contentMedicoServicio";
    }

    /* Registrar con el modal */

    @RequestMapping(value = "/registrarMedicoServicio")
    public String getRegistroMedicoServicio(Model model) {
        model.addAttribute("medicoServicio", new MedicoServicio());
        model.addAttribute("medicosServicio", medicoServicioService.findAll());

        return "contentRE :: contentMedicoServicio";
    }
}
