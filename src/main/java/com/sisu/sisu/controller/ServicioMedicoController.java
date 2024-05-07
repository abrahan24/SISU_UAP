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

import com.sisu.sisu.Service.ServicioMedicoService;
import com.sisu.sisu.entitys.ServicioMedico;

@Controller
public class ServicioMedicoController {

    @Autowired
    private ServicioMedicoService servicioMedicoService;

    /* guardar */
    @PostMapping(value = "/guardarServicioMedicoR")
    public String RegistrarServicioMedicoR(@Validated ServicioMedico servicioMedico) {
        servicioMedico.setEstado("A");
        servicioMedicoService.save(servicioMedico);
        return "redirect:/ListaServicioMedicoR";
    }

    /* Eliminar */

    @RequestMapping(value = "/eliminarServicioMedicoR/{idServicioMedico}")
    public String eliminarServicioMedicoR(@PathVariable("idServicioMedico") Integer idServicioMedico) {
        ServicioMedico servicioMedico = servicioMedicoService.findOne(idServicioMedico);
        servicioMedico.setEstado("X");
        servicioMedicoService.save(servicioMedico);
        return "redirect:/ListaServicioMedicoR";

    }

    /* lista */
    @GetMapping(value = "/ListaServicioMedicoR")
    public String listarServicioMedicoR(Model model) {

        model.addAttribute("serviciosMedicos", servicioMedicoService.findAll());

        return "listas/listaServicioMedico";
    }

    /* modificar con el modal */

    @RequestMapping(value = "/servicioMedico/{idServicioMedico}")
    public String getContentServicioMedico(@PathVariable(value = "idServicioMedico") Integer idServicioMedico,
            Model model,
            HttpServletRequest request) {
        model.addAttribute("servicioMedico", servicioMedicoService.findAll());

        return "contentRE :: contentServicioMedico";
    }

    /* Registrar con el modal */

    @RequestMapping(value = "/registrarServicioMedico")
    public String getRegistroServicioMedico(Model model) {
        model.addAttribute("servicioMedico", new ServicioMedico());
        model.addAttribute("serviciosMedicos", servicioMedicoService.findAll());

        return "contentRE :: contentServicioMedico";
    }
}