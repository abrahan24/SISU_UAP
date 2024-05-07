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

import com.sisu.sisu.Service.ITipoProveedorService;
import com.sisu.sisu.entitys.TipoProveedor;

@Controller
public class TipoProveedorController {
    @Autowired
    private ITipoProveedorService tipoProveedorService;

    @GetMapping(value = "/RegistroTipoProv")
    public String registroTipoProveedor(@Validated TipoProveedor tipoProveedor, Model model) {
        model.addAttribute("tipoProveedor", new TipoProveedor());
        model.addAttribute("tipoProveedores", tipoProveedorService.findAll());
        
        return "formularios/formTipoProveedor";
    }

    @PostMapping(value = "/GuardarTipoProveedor")
    public String GuardarTipoProveedor(@Validated TipoProveedor tipoProveedor) {
        tipoProveedor.setEstado("A");
        tipoProveedorService.save(tipoProveedor);
        return "redirect:/ListaTipoProveedor";
    }

    @RequestMapping(value = "/EliminarTipoProve/{idTipoProveedor}")
    public String eliminarTipoProveedor(@PathVariable("idTipoProveedor") Integer idTipoProveedor) {
        TipoProveedor tipoProveedor = tipoProveedorService.findOne(idTipoProveedor);
        tipoProveedor.setEstado("X");
        tipoProveedorService.save(tipoProveedor);
        return "redirect:/ListaTipoProveedor";
    }

    @RequestMapping(value = "/EditarTipoProve/{idTipoProveedor}")
    public String editarTipoProveedor(@PathVariable("idTipoProveedor") Integer idTipoProveedor, Model model) {
        TipoProveedor tipoProveedor = tipoProveedorService.findOne(idTipoProveedor);
        model.addAttribute("tipoProveedor", tipoProveedor);
        return "formularios/ListaTipoProveedor";
    }

    @GetMapping(value = "/ListaTipoProveedor")
    public String listarTipoProveedor(Model model) {
        model.addAttribute("tipoProveedores", tipoProveedorService.findAll());

        return "listas/listaTipoProveedor";
    }

    @RequestMapping(value = "/tipoproveedor/{idTipoProveedor}")
    public String getContentTp(@PathVariable(value = "idTipoProveedor") Integer idTipoProveedor, Model model,
            HttpServletRequest request) {

        model.addAttribute("tipoProveedor", tipoProveedorService.findOne(idTipoProveedor));
        
        return "contentRE :: contentTp";
    }

    @PostMapping(value = "/guardarCambiosTp")
    public String guardarCambiosPersona(@ModelAttribute TipoProveedor tipoProveedor) {
        tipoProveedor.setEstado("A");
        tipoProveedorService.save(tipoProveedor);
        return "redirect:/ListaTipoProveedor";
    }
    
    @RequestMapping(value = "/registrarNuevoTipoProveedor")
    public String getRegistroTipoProveedor(Model model) {
        model.addAttribute("tipoProveedor", new TipoProveedor());
        model.addAttribute("tipoProveedores", tipoProveedorService.findAll());
        
        // Puedes agregar cualquier inicialización necesaria para un registro nuevo.
        return "contentRE :: contentTp";
    }
}
