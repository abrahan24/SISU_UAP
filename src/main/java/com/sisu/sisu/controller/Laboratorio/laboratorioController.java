package com.sisu.sisu.controller.Laboratorio;

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

import com.sisu.sisu.Service.LaboratorioService;
import com.sisu.sisu.entitys.Laboratorio;

@Controller
public class laboratorioController {

    @Autowired
    private LaboratorioService laboratorioService;

    @GetMapping(value = "/listado-laboratorio")
    public String listarGrado(@Validated Laboratorio laboratorio, Model model) {

        model.addAttribute("laboratorio", new Laboratorio());
        model.addAttribute("laboratorios", laboratorioService.listarTodo());
        return "listas/listaLaboratorio";
    }

    @RequestMapping(value = "/registrar-laboratorio")
    public String registrar(Model model) {
        model.addAttribute("laboratorio", new Laboratorio());
        model.addAttribute("laboratorios", laboratorioService.listarTodo());
        return "contentLab :: content_laboratorio";
    }

    @PostMapping(value = "/modificar-laboratorio")
    public String modificar(@ModelAttribute Laboratorio laboratorio) {

        laboratorio.setEstado("A");
        laboratorioService.save(laboratorio);
        return "redirect:/listado-laboratorio";
    }

    @RequestMapping(value = "/eliminar/{id_laboratorio}")
    public String eliminarGrado(@PathVariable("id_laboratorio") Integer id_laboratorio) {

        Laboratorio laboratorio = laboratorioService.findOne(id_laboratorio);
        laboratorio.setEstado("X");
        laboratorioService.save(laboratorio);
        return "redirect:/listado-laboratorio";
    }

    @RequestMapping(value = "/laboratorio/{id_laboratorio}")
    public String getContentGA(@PathVariable(value = "id_laboratorio") Integer id_laboratorio, Model model,
            HttpServletRequest request) {

        model.addAttribute("laboratorio", laboratorioService.findOne(id_laboratorio));
        return "contentLab :: content_laboratorio";
    }
}
