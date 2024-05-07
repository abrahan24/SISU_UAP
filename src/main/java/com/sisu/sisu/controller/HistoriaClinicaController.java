package com.sisu.sisu.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sisu.sisu.Service.FichaService;
import com.sisu.sisu.Service.HistoriaClinicaService;
import com.sisu.sisu.Service.HistorialSeguroService;
import com.sisu.sisu.Service.IAseguradoService;
import com.sisu.sisu.entitys.Asegurado;
import com.sisu.sisu.entitys.HistoriaClinica;
import com.sisu.sisu.entitys.HistorialSeguro;

@Controller
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @Autowired
    private HistorialSeguroService historialSeguroService;

    @Autowired
    private IAseguradoService aseguradoService;

    @GetMapping(value = "/formHistorialClinico/{id}")
    public String registroRoles(@Validated HistoriaClinica historiaClinica, @PathVariable(name = "id") Integer id,
            Model model) {

        HistorialSeguro historialSeguro = historialSeguroService.findOne(id);

        model.addAttribute("historialSeguro", historialSeguro);
        // model.addAttribute("historiaClinica", new HistoriaClinica());
        model.addAttribute("historiaClinicas", historiaClinicaService.findAll());

        return "formularios/FormHistoriaClinica";
    }

    @PostMapping(value = "/guardarHistorialClinico")
    public String RegistroRol(@Validated HistoriaClinica historiaClinica, Model model,
            @RequestParam(value = "idAsegurado", required = false) Integer idAsegurado,
            @RequestParam(value = "idHistorialSeguro", required = false) Integer idHistorialSeguro,
            @RequestParam(value = "patolgiaImput", required = false) String patolgiaImput,
            @RequestParam(value = "factorImput", required = false) String factorImput,
            @RequestParam(value = "factoresRiesgo", required = false) String factoresRiesgo,
            @RequestParam(value = "radioPatologia", required = false) String radioPatologia) {
        System.out.println("ASEGURADO: " + idAsegurado);
        System.out.println("idHistorialSeguro: " + idHistorialSeguro);
        try {
            if (patolgiaImput != null) {
                historiaClinica.setPatologias(patolgiaImput);
            } else {
                historiaClinica.setPatologias(radioPatologia);
            }
            if (factorImput != null) {
                historiaClinica.setFactoresRiesgo(factorImput);
            } else {
                historiaClinica.setFactoresRiesgo(factoresRiesgo);
            }
            historiaClinica.setEstadoHistoriaClinica("A");
            historiaClinica.setFechaAtencionMedica(new Date());
            historiaClinica.setRegistro(new Date());
            historiaClinicaService.save(historiaClinica);
            model.addAttribute("historialSeguro", historialSeguroService.findOne(idHistorialSeguro));
            model.addAttribute("asegurado", aseguradoService.findOne(idAsegurado));
            model.addAttribute("historiaClinica", historiaClinica);
            Asegurado asegurado = aseguradoService.findOne(idAsegurado);
            System.out.println("fecha Nac:" + asegurado.getPersona().getFecha_nac());
            LocalDate fechaActual = LocalDate.now();
            int edad = Period.between(asegurado.getPersona().getFecha_nac(), fechaActual).getYears();
            System.out.println("EDAD ACTUAL:" + edad);
            model.addAttribute("edad", edad);

            LocalDate fecha = historiaClinica.getFechaAtencionMedica().toInstant().atZone(ZoneId.systemDefault())
                    .toLocalDate();
            LocalTime hora = historiaClinica.getFechaAtencionMedica().toInstant().atZone(ZoneId.systemDefault())
                    .toLocalTime();
            model.addAttribute("fechaH", fecha);
            model.addAttribute("horaH", hora);
            return "formularios/VistaHistoriaClinica";
        } catch (Exception e) {

            return "redirect:/formHistorialClinico";
        }
    }

}
