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

import com.sisu.sisu.Service.IDipService;
import com.sisu.sisu.entitys.Dip;

@Controller
public class DipController {

    @Autowired
    private IDipService iDipService;

    // ----------- Formulario para registrar --------

    @GetMapping(value = "/formRegistroDip")
    public String registroDip(@Validated Dip dip, Model model) {

        model.addAttribute("dip", new Dip());
        model.addAttribute("dips", iDipService.findAll());

        return "formularios/formModeloReceta";
    }

    /* ------------- GUARDAR ------------ */

    @PostMapping(value = "/guardarDip")
    public String RegistrarDip(@Validated Dip dip) {
        dip.setEstado("A");
        iDipService.save(dip);
        return "redirect:/ListasDip";
    }

    // --------------------------------------------

    /*--------------- eliminar -----------*/

    @RequestMapping(value = "/eliminarDip/{id_dip}")
    public String eliminarDip(@PathVariable("id_dip") Integer id_dip) {

        Dip dip = iDipService.findOne(id_dip);
        dip.setEstado("X");
        iDipService.save(dip);
        return "redirect:/ListasDip";

    }

    // --------------------------------------------

    /* ------------ Lista ----------------- */

    @GetMapping(value = "/ListasDip")
    public String listarDip(Model model) {

        model.addAttribute("dip", new Dip());
        model.addAttribute("dips", iDipService.findAll());

        model.addAttribute("opcion1", "X");

        model.addAttribute("nameButton1", "Lista de Inactivos ");

        model.addAttribute("url", "/ListasEliminadosDip");

        return "listas/listaDip";
    }

    @GetMapping(value = "/ListasEliminadosDip")
    public String listarEliminadoDip(Model model) {

        model.addAttribute("dip", new Dip());
        model.addAttribute("dips", iDipService.findAll());

        model.addAttribute("opcion1", "A");

        model.addAttribute("nameButton1", "Lista de Activos");

        model.addAttribute("url", "/ListasDip");

        return "formularios/formModeloReceta";
    }

    // --------------------------------------------

    /* Modificación Modal */
    @RequestMapping(value = "/dip/{idDip}")
    public String getContentDip(@PathVariable(value = "idDip") Integer idDip, Model model,
            HttpServletRequest request) {

        model.addAttribute("dip", iDipService.findOne(idDip));

        return "contentDip :: contentdip";

    }

    /* Registrar DIP model */
    @RequestMapping(value = "/registrarDip")
    public String getRegistroDIP(Model model) {

        model.addAttribute("dip", new Dip());
        model.addAttribute("dips", iDipService.findAll());

        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentDip :: contentdip";
    }

    // --------------------------------------------

    /* -------------------Editar ------------------- */

    // @RequestMapping(value = "/editarDip/{id_dip}")
    // public String editarDip(@PathVariable("id_dip") Long id_dip, Model model) {
    // Dip dip = iDipService.findOne(id_dip);
    // model.addAttribute("dip", dip);
    // return "formularios/listaDip";
    // }

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosDip")
    public String guardarCambiosDip(@ModelAttribute Dip dip) {
        dip.setEstado("A");
        iDipService.save(dip);
        return "redirect:/ListasDip";
    }

    // -------------------------------------------------
}
