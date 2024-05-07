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
import com.sisu.sisu.Service.HistorialRecetaService;
import com.sisu.sisu.Service.RecetaService;
import com.sisu.sisu.entitys.Receta;
import com.sisu.sisu.entitys.HistorialMedico;
import com.sisu.sisu.entitys.HistorialReceta;

@Controller
public class HistorialRecetaController {

    @Autowired
    private HistorialRecetaService historialRecetapService; 

     @Autowired
    private RecetaService  recetaService; 

         @Autowired
    private HistorialMedicoService  historialMedicoService; 

     /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarHistorialReceta/{id_historial_receta}")
    public String eliminarHistorialReceta(@PathVariable("id_historial_receta") Integer id_historial_receta) {

        HistorialReceta historialReceta = historialRecetapService.findOne(id_historial_receta);
        historialReceta.setEstado("X");
        historialRecetapService.save(historialReceta);
        return "redirect:/ListasHistorialReceta";

    }

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/ListasHistorialReceta")
    public String listarHistorialRecetas(Model model) {
 
        model.addAttribute("historialRecetas", historialRecetapService.findAll());

         model.addAttribute("receta", new Receta());
        model.addAttribute("recetas", recetaService.listarTodo());

        model.addAttribute("historialMedico", new HistorialMedico()); 
        
        return "listas/listaHistorialReceta";
    } 

    /* Modificación Modal */
    @RequestMapping(value = "/historialReceta/{idHistorialReceta}")
    public String getContentHistorialRecetas(@PathVariable(value = "idHistorialReceta") Integer idHistorialReceta, Model model,
            HttpServletRequest request) {

        model.addAttribute("historialReceta", historialRecetapService.findOne(idHistorialReceta));
      
          model.addAttribute("receta", new Receta());
        model.addAttribute("recetas", recetaService.listarTodo());

                model.addAttribute("historial_medico", new Receta());
        model.addAttribute("historialMedicos", historialMedicoService.findAll());
        
        return "contentDip :: contentHistorialRecetas";

    }

    /* Registrar  model */
    @RequestMapping(value = "/registrarHistorialRecetas")
    public String getRegistroHistorialRecetas(Model model) {

        model.addAttribute("historialReceta", new HistorialReceta());
        model.addAttribute("HistorialRecetas", historialRecetapService.findAll());

          model.addAttribute("receta", new Receta());
        model.addAttribute("recetas", recetaService.listarTodo());

         model.addAttribute("historialMedico", new HistorialMedico());
        model.addAttribute("historialMedicos", historialMedicoService.findAll());

        return "contentDip :: contentHistorialRecetas";
    } 
    
    /* Guardar Cambios */
    @PostMapping(value = "/guardarHistorialReceta")
    public String guardarHistorialRecetas(@ModelAttribute HistorialReceta historialReceta) {
        historialReceta.setEstado("A");
        historialRecetapService.save(historialReceta);
        return "redirect:/ListasHistorialReceta";
    } 
}
