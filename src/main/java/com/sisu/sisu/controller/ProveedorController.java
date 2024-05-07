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
import com.sisu.sisu.Service.ITipoProveedorService;
import com.sisu.sisu.entitys.Proveedor;
import com.sisu.sisu.entitys.TipoProveedor;

@Controller
public class ProveedorController {
    
    @Autowired
    private IProveedorService proveedorService;
    
    @Autowired
    private ITipoProveedorService tipoProveedorService;

    @GetMapping(value = "/RegistroProveedor")
    public String registroProveedor(@Validated Proveedor proveedor, Model model) {
        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", proveedorService.findAll());

        model.addAttribute("tipoProveedor", new TipoProveedor());
        model.addAttribute("tipoProveedores", tipoProveedorService.findAll());
        return "formularios/formProveedor";
    }

    @PostMapping(value = "/guardarProveedor")
    public String guardarProveedor(@Validated Proveedor proveedor) {
        proveedor.setEstado("A");
        proveedorService.save(proveedor);
        return "redirect:/ListaProveedor";
    }

    @RequestMapping(value = "/eliminarProveedor/{idProveedor}")
    public String eliminarProveedor(@PathVariable("idProveedor") Integer idProveedor) {
        Proveedor proveedor = proveedorService.findOne(idProveedor);
        proveedor.setEstado("X");
        proveedorService.save(proveedor);
        return "redirect:/ListaProveedor";
    }

    @RequestMapping(value = "/editarProveedor/{idProveedor}")
    public String editarProveedor(@PathVariable("idProveedor") Integer idProveedor, Model model) {
        Proveedor proveedor = proveedorService.findOne(idProveedor);
        model.addAttribute("proveedor", proveedor);
        return "formularios/ListaProveedor";
    }

    @GetMapping(value = "/ListaProveedor")
    public String listarProveedor(Model model) {
        model.addAttribute("proveedores", proveedorService.findAll());
        model.addAttribute("tipoProveedor", new TipoProveedor());
        model.addAttribute("tipoProveedores", tipoProveedorService.findAll());
        return "listas/listaProveedor";
    }

    /* modificar con el mdal */
    @RequestMapping(value = "/proveedor/{idProveedor}")
    public String getContentPr(@PathVariable(value = "idProveedor") Integer idProveedor, Model model,
            HttpServletRequest request) {
        model.addAttribute("proveedor", proveedorService.findOne(idProveedor));
        
        model.addAttribute("tipoProveedor", new TipoProveedor());
        model.addAttribute("tipoProveedores", tipoProveedorService.findAll());
        return "contentRE :: contentProveedor";
    }

    @PostMapping(value = "/guardarCambiosPr")
    public String guardarCambiosPersona(@ModelAttribute Proveedor proveedor) {
        proveedor.setEstado("A");
        proveedorService.save(proveedor);   
        return "redirect:/ListaProveedor";
    }

    /* registrar con el modal */
    @RequestMapping(value = "/registrarProveedor")
    public String getRegistroProveedor(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        model.addAttribute("proveedores", proveedorService.findAll());

        model.addAttribute("tipoProveedor", new TipoProveedor());
        model.addAttribute("tipoProveedores", tipoProveedorService.findAll());
        return "contentRE :: contentProveedor";
    }
}
