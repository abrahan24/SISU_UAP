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
import com.sisu.sisu.Service.PersonalMedicoTurnoService;
import com.sisu.sisu.Service.TipoPersonalMedicoService;
import com.sisu.sisu.Service.TipoRegistroMedicoService;
import com.sisu.sisu.entitys.PersonalMedico;
import com.sisu.sisu.entitys.PersonalMedicoTurno;

@Controller
public class PersonalMedicoTurnoController {
    @Autowired
    private PersonalMedicoService personalMedicoService;

    @Autowired
    private PersonalMedicoTurnoService medicoTurnoService;

    @GetMapping(value = "/VentanaFormPersonalMedicoTurno")
    public String VentanaFormPersonalMedicoTurno(Model model) {

        model.addAttribute("personalMedTurno", new PersonalMedicoTurno());
        model.addAttribute("listaPersonalMedico", personalMedicoService.listarTodo());
        return "formularios/formPersonalMedicoTurno";
    }

    @PostMapping(value = "/VentanaFormPersonalMedicoTurnoModal")
    public String VentanaFormPersonalMedicoTurnoModal(Model model) {

        model.addAttribute("personalMedTurno", new PersonalMedicoTurno());
        model.addAttribute("listaPersonalMedico", personalMedicoService.listarTodo());
        model.addAttribute("modalVentana", "true");
        return "formularios/formPersonalMedicoTurno";
    }

    @PostMapping(value = "/VentanaEditFormPersonalMedicoTurnoModal/{id}")
    public String VentanaEditFormPersonalMedicoTurnoModal(Model model,
            @PathVariable(value = "id") Integer idPersonalMedT) {
        model.addAttribute("personalMedTurno", medicoTurnoService.buscarId(idPersonalMedT));
        model.addAttribute("listaPersonalMedico", personalMedicoService.listarTodo());
        model.addAttribute("modalVentana", "true");
        model.addAttribute("edit", "true");
        return "formularios/formPersonalMedicoTurno";
    }

    @PostMapping(value = "/CargarTablaPersonalMedicoTurno")
    public String CargarTablaPersonalMedicoTurno(Model model) {

        model.addAttribute("listaPersonalMedicoT", medicoTurnoService.listarTodo());
        model.addAttribute("tablaRecarga", "true");
        return "listas/listaPersonalMedicoTurno";
    }

    @GetMapping(value = "/ListaPersonalMedicoTurno")
    public String ListaPersonalMedicoTurno(Model model) {
        model.addAttribute("listaPersonalMedicoT", medicoTurnoService.listarTodo());
        return "listas/listaPersonalMedicoTurno";
    }

    @PostMapping(value = "/RegistrarPersonalMedicoTurno")
    @ResponseBody
    public ResponseEntity<String> RegistrarPersonalMedicoTurno(@Validated PersonalMedicoTurno medicoTurno) {
        medicoTurno.setEstado("A");
        medicoTurno.setRegistro(new Date());
        medicoTurnoService.registrar(medicoTurno);
        System.out.println("registrar");
        return ResponseEntity.ok("Registrar");
    }

    @PostMapping(value = "/RegistrarPersonalMedicoTurno2")
    public String RegistrarPersonalMedicoTurno2(@Validated PersonalMedicoTurno medicoTurno) {
        medicoTurno.setEstado("A");
        medicoTurno.setRegistro(new Date());
        medicoTurnoService.registrar(medicoTurno);
        return "redirect:/ListaPersonalMedicoTurno";
    }

    @PostMapping(value = "/ModificarPersonalMedicoTurno")
    @ResponseBody
    public ResponseEntity<String> ModificarPersonalMedicoTurno(@Validated PersonalMedicoTurno medicoTurno) {
        PersonalMedicoTurno medicoTurno2 = medicoTurnoService.buscarId(medicoTurno.getIdPersonalMedicoTurno());
        medicoTurno.setEstado(medicoTurno2.getEstado());
        medicoTurno.setRegistro(medicoTurno2.getRegistro());
        medicoTurno.setModificacion(new Date());
        medicoTurnoService.registrar(medicoTurno);

        return ResponseEntity.ok("Modificar");
    }

    @PostMapping(value = "/EliminarPersonalMedicoTurno/{id}")
    @ResponseBody
    public void EliminarPersonalMedicoTurno(@PathVariable(value = "id") Integer idPersonalMedT) {
        medicoTurnoService.eliminar(medicoTurnoService.buscarId(idPersonalMedT));
    }
}
