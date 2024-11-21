package com.sisu.sisu.controller.orden;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sisu.sisu.Dao.PersonalMedicoFichaDao;
import com.sisu.sisu.Service.FichaService;
import com.sisu.sisu.Service.IAseguradoService;
import com.sisu.sisu.entitys.Asegurado;
import com.sisu.sisu.entitys.PersonalMedicoFicha;

@Controller
public class OrdenQuirurgico {
    

    @Autowired
    private IAseguradoService aseguradoService;


    @Autowired
    private PersonalMedicoFichaDao personalMedicoFichaDao;

    @GetMapping(value = "/verModeloOrdenQuirurgico/{idAsegurado}/{idFicha}")
    public String verModeloOrdenQuirurgico(Model model,@PathVariable(name = "idAsegurado")Integer idAsegurado, @PathVariable(name = "idFicha")Integer idFicha) {
      
            LocalDate fechaActual = LocalDate.now();
            Asegurado asegurado = aseguradoService.findOne(idAsegurado);
            PersonalMedicoFicha personalMedicoFicha = personalMedicoFichaDao.personalMedicoFicha(idFicha);
            int edad = Period.between(asegurado.getPersona().getFecha_nac(), fechaActual).getYears();
            model.addAttribute("asegurado", asegurado);
            model.addAttribute("fechaH", fechaActual);
            model.addAttribute("edad", edad);
            model.addAttribute("personalMedicoFicha", personalMedicoFicha);

        return "ordenQuirurgico/orden_quirurgico";
    }


}
