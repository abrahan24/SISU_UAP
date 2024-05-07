package com.sisu.sisu.controller;

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

import com.sisu.sisu.Service.IRemediosFarmaciaService;
import com.sisu.sisu.Service.ListaLinameService;
import com.sisu.sisu.entitys.ListaLiname;
import com.sisu.sisu.entitys.RemediosFarmacia;

@Controller
public class RemediosFarmaciaController {
    @Autowired
    private IRemediosFarmaciaService remediosFarmaciaService;

    @Autowired
    private ListaLinameService listaLinameService;

    @GetMapping(value = "/RegistroRemediosFarmacia")
    public String registroRemediosFarmacia(@Validated RemediosFarmacia remediosFarmacia, Model model) {
        model.addAttribute("remediosFarmacia",  new RemediosFarmacia());
        model.addAttribute("remediosFarmacias", remediosFarmaciaService.findAll());

        model.addAttribute("liname", new ListaLiname());
        model.addAttribute("listaLiname", listaLinameService.findAll());

        return "RemediosFarmacia";
    }

    /* Eliminar un registro */
    @RequestMapping(value = "/eliminarRemediosFar/{idRemedios}")
    public String eliminarRemediosFar(@PathVariable("idRemedios") Integer idRemedios) {
        RemediosFarmacia remediosFarmacia = remediosFarmaciaService.findOne(idRemedios);
        remediosFarmacia.setEstado("X");
        remediosFarmaciaService.save(remediosFarmacia);
        return "redirect:/ListaRemediosFar";
    }

    /* Lista */
    @RequestMapping(value = "/ListaRemediosFar")
    public String listarRemediosFarmacia(Model model) {
        model.addAttribute("remediosFarmacias", remediosFarmaciaService.findAll());
        model.addAttribute("liname", new ListaLiname());
        model.addAttribute("listaLiname", listaLinameService.findAll());
        return "listas/listaRemediosFarmacia";
    }

    /* modificar con el modal */

    @RequestMapping(value = "/remediosFarmacia/{idRemedioFarmacia}")
    public String getContentRemediosF(@PathVariable(value = "idRemedioFarmacia") Integer idRemedioFarmacia, Model model,
        HttpServletRequest request){
            model.addAttribute("remediosFarmacia", remediosFarmaciaService.findOne(idRemedioFarmacia));
            
            model.addAttribute("listaLiname", listaLinameService.findAll());
            return "contentFarmacia :: contentRemediosFarmacia";
        }

    /* Registrar con el modal */

    @RequestMapping(value = "/registrarRemediosFarmacia")
    public String getRegistroRemediosFarmacia(Model model) {
        model.addAttribute("remediosFarmacia", new RemediosFarmacia());
        model.addAttribute("remediosFarmacias", remediosFarmaciaService.findAll());

        model.addAttribute("liname", new ListaLiname());
        model.addAttribute("listaLiname", listaLinameService.findAll());
        return "contentFarmacia :: contentRemediosFarmacia";
    }

    /* guardar tdo con el modal */

    @PostMapping(value = "/guardarCambiosRemediosFarmacia")
    public String guardarCambiosRemediosFarmacia(@ModelAttribute RemediosFarmacia remediosFarmacia) {
        remediosFarmacia.setEstado("A");
        remediosFarmaciaService.save(remediosFarmacia);
        return "redirect:/ListaRemediosFar";
    }
}
