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

import com.sisu.sisu.Service.ITipoRecetaService;
import com.sisu.sisu.entitys.TipoReceta;

@Controller
public class TipoRecetaController {

    @Autowired
    private ITipoRecetaService tipoRecetaService;

    /* eliminar */

    @RequestMapping(value = "/eliminarReceta/{idTipoRe}")
    public String eliminarReceta(@PathVariable("idTipoRe") Integer idTipoRe) {
        TipoReceta tipoReceta = tipoRecetaService.findOne(idTipoRe);
        tipoReceta.setEstado("X");
        tipoRecetaService.save(tipoReceta);

        return "redirect:/ListaTipoReceta";
    }

    /* Listar */

    @GetMapping(value = "/ListaTipoReceta")
    public String listarReceta(@Validated TipoReceta tipoReceta, Model model) {

        model.addAttribute("tipoReceta", new TipoReceta());
        model.addAttribute("tipoRecetas", tipoRecetaService.findAll());

        return "listas/listaTipoReceta";
    }

    /* Cuando apretar sabe en editar, llama esta funcion: Modificación Modal */

    @RequestMapping(value = "/tipoReceta/{idTipoRe}")
    public String getContentREt(@PathVariable(value = "idTipoRe") Integer idTipoRe, Model model,
            HttpServletRequest request) {
        // TipoReceta tipoReceta = tipoRecetaService.findOne(idTipoRe);
        model.addAttribute("tipoReceta", tipoRecetaService.findOne(idTipoRe));
        return "contentRE :: contentTipoReceta";
    }

    /* registrar con el modal */
    @RequestMapping(value = "/registrarTipoReceta")
    public String getRegistroTipoR(Model model) {
        model.addAttribute("tipoReceta", new TipoReceta());
        model.addAttribute("tipoRecetas", tipoRecetaService.findAll());
        return "contentRE :: contentTipoReceta";
    }

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosReceta")
    public String guardarCambiosReceta(@ModelAttribute TipoReceta tipoReceta) {

        tipoReceta.setEstado("A");
        tipoRecetaService.save(tipoReceta);

        return "redirect:/ListaTipoReceta";
    }

}
