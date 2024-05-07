package com.sisu.sisu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sisu.sisu.Service.EstadoCivilService;
import com.sisu.sisu.Service.IDipService;
import com.sisu.sisu.Service.IGradoService;
import com.sisu.sisu.Service.IPersonaService;
import com.sisu.sisu.entitys.Dip;
import com.sisu.sisu.entitys.GradoAcademico;
import com.sisu.sisu.entitys.Persona;
import com.sisu.sisu.entitys.TiposEstadoCivil;

@Controller
public class Personacontroller {
    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IDipService dipService;

    @Autowired
    private IGradoService gradoService;

    @Autowired
    private EstadoCivilService estadoCivilService;

    @GetMapping(value = "/formRegistro")
    public String registroPersona(@Validated Persona persona, Model model) {

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", personaService.findAll());

        model.addAttribute("dip", new Dip());
        model.addAttribute("dips", dipService.findAll());

        model.addAttribute("grado", new GradoAcademico());
        model.addAttribute("grados", gradoService.findAll());

        model.addAttribute("estadoCivil", new TiposEstadoCivil());
        model.addAttribute("estadosCiviles", estadoCivilService.findAll());

        return "formularios/formPersona";
    }
    
    /* GUARDAR */

    @PostMapping(value = "/guardarPersona")
    public String RegistrarPersona(@Validated Persona persona, RedirectAttributes flash, HttpServletRequest request,
            @RequestParam(name = "grado", required = false) Integer idGradoAcademico,
            @RequestParam(name = "dip", required = false) Integer idDip,
            @RequestParam(name = "estadoCivil", required = false) Integer idTipoEstadoCivil) {
        Persona existingPersona = personaService.findByCi(persona.getCi());

        if (existingPersona != null) {
            if ("A".equals(existingPersona.getEstado())) {
                flash.addFlashAttribute("error", "Ya existe una persona con ese CI en estado 'A': " + persona.getCi());
                return "redirect:/formRegistro";
            } else {
                // Actualiza el registro existente con estado 'X' a 'A'
                persona.setEstado("A");
                persona.setGrado_academico(gradoService.findOne(idGradoAcademico));
                persona.setDip(dipService.findOne(idDip));
                persona.setTipos_estado_civil(estadoCivilService.findOne(idTipoEstadoCivil));
                personaService.save(persona);
                return "redirect:/formRegistro";
            }
        } else {
            // No existe una persona con el mismo CI, crea un nuevo registro
            persona.setEstado("A");
            persona.setGrado_academico(gradoService.findOne(idGradoAcademico));
            persona.setDip(dipService.findOne(idDip));
            persona.setTipos_estado_civil(estadoCivilService.findOne(idTipoEstadoCivil));
            personaService.save(persona);
            return "redirect:/formRegistro";
        }
    }

    /* eliminar */

    @RequestMapping(value = "/eliminarPersona/{idPersona}")
    public String eliminarPersona(@PathVariable("idPersona") Integer idPersona) {

        Persona persona = personaService.findOne(idPersona);
        persona.setEstado("X");
        personaService.save(persona);
        return "redirect:/ListaPersona";
    }

    /* modificar un registro con el modal */

    @RequestMapping(value = "/persona/{idPersona}")
    public String getContent1(@PathVariable(value = "idPersona") Integer idPersona, Model model,
            HttpServletRequest request) {

        model.addAttribute("persona", personaService.findOne(idPersona));

        model.addAttribute("dips", dipService.findAll());
        model.addAttribute("grados", gradoService.findAll());
        model.addAttribute("estadosCiviles", estadoCivilService.findAll());

        return "content :: content1";
    }

    /* Registrar persona model */
    @RequestMapping(value = "/registrarPersona")
    public String getRegistroPersona(Model model) {
        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", personaService.findAll());

        model.addAttribute("dip", new Dip());
        model.addAttribute("dips", dipService.findAll());

        model.addAttribute("grado", new GradoAcademico());
        model.addAttribute("grados", gradoService.findAll());

        model.addAttribute("estadoCivil", new TiposEstadoCivil());
        model.addAttribute("estadosCiviles", estadoCivilService.findAll());
        
        return "content :: content1";
    }

    /* Editar */

    @RequestMapping(value = "/editarPersona/{idPersona}")
    public String editarPersona(@PathVariable("idPersona") Integer idPersona, Model model) {
        Persona persona = personaService.findOne(idPersona);
        model.addAttribute("persona", persona);
        return "formularios/formPersona";
    }

    /* Lista */

    @GetMapping(value = "/ListaPersona")
    public String listarPersona(Model model) {
        model.addAttribute("personas", personaService.findAll());

        model.addAttribute("dip", new Dip());
        model.addAttribute("dips", dipService.findAll());

        model.addAttribute("grado", new GradoAcademico());
        model.addAttribute("grados", gradoService.findAll());

        model.addAttribute("estadoCivil", new TiposEstadoCivil());
        model.addAttribute("estadosCiviles", estadoCivilService.findAll());

        return "listas/listasP";
    }

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosPersona")
    public String guardarCambiosPersona(@ModelAttribute Persona persona) {
        persona.setEstado("A");
        personaService.save(persona);
        return "redirect:/ListaPersona";
    }
}
