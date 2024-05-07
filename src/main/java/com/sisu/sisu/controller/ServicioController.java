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

import com.sisu.sisu.Service.ServicioService;
import com.sisu.sisu.entitys.Servicio;

@Controller
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    /* guardar */
    @PostMapping(value = "/guardarServicioR")
    public String RegistrarServicioR(@Validated Servicio servicio) {
        servicio.setEstado("A");
        servicioService.save(servicio);
         return "redirect:/ListaServicioR";
        
    }

    /* Eliminar */

    @RequestMapping(value = "/eliminarServicioR/{idServicio}")
    public String eliminarServicioR(@PathVariable("idServicio") Integer idServicio) {
        Servicio servicio = servicioService.findOne(idServicio);
        servicio.setEstado("X");
        servicioService.save(servicio);
        return "redirect:/ListaServicioR";

    }

    

    /* lista */
    @GetMapping(value = "/ListaServicioR")
    public String listarServicioR(Model model) {
        model.addAttribute("servicios", servicioService.findAll());
        return "listas/listaServicioPrueba";

    }

    /* modificar con el modal */

    @RequestMapping(value = "/servicio/{idServicio}")
    public String getContentServicio(@PathVariable(value = "idServicio") Integer idServicio, Model model,
            HttpServletRequest request) {
        model.addAttribute("servicio", servicioService.findOne(idServicio));
System.out.println("ESTA LLEGNADO HASTA AQUI+++++++++++++++++++++++++++");
        return "contentRE :: contentServicio";
    }
    
    /* Registrar con el modal */
    @RequestMapping(value = "/registrarServicio")
    public String getRegistroServicio(Model model) {
        model.addAttribute("servicio", new Servicio());
        model.addAttribute("servicios", servicioService.findAll());

        return "contentRE :: contentServicio";
    }

}
