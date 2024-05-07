package com.sisu.sisu.controller.Ficha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sisu.sisu.Service.FichaService;
import com.sisu.sisu.Service.HistorialSeguroService;
import com.sisu.sisu.Service.IAseguradoService;
import com.sisu.sisu.Service.IPersonaService;
import com.sisu.sisu.entitys.Asegurado;
import com.sisu.sisu.entitys.Ficha;
import com.sisu.sisu.entitys.Persona;

@Controller
public class FichaController {

    @Autowired
    private FichaService fichaService;

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IAseguradoService aseguradoService;

    @RequestMapping(value = "/vistaF", method = RequestMethod.GET)
	public String vistaFicha(Model model ) { 
        
        model.addAttribute("ficha", new Ficha());
        model.addAttribute("fichas", fichaService.findAll());

        model.addAttribute("asegurado", new Asegurado());
        model.addAttribute("asegurados", aseguradoService.findAll());

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", personaService.findAll());

		return "Fichas/listaFichaP";
	}

     //-------------------------------to list---------------------------------

     @GetMapping (value = "fichasAsegurado")
    public String generarFicha(Model model, @Validated Ficha ficha) {

        model.addAttribute("ficha", new Ficha());
        model.addAttribute("fichas", fichaService.findAll());

        
        System.out.println("+++++++++++++++++++23222");

        return "Fichas/listaFichaP";
    }
}
