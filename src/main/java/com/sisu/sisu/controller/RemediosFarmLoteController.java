package com.sisu.sisu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sisu.sisu.Service.IRemedioLoteService;
import com.sisu.sisu.Service.IRemediosFarmaciaLoteService;
import com.sisu.sisu.Service.IRemediosFarmaciaService;
import com.sisu.sisu.entitys.RemedioLote;
import com.sisu.sisu.entitys.RemediosFarmacia;
import com.sisu.sisu.entitys.RemediosFarmaciaLote;

@Controller
public class RemediosFarmLoteController {
    @Autowired
    private IRemediosFarmaciaLoteService remediosFarmaciaLoteService;

    @Autowired
    private IRemediosFarmaciaService remediosFarmaciaService;

    @Autowired
    private IRemedioLoteService remedioLoteService;

    /* Lista */
    @RequestMapping(value = "/ListaRemedioFarLot")
    public String ListaRemediosFarLot(Model model) {
        model.addAttribute("remediosFarmaciaLotes", remediosFarmaciaLoteService.findAll());
        model.addAttribute("remediosFarmacia", new RemediosFarmacia());
        model.addAttribute("remediosFarmacias", remediosFarmaciaService.findAll());
        model.addAttribute("remedioLote", new RemedioLote());
        model.addAttribute("remedioLotes", remedioLoteService.findAll());

        return "listas/listaRemediosFarmaciaLote";
    }

    /* eliminar */
    @RequestMapping(value = "/eliminarRemediosFarLote/{idRemediosFarmacialote}")
    public String eliminarRemFarLote(@PathVariable("idRemediosFarmacialote") Integer idRemediosFarmacialote) {
        RemediosFarmaciaLote remediosFarmaciaLote = remediosFarmaciaLoteService.findOne(idRemediosFarmacialote);
        remediosFarmaciaLote.setEstado("X");
        remediosFarmaciaLoteService.save(remediosFarmaciaLote);
        return "redirect:/ListaRemedioFarLot";
    }

    /* Registrar con el modal */
    @RequestMapping(value = "/registrarRemFarLote")
    public String getRegistrarRemFarLote(Model model){
        model.addAttribute("remediosFarmaciaLote", new RemediosFarmaciaLote());
        model.addAttribute("remediosFarmaciaLotes", remediosFarmaciaLoteService.findAll());
        model.addAttribute("remediosFarmacia", new RemediosFarmacia());
        model.addAttribute("remediosFarmacias", remediosFarmaciaService.findAll());
        model.addAttribute("remedioLote", new RemedioLote());
        model.addAttribute("remedioLotes", remedioLoteService.findAll());

        return "contentFarmacia :: contentRemFarLote";
    }

    /* modificar con el modal */

    @RequestMapping(value = "/remediosFarmaciaLote/{idRemediosFarmaciaLote}")
    public String getContentRemediosFarLote(@PathVariable(value = "idRemediosFarmaciaLote") Long idRemedioFarmaciaLote, Model model, 
    HttpServletRequest request){
        model.addAttribute("remediosFarmaciaLote", new RemediosFarmaciaLote());
        model.addAttribute("remediosFarmacia", new RemediosFarmacia());
        model.addAttribute("remediosFarmacias", remediosFarmaciaService.findAll());
        model.addAttribute("remedioLote", new RemedioLote());
        model.addAttribute("remedioLotes", remedioLoteService.findAll());

        return "contentFarmacia :: contentRemFarLote";
    }

    /* guardar cambios */
    @PostMapping(value = "/guardarCambiosRemFarLote")
    public String guardarCambiosRemFarLot(@ModelAttribute RemediosFarmaciaLote remediosFarmaciaLote){
        remediosFarmaciaLote.setEstado("A");
        remediosFarmaciaLoteService.save(remediosFarmaciaLote);
        return "redirect:/ListaRemedioFarLot";
    }
}   
