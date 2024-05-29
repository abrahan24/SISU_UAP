package com.sisu.sisu.controller.HistorialesMedicos;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sisu.sisu.entitys.HistoriaClinica;

@Controller
public class HistorialesMedicosControllers {
    



     @GetMapping(value = "/verHistorialMedico/{idFicha}")
    public String verHistorialMedico(
            Model model,@PathVariable(name = "idFicha")Integer idFicha) {
                // HistoriaClinica historiaClinica = historiaClinicaService.findOne(idHistoriaClinica);
                // LocalDate fecha = historiaClinica.getFechaAtencionMedica().toInstant().atZone(ZoneId.systemDefault())
                // .toLocalDate();
                // model.addAttribute("asegurado", historiaClinica.getHistorialSeguro().getAsegurado());
                // model.addAttribute("historiaClinica", historiaClinica);
                // model.addAttribute("fechaH", fecha);

        return "historialesMedicos/mainHistorial";
    }
}
