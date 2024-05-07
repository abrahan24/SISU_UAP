package com.sisu.sisu.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sisu.sisu.Service.EstadoRecetaService;
import com.sisu.sisu.Service.ITipoRecetaService;
import com.sisu.sisu.Service.RecetaService;
import com.sisu.sisu.entitys.Receta;

@Controller
public class RecetaController {

    @Autowired
    private ITipoRecetaService tipoRecetaService;

    @Autowired
    private EstadoRecetaService estadoRecetaService;

    @Autowired
    private RecetaService recetaService;

    @GetMapping(value = "/VentanaFormReceta")
    public String VentanaFormReceta(Model model) {

        model.addAttribute("receta", new Receta());
        model.addAttribute("tipoRecetas", tipoRecetaService.findAll());
        model.addAttribute("estadoRecetas", estadoRecetaService.findAll());

        return "formularios/formReceta";
    }

    @PostMapping(value = "/VentanaFormRecetaModal")
    public String VentanaFormRecetaModal(Model model) {

        model.addAttribute("receta", new Receta());
        model.addAttribute("tipoRecetas", tipoRecetaService.findAll());
        model.addAttribute("estadoRecetas", estadoRecetaService.findAll());
        model.addAttribute("modalVentana", "true");
        return "formularios/formReceta";
    }

    @PostMapping(value = "/VentanaEditFormRecetaModal/{idReceta}")
    public String VentanaEditFormRecetaModal(Model model, @PathVariable(value = "idReceta") Integer idReceta) {

        model.addAttribute("receta", recetaService.buscarRecetaId(idReceta));
        model.addAttribute("tipoRecetas", tipoRecetaService.findAll());
        model.addAttribute("estadoRecetas", estadoRecetaService.findAll());
        model.addAttribute("modalVentana", "true");
        model.addAttribute("edit", "true");
        return "formularios/formReceta";
    }

    @PostMapping(value = "/CargarTablaReceta")
    public String CargarTablaReceta(Model model) {
        model.addAttribute("recetas", recetaService.listarTodo());
        model.addAttribute("tablaRecarga", "true");
        return "listas/listaReceta";
    }

    @GetMapping(value = "/ListaReceta2")
    public String ListaReceta(Model model) {
        model.addAttribute("recetas", recetaService.listarTodo());
        return "listas/listaReceta";
    }

    @PostMapping(value = "/RegistrarReceta")
    @ResponseBody
    public void RegistrarReceta(@Validated Receta receta) {
        receta.setEstado("A");
        receta.setRegistro(new Date());
        recetaService.registrarReceta(receta);
    }

    @PostMapping(value = "/RegistrarReceta2")
    public String RegistrarReceta2(@Validated Receta receta) {
        receta.setEstado("A");
        receta.setRegistro(new Date());
        recetaService.registrarReceta(receta);
        return "redirect:/ListaReceta2";
    }

    @PostMapping(value = "/ModificarReceta")
    @ResponseBody
    public void ModificarReceta(@Validated Receta receta) {
        Receta receta2 = recetaService.buscarRecetaId(receta.getIdReceta());
        receta.setEstado(receta2.getEstado());
        receta.setRegistro(receta2.getRegistro());
        receta.setModificacion(new Date());
        recetaService.registrarReceta(receta);
    }

    @PostMapping(value = "/EliminarReceta/{idReceta}")
    @ResponseBody
    public void ModificarReceta(@PathVariable(value = "idReceta") Integer idReceta) {
        recetaService.eliminarReceta(recetaService.buscarRecetaId(idReceta));
    }
}
