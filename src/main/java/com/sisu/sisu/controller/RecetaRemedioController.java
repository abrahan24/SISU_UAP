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

import com.sisu.sisu.Service.IRemediosFarmaciaService;
import com.sisu.sisu.Service.RecetaService;
import com.sisu.sisu.Service.ResetaRemedioService;
import com.sisu.sisu.entitys.RecetaRemedios;

@Controller
public class RecetaRemedioController {
    @Autowired
    private IRemediosFarmaciaService remediosFarmaciaService;

    @Autowired
    private ResetaRemedioService resetaRemedioService;

    @Autowired
    private RecetaService recetaService;

    @GetMapping(value = "/VentanaFormRecetaRemedios")
    public String VentanaFormRecetaRemedios(Model model) {

        model.addAttribute("recetaRemedio", new RecetaRemedios());
        model.addAttribute("listReceta", recetaService.listarTodo());
        model.addAttribute("listaRemediosFarmacia", remediosFarmaciaService.findAll());

        return "formularios/formRecetaRemedios";
    }

    @PostMapping(value = "/VentanaFormRecetaRemediosModal")
    public String VentanaFormRecetaRemediosModal(Model model) {

        model.addAttribute("recetaRemedio", new RecetaRemedios());
        model.addAttribute("listReceta", recetaService.listarTodo());
        model.addAttribute("listaRemediosFarmacia", remediosFarmaciaService.findAll());
        model.addAttribute("modalVentana", "true");
        return "formularios/formRecetaRemedios";
    }

    @PostMapping(value = "/VentanaEditFormRecetaRemediosModal/{idRecetaRemedios}")
    public String VentanaEditFormRecetaRemediosModal(Model model, @PathVariable(value = "idRecetaRemedios") Integer idRecetaRemedios) {

        model.addAttribute("recetaRemedio", resetaRemedioService.buscarId(idRecetaRemedios));
        model.addAttribute("listReceta", recetaService.listarTodo());
        model.addAttribute("listaRemediosFarmacia", remediosFarmaciaService.findAll());
        model.addAttribute("modalVentana", "true");
        model.addAttribute("edit", "true");
        return "formularios/formRecetaRemedios";
    }

    @PostMapping(value = "/CargarTablaRecetaRemedios")
    public String CargarTablaRecetaRemedios(Model model) {
        model.addAttribute("listRecetaRemedios", resetaRemedioService.listarTodo());
        model.addAttribute("tablaRecarga", "true");
        return "listas/listaRecetaRemedios";
    }

    @GetMapping(value = "/ListaRecetaRemedios")
    public String ListaRecetaRemedios(Model model) {
        model.addAttribute("listRecetaRemedios", resetaRemedioService.listarTodo());
        return "listas/listaRecetaRemedios";
    }

    @PostMapping(value = "/RegistrarRecetaRemedios")
    @ResponseBody
    public void RegistrarRecetaRemedios(@Validated RecetaRemedios recetaRemedios) {
        recetaRemedios.setEstado("A");
        recetaRemedios.setRegistro(new Date());
        resetaRemedioService.registrar(recetaRemedios);
    }

    @PostMapping(value = "/RegistrarRecetaRemedios2")
    public String RegistrarRecetaRemedios2(@Validated RecetaRemedios recetaRemedios) {
        recetaRemedios.setEstado("A");
        recetaRemedios.setRegistro(new Date());
        resetaRemedioService.registrar(recetaRemedios);
        return "redirect:/ListaRecetaRemedios";
    }

    @PostMapping(value = "/ModificarRecetaRemedios")
    @ResponseBody
    public void ModificarRecetaRemedios(@Validated RecetaRemedios recetaRemedios) {
        RecetaRemedios recetaRemedios2 = resetaRemedioService.buscarId(recetaRemedios.getIdRecetaRemedios());
        recetaRemedios.setEstado(recetaRemedios2.getEstado());
        recetaRemedios.setRegistro(recetaRemedios2.getRegistro());
        recetaRemedios.setModificacion(new Date());
        resetaRemedioService.registrar(recetaRemedios);
    }

    @PostMapping(value = "/EliminarRecetaRemedios/{idRecetaRemedios}")
    @ResponseBody
    public void EliminarRecetaRemedios(@PathVariable(value = "idRecetaRemedios") Integer idRecetaRemedios) {
        resetaRemedioService.eliminar(resetaRemedioService.buscarId(idRecetaRemedios));
    }
}
