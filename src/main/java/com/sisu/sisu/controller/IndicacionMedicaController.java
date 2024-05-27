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

    @GetMapping(value = "/verModeloIndicacionMedica/{idAsegurado}")
    public String verModeloIndicacionMedica(Model model,@PathVariable(name = "idAsegurado")Integer idAsegurado) {
        System.out.println("ENTROOOOO");
            LocalDate fechaActual = LocalDate.now();
            Asegurado asegurado = aseguradoService.findOne(idAsegurado);
            model.addAttribute("asegurado", asegurado);
            model.addAttribute("fechaH", fechaActual);

        return "indicacionMedica/indicacion_medica_modelo";
    }
}
