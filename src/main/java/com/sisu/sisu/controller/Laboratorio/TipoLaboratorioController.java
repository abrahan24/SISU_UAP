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

import com.sisu.sisu.Service.TipoLaboratorioService;
import com.sisu.sisu.entitys.TipoLaboratorio;

@Controller
public class TipoLaboratorioController {

    @Autowired
    private TipoLaboratorioService tipoLaboratorioService;
    
    @GetMapping(value = "/listado-tipoLaboratorio")
    public String listar(@Validated TipoLaboratorio tipoLaboratorio, Model model) {

        model.addAttribute("tipoLaboratorio", new TipoLaboratorio());
        model.addAttribute("tipoLaboratorios", tipoLaboratorioService.listarTipoLaboratorios());
        return "listas/listaTipoLaboratorio";
    }

    @RequestMapping(value = "/registrar-tipoLaboratorio")
    public String registrar(Model model) {
        model.addAttribute("tipoLaboratorio", new TipoLaboratorio());
        model.addAttribute("tipoLaboratorios", tipoLaboratorioService.listarTipoLaboratorios());
        return "contentLab :: content_tipoLaboratorio";
    }

    @PostMapping(value = "/modificar-tipoLaboratorio")
    public String modificar(@ModelAttribute TipoLaboratorio tipoLaboratorio) {

        tipoLaboratorio.setEstado("A");
        tipoLaboratorioService.save(tipoLaboratorio);
        return "redirect:/listado-tipoLaboratorio";
    }

    @RequestMapping(value = "/eliminar/{id_tipo_laboratorio}")
    public String eliminar(@PathVariable("id_tipo_laboratorio") Integer id_tipo_laboratorio) {

        TipoLaboratorio tipoLaboratorio = tipoLaboratorioService.findOne(id_tipo_laboratorio);
        tipoLaboratorio.setEstado("X");
        tipoLaboratorioService.save(tipoLaboratorio);
        return "redirect:/listado-tipoLaboratorio";
    }

    @RequestMapping(value = "/laboratorio/{id_tipo_laboratorio}")
    public String getContentGA(@PathVariable(value = "id_tipo_laboratorio") Integer id_tipo_laboratorio, Model model,
            HttpServletRequest request) {

        model.addAttribute("tipoLaboratorio", tipoLaboratorioService.findOne(id_tipo_laboratorio));
        return "contentLab :: content_tipoLaboratorio";
    }
}
