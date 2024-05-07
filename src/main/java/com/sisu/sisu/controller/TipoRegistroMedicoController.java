package com.sisu.sisu.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sisu.sisu.Service.TipoRegistroMedicoService;
import com.sisu.sisu.entitys.RecetaRemedios;
import com.sisu.sisu.entitys.TipoRegistroMedico;

@Controller
public class TipoRegistroMedicoController {

    @Autowired
    private TipoRegistroMedicoService tipoRegistroMedicoService;

    @GetMapping(value = "/VentanaFormTipoRegistroMedico")
    public String VentanaFormRecetaRemedios(Model model) {

        model.addAttribute("tipoRegistroMed", new TipoRegistroMedico());

        return "formularios/formTipoRegistroMedico";
    }

    @PostMapping(value = "/VentanaFormTipoRegistroMedicoModal")
    public String VentanaFormRecetaRemediosModal(Model model) {

        model.addAttribute("tipoRegistroMed", new TipoRegistroMedico());
        model.addAttribute("modalVentana", "true");
        return "formularios/formTipoRegistroMedico";
    }

    @PostMapping(value = "/VentanaEditFormTipoRegistroMedicoModal/{id}")
    public String VentanaEditFormRecetaRemediosModal(Model model, @PathVariable(value = "id") Integer idTipoRegistroMed) {

        model.addAttribute("tipoRegistroMed", tipoRegistroMedicoService.buscarId(idTipoRegistroMed));
        model.addAttribute("modalVentana", "true");
        model.addAttribute("edit", "true");
        return "formularios/formTipoRegistroMedico";
    }

    @PostMapping(value = "/CargarTablaTipoRegistroMedico")
    public String CargarTablaRecetaRemedios(Model model) {
        
        for (TipoRegistroMedico tipoRegistroMedico : tipoRegistroMedicoService.listarTodo()) {
            System.out.println("-----------"+ tipoRegistroMedico.getDescripcion());
        }
        model.addAttribute("listaTipoRegistroMedico", tipoRegistroMedicoService.listarTodo());
        model.addAttribute("tablaRecarga", "true");
        return "listas/listaTipoRegistroMedico";
    }

    @GetMapping(value = "/ListaTipoRegistroMedico")
    public String ListaRecetaRemedios(Model model) {
        model.addAttribute("listaTipoRegistroMedico", tipoRegistroMedicoService.listarTodo());
        return "listas/listaTipoRegistroMedico";
    }

    @PostMapping(value = "/RegistrarTipoRegistroMedico")
    @ResponseBody
    public ResponseEntity<String> RegistrarRecetaRemedios(@Validated TipoRegistroMedico tipoRegistroMedico) {
        if (tipoRegistroMedicoService.buscarPorNombre(tipoRegistroMedico.getNombTipoRegistroMedico()) == null) {
            tipoRegistroMedico.setEstado("A");
        tipoRegistroMedico.setRegistro(new Date());
        tipoRegistroMedicoService.registrar(tipoRegistroMedico);
        System.out.println("registrar");
        return ResponseEntity.ok("Registrar");
        } else {
            System.out.println("no registrar");
        return ResponseEntity.ok("No registrar");
        }
    }

    @PostMapping(value = "/RegistrarTipoRegistroMedico2")
    public String RegistrarRecetaRemedios2(@Validated TipoRegistroMedico tipoRegistroMedico) {
        tipoRegistroMedico.setEstado("A");
        tipoRegistroMedico.setRegistro(new Date());
        tipoRegistroMedicoService.registrar(tipoRegistroMedico);
        return "redirect:/ListaTipoRegistroMedico";
    }

    @PostMapping(value = "/ModificarTipoRegistroMedico")
    @ResponseBody
    public ResponseEntity<String> ModificarRecetaRemedios(@Validated TipoRegistroMedico tipoRegistroMedico) {
        TipoRegistroMedico tipoRegistroMedico2 = tipoRegistroMedicoService.buscarId(tipoRegistroMedico.getIdTipoRegistroMedico());
        tipoRegistroMedico.setEstado(tipoRegistroMedico2.getEstado());
        tipoRegistroMedico.setRegistro(tipoRegistroMedico2.getRegistro());
        tipoRegistroMedico.setModificacion(new Date());
        tipoRegistroMedicoService.registrar(tipoRegistroMedico);

        return ResponseEntity.ok("Modificar");
    }

    @PostMapping(value = "/EliminarTipoRegistroMedico/{id}")
    @ResponseBody
    public void EliminarRecetaRemedios(@PathVariable(value = "id") Integer idTipoRegistroMed) {
        tipoRegistroMedicoService.eliminar(tipoRegistroMedicoService.buscarId(idTipoRegistroMed));
    }
}
