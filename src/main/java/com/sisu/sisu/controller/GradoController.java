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

import com.sisu.sisu.Service.IGradoService;
import com.sisu.sisu.entitys.GradoAcademico;

@Controller
public class GradoController {

    @Autowired
    private IGradoService gradoService;
    // muestra mi formulario y mi lista

    /* eliminar */

    @RequestMapping(value = "/eliminarGrado/{id_grado}")
    public String eliminarGrado(@PathVariable("id_grado") Integer id_grado) {

        GradoAcademico gradoAcademico = gradoService.findOne(id_grado);
        gradoAcademico.setEstado("X");
        gradoService.save(gradoAcademico);

        return "redirect:/ListaGrado";
    }
    /* Listar */

    @GetMapping(value = "/ListaGrado")
    public String listarGrado(@Validated GradoAcademico gradoAcademico, Model model) {

        model.addAttribute("grado", new GradoAcademico());
        model.addAttribute("grados", gradoService.findAll());

        return "listas/listaGrado";
    }

    /* Cuando apretar sabe en editar, llama esta funcion: Modificación Modal */

    @RequestMapping(value = "/grado/{idGradoAcademico}")
    public String getContentGA(@PathVariable(value = "idGradoAcademico") Integer idGradoAcademico, Model model,
            HttpServletRequest request) {

        model.addAttribute("grado", gradoService.findOne(idGradoAcademico));
        return "contentGA :: contentGrado";
    }

    /* Guardar Cambios */
    @PostMapping(value = "/guardarCambiosGrado")
    public String guardarCambiosGrado(@ModelAttribute GradoAcademico gradoAcademico) {

        gradoAcademico.setEstado("A");
        gradoService.save(gradoAcademico);

        return "redirect:/ListaGrado";
    }

    @RequestMapping(value = "/registrarGradoA")
    public String getRegistrarGradoA(Model model) {
        model.addAttribute("grado", new GradoAcademico());
        model.addAttribute("grados", gradoService.findAll());
        return "contentGA :: contentGrado";
    }
}
