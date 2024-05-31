package com.sisu.sisu.controller;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sisu.sisu.Service.IAseguradoService;
import com.sisu.sisu.entitys.Asegurado;


@Controller
public class IndicacionMedicaController {

    @Autowired
    private IAseguradoService aseguradoService;

    @GetMapping(value = "/verModeloIndicacionMedicaObservacion/{idAsegurado}")
    public String verModeloIndicacionMedicaObservacion(Model model,@PathVariable(name = "idAsegurado")Integer idAsegurado) {
       
            LocalDate fechaActual = LocalDate.now();
            Asegurado asegurado = aseguradoService.findOne(idAsegurado);
            model.addAttribute("asegurado", asegurado);
            model.addAttribute("fechaH", fechaActual);

        return "indicacionMedica/indicacion_medica_modelo_observacion";
    }

    @GetMapping(value = "/verModeloIndicacionMedicaInternacion/{idAsegurado}")
    public String verModeloIndicacionMedicaInternacion(Model model,@PathVariable(name = "idAsegurado")Integer idAsegurado) {
       
            LocalDate fechaActual = LocalDate.now();
            Asegurado asegurado = aseguradoService.findOne(idAsegurado);
            model.addAttribute("asegurado", asegurado);
            model.addAttribute("fechaH", fechaActual);

        return "indicacionMedica/indicacion_medica_modelo_internacion";
    }
}
