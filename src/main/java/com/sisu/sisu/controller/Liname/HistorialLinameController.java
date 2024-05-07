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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sisu.sisu.Service.HistoriaLinameService;
import com.sisu.sisu.Service.ListaLinameService;
import com.sisu.sisu.entitys.HistorialLiname;
import com.sisu.sisu.entitys.ListaLiname;

@Controller
public class HistorialLinameController {

    @Autowired
    private HistoriaLinameService historialService;

    @Autowired
    private ListaLinameService listaLinameService;;
    

    @GetMapping(value = "vistaHistorial")
    public String historialVista(Model model) {

        model.addAttribute("historialLiname", new HistorialLiname());
        model.addAttribute("historiales", historialService.findAll());

        model.addAttribute("listaLiname", new ListaLiname());
        model.addAttribute("listaLinames", listaLinameService.findAll());


        return "historial";
    }

    //-------------------------------to list---------------------------------

    @PostMapping(value = "saveHistorial")
    public String saveHistorial(@Validated HistorialLiname historialLiname, 
     RedirectAttributes flash, HttpServletRequest request,
    @RequestParam(name = "listaLiname", required = false) Integer idLiname
    ){

        historialLiname.setEstadoHistorialLiname("A");
        historialLiname.setLista_liname(listaLinameService.findOne(idLiname));
        historialService.save(historialLiname);

        return "redirect:/l-Historial";
    }


    //-------------------------------to list---------------------------------

       @GetMapping(value="/l-Historial")
    public String listaLiname(Model model, @Validated HistorialLiname historialLiname) {

        model.addAttribute("historial", new HistorialLiname());
        model.addAttribute("historiales", historialService.findAll());
        model.addAttribute("listaLinames", listaLinameService.findAll());
       
        return "listas/Liname/ListaHistorial";
    
    }
    

    //-------------------------------Delete---------------------------------
    @RequestMapping(value = "/eliminHistorial/{idHistorialLiname}")
    public String eliminarLiname(@PathVariable("idHistorialLiname")Integer idHistorialLiname){

        HistorialLiname historialLiname = historialService.findOne(idHistorialLiname);
        historialLiname.setEstadoHistorialLiname("X");
        historialService.save(historialLiname);

        return "redirect:/l-Historial";
    }


    //-------------------------------Edit---------------------------------
    @RequestMapping(value = "/editHistorial/{idHistorialLiname}")
    public String editLiname(@PathVariable("idHistorialLiname")Integer idHistorialLiname, Model model){


        HistorialLiname historialLiname = historialService.findOne(idHistorialLiname);
        model.addAttribute("historialLiname", historialLiname);

        return "redirect:/l-Historial";
    }


    @RequestMapping(value = "/historialLiname/{idHistorialLiname}")
    public String getContent1(@PathVariable(value = "idHistorialLiname") Integer idHistorialLiname, Model model,
    HttpServletRequest request) {

        model.addAttribute("historialLiname", historialService.findOne(idHistorialLiname));
        model.addAttribute("listaLinames", listaLinameService.findAll());

        return "listas/Liname/contentLiname :: contentHistorial";
    }


    @PostMapping(value = "/SaveHistorial")
    public String GuardarHistorial(@ModelAttribute HistorialLiname historialLiname,
    @RequestParam(name="listaLiname",required = false)Integer idLiname
    ) {

        historialLiname.setEstadoHistorialLiname("A");
        historialLiname.setLista_liname(listaLinameService.findOne(idLiname));
        historialService.save(historialLiname);
       
        return "redirect:/l-Historial";
    }

}
