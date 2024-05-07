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

import com.sisu.sisu.Service.IPersonaService;
import com.sisu.sisu.Service.PersonalMedicoService;
import com.sisu.sisu.Service.TipoPersonalMedicoService;
import com.sisu.sisu.Service.TipoRegistroMedicoService;
import com.sisu.sisu.entitys.PersonalMedico;

@Controller
public class PersonalMedicoController {
    @Autowired
    private PersonalMedicoService personalMedicoService;

    @Autowired
    private TipoPersonalMedicoService tipoPersonalMedicoService;

    @Autowired
    private TipoRegistroMedicoService tipoRegistroMedicoService;

    @Autowired
    private IPersonaService personaService;

    @GetMapping(value = "/VentanaFormPersonalMedico")
    public String VentanaFormTipoPersonalMedico(Model model) {

        model.addAttribute("personalMed", new PersonalMedico());
        model.addAttribute("listaTipoPersonalMedico", tipoPersonalMedicoService.listarTodo());
        model.addAttribute("listaTipoRegistroMedico", tipoRegistroMedicoService.listarTodo());
        model.addAttribute("personas", personaService.findAll());
        model.addAttribute("personalMed", new PersonalMedico());
        return "formularios/formPersonalMedico";
    }

    @PostMapping(value = "/VentanaFormPersonalMedicoModal")
    public String VentanaFormTipoPersonalMedicoModal(Model model) {

        model.addAttribute("personalMed", new PersonalMedico());
        model.addAttribute("listaTipoPersonalMedico", tipoPersonalMedicoService.listarTodo());
        model.addAttribute("listaTipoRegistroMedico", tipoRegistroMedicoService.listarTodo());
        model.addAttribute("personas", personaService.findAll());
        model.addAttribute("modalVentana", "true");
        return "formularios/formPersonalMedico";
    }

    @PostMapping(value = "/VentanaEditFormPersonalMedicoModal/{id}")
    public String VentanaEditFormTipoPersonalMedicoModal(Model model,
            @PathVariable(value = "id") Integer idTipoPersonalMed) {
        PersonalMedico personalMedico = personalMedicoService.buscarId(idTipoPersonalMed);
        System.out.println("datos: "+personalMedico.getFechaInicio());
        model.addAttribute("datosF", personalMedico.getFechaInicio());
        model.addAttribute("personalMed", personalMedicoService.buscarId(idTipoPersonalMed));
        model.addAttribute("listaTipoPersonalMedico", tipoPersonalMedicoService.listarTodo());
        model.addAttribute("listaTipoRegistroMedico", tipoRegistroMedicoService.listarTodo());
        model.addAttribute("personas", personaService.findAll());
        model.addAttribute("modalVentana", "true");
        model.addAttribute("edit", "true");
        return "formularios/formPersonalMedico";
    }

    @PostMapping(value = "/CargarTablaPersonalMedico")
    public String CargarTablaTipoPersonalMedico(Model model) {

        model.addAttribute("listaPersonalMedico", personalMedicoService.listarTodo());
        model.addAttribute("tablaRecarga", "true");
        return "listas/listaPersonalMedico";
    }

    @GetMapping(value = "/ListaPersonalMedico")
    public String ListaTipoPersonalMedico(Model model) {
        model.addAttribute("listaPersonalMedico", personalMedicoService.listarTodo());
        return "listas/listaPersonalMedico";
    }

    @PostMapping(value = "/RegistrarPersonalMedico")
    @ResponseBody
    public ResponseEntity<String> RegistrarTipoPersonalMedico(@Validated PersonalMedico personalMedico) {
        personalMedico.setEstado("A");
        personalMedico.setRegistro(new Date());
        personalMedicoService.registrar(personalMedico);
        System.out.println("registrar");
        return ResponseEntity.ok("Registrar");
    }

    @PostMapping(value = "/RegistrarPersonalMedico2")
    public String RegistrarTipoPersonalMedico2(@Validated PersonalMedico personalMedico) {
        personalMedico.setEstado("A");
        personalMedico.setRegistro(new Date());
        personalMedicoService.registrar(personalMedico);
        return "redirect:/ListaPersonalMedico";
    }

    @PostMapping(value = "/ModificarPersonalMedico")
    @ResponseBody
    public ResponseEntity<String> ModificarTipoPersonalMedico(@Validated PersonalMedico personalMedico) {
        PersonalMedico personalMedico2 = personalMedicoService.buscarId(personalMedico.getIdPersonalMedico());
        personalMedico.setEstado(personalMedico2.getEstado());
        personalMedico.setRegistro(personalMedico2.getRegistro());
        personalMedico.setModificacion(new Date());
        personalMedicoService.registrar(personalMedico);

        return ResponseEntity.ok("Modificar");
    }

    @PostMapping(value = "/EliminarPersonalMedico/{id}")
    @ResponseBody
    public void EliminarTipoPersonalMedico(@PathVariable(value = "id") Integer idPersonalMed) {
        personalMedicoService.eliminar(personalMedicoService.buscarId(idPersonalMed));
    }
}
