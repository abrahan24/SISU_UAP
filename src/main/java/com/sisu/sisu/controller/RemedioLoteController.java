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

import com.sisu.sisu.Service.IProveedorService;
import com.sisu.sisu.Service.IRemedioLoteService;
import com.sisu.sisu.entitys.Proveedor;
import com.sisu.sisu.entitys.RemedioLote;

@Controller
public class RemedioLoteController {
    @Autowired
    private IRemedioLoteService remedioLoteService;
    
    @Autowired
    private IProveedorService proveedorService;

    /* mostrar */
    @GetMapping(value = "/RegistroRemedioLote")
    public String registroRemedioLote(@Validated RemedioLote remedioLote, Model model) {
        model.addAttribute("remedioLote", new RemedioLote());
        model.addAttribute("remedioLotes", remedioLoteService.findAll());
        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", proveedorService.findAll());
        return "formularios/formRemedioLote";
    }
    /* guardar */
    @PostMapping(value = "/guardarRemedioLote")
    public String guardarRemedioLote(@Validated RemedioLote remedioLote) {
        remedioLote.setEstado("A");
        remedioLoteService.save(remedioLote);
        return "redirect:/ListaRemedioLote";
    }
    /* editar */
    @GetMapping(value = "/editarRemedioLote/{idRemedioLote}")
    public String editarRemedioLote(@PathVariable("idRemedioLote") Integer idRemedioLote, Model model) {
        RemedioLote remedioLote = remedioLoteService.findOne(idRemedioLote);
        model.addAttribute("remedioLote", remedioLote);
        return "formularios/ListaRemedioLote";
    }
    
    /* eliminar */
    @RequestMapping(value = "/eliminarRemedioLote/{idRemedioLote}")
    public String eliminarRemedioLote(@PathVariable("idRemedioLote") Integer idRemedioLote) {
        RemedioLote remedioLote = remedioLoteService.findOne(idRemedioLote);
        remedioLote.setEstado("X");
        remedioLoteService.save(remedioLote);
        return "redirect:/ListaRemedioLote";
    }

    /* listar */
    @GetMapping(value = "/ListaRemedioLote")
    public String listarRemedioLote(Model model) {
        model.addAttribute("remedioLotes", remedioLoteService.findAll());
        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", proveedorService.findAll());
        return "listas/listaRemedioLote";
    }

    /* modificar con el modal */
    @RequestMapping(value = "/remedioLote/{idRemedioLote}")
    public String getContentRe(@PathVariable(value = "idRemedioLote") Integer idRemedioLote, Model model,
            HttpServletRequest request) {
        model.addAttribute("remedioLote", remedioLoteService.findOne(idRemedioLote));
        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", proveedorService.findAll());
        return "contentRE :: contentRemedioLote";
    }

    /* registrar con el modal */
    @RequestMapping(value = "/registrarRemedioLote")
    public String getRegistroRemedioLote(Model model) {
        model.addAttribute("remedioLote", new RemedioLote());
        model.addAttribute("remedioLotes", remedioLoteService.findAll());
        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", proveedorService.findAll());
        return "contentRE :: contentRemedioLote";
    }

    /* guardar con el modal */
    @PostMapping(value = "/guardarCambiosReLote")
    public String guardarCambiosRemedioLote(@ModelAttribute RemedioLote remedioLote) {
        remedioLote.setEstado("A");
        remedioLoteService.save(remedioLote);
        return "redirect:/ListaRemedioLote";
    }
}
