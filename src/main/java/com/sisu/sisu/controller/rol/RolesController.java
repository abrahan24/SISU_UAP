package com.sisu.sisu.controller.rol;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.sisu.sisu.Service.IRolesService;
import com.sisu.sisu.entitys.Roles;
import com.sisu.sisu.entitys.Usuario;

@Controller
public class RolesController {
    
    @Autowired
    private IRolesService rolesService;

    @GetMapping(value = "/formRegristroRoles")
    public String registroRoles(@Validated Roles roles, Model model) {
        model.addAttribute("role", new Roles());
        model.addAttribute("roles", rolesService.findAll());

        return "formularios/formRoles";
    }

    @PostMapping(value = "/guardarRoles")
    public ResponseEntity<String> RegistroRol(@Validated Roles roles, RedirectAttributes flash,
            HttpServletRequest request,
            Model model) {
                
        if (roles.getIdRol() == null) {
            if (rolesService.validarRoles(roles.getRol(), roles.getDescripcion()) != null) {

                return ResponseEntity.ok("2");
            } else {
                roles.setRegistro(new Date());
                roles.setEstado("A");
                rolesService.save(roles);
                return ResponseEntity.ok("1");
            }
        } else {
            Roles r = rolesService.findOne(roles.getIdRol());
            r.setModificacion(new Date());
            r.setRol(roles.getRol());
            r.setObservacion(roles.getObservacion());
            r.setDescripcion(roles.getDescripcion());
            r.setSimbolo(roles.getSimbolo());
            rolesService.save(r);
            return ResponseEntity.ok("3");
        }

    }

    @RequestMapping(value = "/eliminarRoles/{idRol}",method = RequestMethod.POST)
    @ResponseBody
    public void eliminarRol(@PathVariable("idRol") Integer idRol) {
        Roles roles = rolesService.findOne(idRol);
        roles.setEstado("X");
        rolesService.save(roles);
    }

    @GetMapping(value = "/ListaDeRoles")
    public String listarRol(Model model, HttpServletRequest request) {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSession");
		
		if (usuario == null) {
			
			return "redirect:/";
			
		}
        model.addAttribute("roles", rolesService.findAll());
        
        return "listas/listaRoles";
    }

    /* modificar con el modal */
    @RequestMapping(value = "/roles/{idRol}")
    public String getContentRoless(@PathVariable(value = "idRol") Integer idRol, Model model,
            HttpServletRequest request) {

        model.addAttribute("role", rolesService.findOne(idRol));

        return "content :: contentRol";
    }

    /* registrar con el modal */
    @RequestMapping(value = "/registrarRoles")
    public String getRegistroRoles(Model model) {
        model.addAttribute("role", new Roles());
        return "content :: contentRol";
    }
}
