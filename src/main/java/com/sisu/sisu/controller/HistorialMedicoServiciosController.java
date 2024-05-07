package com.sisu.sisu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisu.sisu.Service.HistorialMedicoService;
import com.sisu.sisu.Service.HistorialMedicoServiciosService;
import com.sisu.sisu.Service.MedicoServicioService;
import com.sisu.sisu.entitys.HistorialMedico;
import com.sisu.sisu.entitys.MedicoServicio;

import com.sisu.sisu.entitys.HistorialMedicoServicio;

@Controller
public class HistorialMedicoServiciosController {
    
    @Autowired
    private HistorialMedicoServiciosService historialMedicoServicioService;

    @Autowired
    private HistorialMedicoService historialMedicoServiciosService;

    @Autowired
    private MedicoServicioService medicoServicioService;



    /*--------------- eliminar -----------*/
   @RequestMapping(value = "/eliminarHistorialMedicoServicio/{id_historial_medico_servicio}")
    public String eliminarHistorialMedicoServicios(@PathVariable("id_historial_medico_servicio") Integer id_historial_medico_servicio) {

        HistorialMedicoServicio historialMedicoServicio = historialMedicoServicioService.findOne(id_historial_medico_servicio);
        historialMedicoServicio.setEstado("X");
        historialMedicoServicioService.save(historialMedicoServicio);

        return "redirect:/ListaHistorialMedicoServicio";
    }

        // Listar HM -------------------------
     @GetMapping(value = "/ListaHistorialMedicoServicio")
     public String listarHistorialMedicoServicios(Model model) {

        model.addAttribute("historialMedicoServicios", historialMedicoServicioService.findAll());

            model.addAttribute("historialMedico", new HistorialMedico());
        model.addAttribute("historialMedicos", historialMedicoServiciosService.findAll());


          model.addAttribute("medicoServicio", new MedicoServicio());
        model.addAttribute("medicoServicios", medicoServicioService.findAll());

        return "listas/ListaHistorialMedicoServicio";
    }

       /* Modificación Modal */
    @RequestMapping(value = "/historialMedicoServicios/{idHistorialMedicoServicio}")
    public String getContentHistorialMedicoServicio(@PathVariable(value = "idHistorialMedicoServicio") Integer idhistorialMedicoServiciosServicios, Model model,
            HttpServletRequest request) {

        model.addAttribute("historialMedicoServicio", historialMedicoServicioService.findOne(idhistorialMedicoServiciosServicios));

       model.addAttribute("historialMedicos", historialMedicoServiciosService.findAll());

      model.addAttribute("medicoServicios", medicoServicioService.findAll());

        return "contentDip :: contentHistorialMedicoServicio";

    }
/* Registrar Model */
  @RequestMapping(value = "/registrarHistorialMedicoServicio")
    public String getRegistroHistorialMedicoServicio(Model model) {

        model.addAttribute("historialMedicoServicio", new HistorialMedicoServicio());
        model.addAttribute("historialMedicoServicios", historialMedicoServicioService.findAll());

           model.addAttribute("historialMedico", new HistorialMedico());
        model.addAttribute("historialMedicos", historialMedicoServiciosService.findAll());


          model.addAttribute("medicoServicio", new MedicoServicio());
        model.addAttribute("medicoServicios", medicoServicioService.findAll());

        return "contentDip :: contentHistorialMedicoServicio";
    }


 /* Guardar Cambios */
    @PostMapping(value = "/guardarHistorialMedicoServicio")
    public String guardarHistorialMedico(@ModelAttribute HistorialMedicoServicio historialMedicoServicioServicio) {

        historialMedicoServicioServicio.setEstado("A");
        historialMedicoServicioService.save(historialMedicoServicioServicio);

        return "redirect:/ListaHistorialMedicoServicio";
    }


    

}
