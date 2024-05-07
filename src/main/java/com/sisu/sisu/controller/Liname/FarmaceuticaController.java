package com.sisu.sisu.controller.Liname;

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

import com.sisu.sisu.Service.FarmaceuticaService;
import com.sisu.sisu.entitys.FormaFarmaceutica;


@Controller
public class FarmaceuticaController {

    @Autowired
    private FarmaceuticaService formaFarmaceuticaService;

    @GetMapping(value = "vistaFarmaceutica")
    public String historialVista(Model model) {

      model.addAttribute("formaFarmaceutica", new FormaFarmaceutica());
      model.addAttribute("farmaceuticas", formaFarmaceuticaService.findAll());

        return "farmace";
    }

    //-------------------------------save---------------------------------

    @PostMapping(value = "/saveformaFarma") // Enviar datos de Registro a Lista
	public String guaradarFFarmaceutica(@Validated FormaFarmaceutica formaFarmaceutica) { 

        formaFarmaceutica.setEstadoFF("A");
        formaFarmaceuticaService.save(formaFarmaceutica);

		return "redirect:/l-Farmaceutica";
	}

    //-------------------------------to list---------------------------------

    @GetMapping(value="/l-Farmaceutica")
    public String listaTipoUso(Model model, @Validated FormaFarmaceutica formaFarmaceutica) {

        model.addAttribute("formaFarmaceutica", new FormaFarmaceutica());
        model.addAttribute("farmaceuticas", formaFarmaceuticaService.findAll());
       
        return "listas/Liname/ListaFormFarma";
    
    }

    //-------------------------------Delete---------------------------------
    @RequestMapping(value = "/eliminFarma/{idFormaFarmaceutica}")
    public String eliminarFFarmaceutica(@PathVariable("idFormaFarmaceutica")Integer idFormaFarmaceutica){

        FormaFarmaceutica formaFarmaceutica = formaFarmaceuticaService.findOne(idFormaFarmaceutica);
        formaFarmaceutica.setEstadoFF("X");
        formaFarmaceuticaService.save(formaFarmaceutica);

        return "redirect:/l-Farmaceutica";
    }


     //-------------------------------Edit--------------------------------------
    @RequestMapping(value = "/editFarmaceutica/{idFormaFarmaceutica}")
    public String editFarmaceutica(@PathVariable("idFormaFarmaceutica")Integer idFormaFarmaceutica, Model model){
 
        FormaFarmaceutica formaFarmaceutica = formaFarmaceuticaService.findOne(idFormaFarmaceutica);
        model.addAttribute("formaFarmaceutica", formaFarmaceutica);
 
        return "redirect:/l-Farmaceutica";
    }

    @RequestMapping(value = "/formaFarmaceutica/{idFormaFarmaceutica}")
    public String getContent1(@PathVariable(value = "idFormaFarmaceutica") Integer idFormaFarmaceutica, Model model,
    HttpServletRequest request) {

        model.addAttribute("formaFarmaceutica", formaFarmaceuticaService.findOne(idFormaFarmaceutica));
        return "listas/Liname/contentLiname :: contentFarmaceutica";
    }


    @PostMapping(value = "/SaveFarmaceutica")
    public String GuardarHistorial(@ModelAttribute FormaFarmaceutica formaFarmaceutica) {
        
        formaFarmaceutica.setEstadoFF("A");
        formaFarmaceuticaService.save(formaFarmaceutica);
      
        return "redirect:/l-Farmaceutica";
    }



    
}
