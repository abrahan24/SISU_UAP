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

import com.sisu.sisu.Service.TipoUsoService;
import com.sisu.sisu.entitys.TipoUso;

@Controller
public class TipoUsoController {

    @Autowired
    private TipoUsoService tipoUsoService;


    @GetMapping(value = "/vistaTipoUso")
    public String vistaTipoUso(Model model) {

        model.addAttribute("tipoUso", new TipoUso());
        model.addAttribute("tipoUsos", tipoUsoService.findAll()); 

       return "tipoUso";
    }

    //-------------------------------save---------------------------------

    @PostMapping(value = "/saveTipouso") // Enviar datos de Registro a Lista
	public String guaradarLinam(@Validated TipoUso tipoUso) { 

        tipoUso.setEstado("A");
        tipoUsoService.save(tipoUso);

		return "redirect:/l-TipoUso";
	}



    //-------------------------------to list---------------------------------

       @GetMapping(value="/l-TipoUso")
    public String listaTipoUso(Model model, @Validated TipoUso tipoUso) {

        model.addAttribute("tipoUso", new TipoUso());
        model.addAttribute("tipoUsos", tipoUsoService.findAll()); 
       
        return "listas/Liname/ListatipoUso";
    
    }


    //-------------------------------Delete---------------------------------
    @RequestMapping(value = "/eliminTipoUso/{idTipoUso}")
    public String eliminarLiname(@PathVariable("idTipoUso")Integer idTipoUso){

        TipoUso tipoUso = tipoUsoService.findOne(idTipoUso);
        tipoUso.setEstado("X");
        tipoUsoService.save(tipoUso);

        return "redirect:/l-TipoUso";
    }

     //-------------------------------Edit---------------------------------
     @RequestMapping(value = "/edittipoUso/{idTipoUso}")
     public String editTipoUso(@PathVariable("idTipoUso")Integer idTipoUso, Model model){
 
 
         TipoUso tipoUso = tipoUsoService.findOne(idTipoUso);
         model.addAttribute("tipoUso", tipoUso);
 
         return "redirect:/l-TipoUso";
     }


    @RequestMapping(value = "/tipoUso/{idTipoUso}")
    public String getContent1(@PathVariable(value = "idTipoUso") Integer idTipoUso, Model model,
    HttpServletRequest request) {

        model.addAttribute("tipoUso", tipoUsoService.findOne(idTipoUso));

        return "listas/Liname/contentLiname :: contentTipoUso";
    }


    @PostMapping(value = "/SaveTipoUso")
    public String GuardarHistorial(@ModelAttribute TipoUso tipoUso) {

        tipoUso.setEstado("A");
        tipoUsoService.save(tipoUso);

        return "redirect:/l-TipoUso";
    }

}
