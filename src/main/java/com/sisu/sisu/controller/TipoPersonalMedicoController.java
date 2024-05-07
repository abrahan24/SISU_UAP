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

import com.sisu.sisu.Service.TipoPersonalMedicoService;
import com.sisu.sisu.entitys.TipoPersonalMedico;

@Controller
public class TipoPersonalMedicoController {

    @Autowired
    private TipoPersonalMedicoService tipoPersonalMedicoService;

    @GetMapping(value = "/VentanaFormTipoPersonalMedico")
    public String VentanaFormTipoPersonalMedico(Model model) {

        model.addAttribute("tipoPersonalMed", new TipoPersonalMedico());

        return "formularios/formTipoPersonalMedico";
    }

    @PostMapping(value = "/VentanaFormTipoPersonalMedicoModal")
    public String VentanaFormTipoPersonalMedicoModal(Model model) {

        model.addAttribute("tipoPersonalMed", new TipoPersonalMedico());
        model.addAttribute("modalVentana", "true");
        return "formularios/formTipoPersonalMedico";
    }

    @PostMapping(value = "/VentanaEditFormTipoPersonalMedicoModal/{id}")
    public String VentanaEditFormTipoPersonalMedicoModal(Model model, @PathVariable(value = "id") Integer idTipoPersonalMed) {

        model.addAttribute("tipoPersonalMed", tipoPersonalMedicoService.buscarId(idTipoPersonalMed));
        model.addAttribute("modalVentana", "true");
        model.addAttribute("edit", "true");
        return "formularios/formTipoPersonalMedico";
    }

    @PostMapping(value = "/CargarTablaTipoPersonalMedico")
    public String CargarTablaTipoPersonalMedico(Model model) {

        model.addAttribute("listaTipoPersonalMedico", tipoPersonalMedicoService.listarTodo());
        model.addAttribute("tablaRecarga", "true");
        return "listas/listaTipoPersonalMedico";
    }

    @GetMapping(value = "/ListaTipoPersonalMedico")
    public String ListaTipoPersonalMedico(Model model) {
        model.addAttribute("listaTipoPersonalMedico", tipoPersonalMedicoService.listarTodo());
        return "listas/listaTipoPersonalMedico";
    }

    @PostMapping(value = "/RegistrarTipoPersonalMedico")
    @ResponseBody
    public ResponseEntity<String> RegistrarTipoPersonalMedico(@Validated TipoPersonalMedico tipoPersonalMedico) {
        if (tipoPersonalMedicoService.buscarPorNombre(tipoPersonalMedico.getTipoPersonal()) == null) {
            tipoPersonalMedico.setEstado("A");
        tipoPersonalMedico.setRegistro(new Date());
        tipoPersonalMedicoService.registrar(tipoPersonalMedico);
        System.out.println("registrar");
        return ResponseEntity.ok("Registrar");
        } else {
            System.out.println("no registrar");
        return ResponseEntity.ok("No registrar");
        }
    }

    @PostMapping(value = "/RegistrarTipoPersonalMedico2")
    public String RegistrarTipoPersonalMedico2(@Validated TipoPersonalMedico tipoPersonalMedico) {
        tipoPersonalMedico.setEstado("A");
        tipoPersonalMedico.setRegistro(new Date());
        tipoPersonalMedicoService.registrar(tipoPersonalMedico);
        return "redirect:/ListaTipoPersonalMedico";
    }

    @PostMapping(value = "/ModificarTipoPersonalMedico")
    @ResponseBody
    public ResponseEntity<String> ModificarTipoPersonalMedico(@Validated TipoPersonalMedico tipoPersonalMedico) {
        TipoPersonalMedico tipoRegistroMedico2 = tipoPersonalMedicoService.buscarId(tipoPersonalMedico.getIdTipoPersonalMedico());
        tipoPersonalMedico.setEstado(tipoRegistroMedico2.getEstado());
        tipoPersonalMedico.setRegistro(tipoRegistroMedico2.getRegistro());
        tipoPersonalMedico.setModificacion(new Date());
        tipoPersonalMedicoService.registrar(tipoPersonalMedico);

        return ResponseEntity.ok("Modificar");
    }

    @PostMapping(value = "/EliminarTipoPersonalMedico/{id}")
    @ResponseBody
    public void EliminarTipoPersonalMedico(@PathVariable(value = "id") Integer idTipoPersonalMed) {
        tipoPersonalMedicoService.eliminar(tipoPersonalMedicoService.buscarId(idTipoPersonalMed));
    }
}
