package com.sisu.sisu.controller.enlace;


import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sisu.sisu.Service.IEnlaceService;
import com.sisu.sisu.Service.IRolesService;
import com.sisu.sisu.Service.UsuarioService;
import com.sisu.sisu.entitys.Enlace;
import com.sisu.sisu.entitys.Roles;
import com.sisu.sisu.entitys.Usuario;


@Controller
public class EnlaceController {

    @Autowired
    private IEnlaceService enlaceService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private IRolesService rolesService;
    @RequestMapping(value = "formEnlace")
    public String registroEnlace(@Validated Enlace enlace, Model model) {

        model.addAttribute("enlace", new Enlace());
        model.addAttribute("enlaces", enlaceService.findAll());

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        System.out.print("ESTA SALIENDO DESDE ESTE CONTROLADOR");

        return "formularios/formEnlace";
    }

    /* GUARDAR */
    @PostMapping(value = "/guardarEnlace")
    public String RegistrarEnlace(@Validated Enlace enlace, RedirectAttributes flash, HttpServletRequest request, Model model) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(1);
        // Usuario usuario = usuarioService.buscarUsuarioPorId(1l);
        System.out.println("El nombre del enlace es: " + enlace.getNombre_enlace());
        if (enlace.getNombre_enlace() == "") {
            System.out.println("Está mandando un valor vacío");
            String mensaje = "No se puede registrar enlaces vacíos";
            flash.addFlashAttribute("mensaje", mensaje);
            return "redirect:formEnlace";
        } else {
            enlace.setId_usuario(usuario);
            System.out.println("++++++teste1++++++");
            enlace.setEstado("A");
            System.out.println(enlace.getNombre_enlace());
            enlace.setTabla(1);
            enlace.setObs("0");
            enlaceService.save(enlace);
            System.out.println("seGuardó1");
            return "redirect:formEnlace";
        }
    }
    @GetMapping(value = "formEnlaceHijo")
    public String registroEnlaceHijo(@Validated Enlace enlace, Model model, HttpServletRequest request) {
        
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSession");
		
		if (usuario == null) {
			
			return "index/login";
			
		}
        
        model.addAttribute("enlace", new Enlace());
        model.addAttribute("enlaces", enlaceService.findAll());

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        model.addAttribute("listaEnlace", enlaceService.listaEnlacePadre());
        System.out.println(enlaceService.listaEnlacePadre().size());
        System.out.println("++++++++K+++++++++");

        return "formularios/formEnlaceHijo";
    }
    /* GUARDAR */

    @PostMapping(value = "/guardarEnlaceHijo2")
    public String registroEnlaceHijo(@Validated Enlace enlace,
            @RequestParam(name = "idEnlace2", required = false) Integer idEnlace, RedirectAttributes flash,
            HttpServletRequest request, Model model) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(1);
        System.out.println("El nombre del enlace es: " + enlace.getNombre_enlace());
        if (enlace.getNombre_enlace().isEmpty() || enlace.getRuta().isEmpty()) {
            System.out.println("Está mandando un valor vacío");
            String mensaje2 = "No se puede registrar enlaces vacíos";
            flash.addFlashAttribute("mensaje2", mensaje2);
            return "redirect:formEnlaceHijo";

        } else {
            enlace.setId_usuario(usuario);
            System.out.println("+++++++teste2+++++++");
            enlace.setEstado("A");
            System.out.println(enlace.getNombre_enlace());
            // enlace.setRuta(null);
            if (idEnlace != null) {
                enlace.setTabla(idEnlace);
            }
            // System.out.println(idEnlace);
            enlace.setObs("1");
            // System.out.println(enlace.getIdEnlace());
            // System.out.println("Guardado uwuuwuwuwuw" + idEnlace);
            enlaceService.save(enlace);
            System.out.println("+++++++++seGuardó2+++++++");
            return "redirect:formEnlaceHijo";
        }

    }

    @PostMapping(value = "/guardar_enlace")
    public ResponseEntity<String> guardar_enlace(@Validated Enlace enlace) {

        enlace.setEstado("A");
        enlace.setObs("0");
        enlace.setTabla(1);
        enlace.setId_usuario(usuarioService.findOne(1));

        enlaceService.save(enlace);
        return ResponseEntity.ok("1");
    }

    @PostMapping(value = "/guardar_enlace_hijo")
    public ResponseEntity<String> guardar_enlace_hijo(@Validated Enlace enlace,@RequestParam(name = "id_Enlace")Integer idEnlace) {

        enlace.setEstado("A");
        enlace.setObs("1");
        enlace.setTabla(idEnlace);
        enlace.setId_usuario(usuarioService.findOne(1));
        enlaceService.save(enlace);
        return ResponseEntity.ok("1");
    }
    
    @PostMapping(value = "/asignar_enlace_padre")
    public ResponseEntity<String> asignar_enlace_padre(@Validated Roles roles) {

        roles.setEstado("A");
        rolesService.save(roles);
        return ResponseEntity.ok("1");
    }

    @PostMapping(value = "/asignar_enlace_hijo")
    public ResponseEntity<String> asignar_enlace_hijo(@Validated Roles roles) {

        roles.setEstado("A");
        rolesService.save(roles);
        return ResponseEntity.ok("1");
    }

    /* LISTAR */
    @GetMapping(value = "/ListaEnlace")
    public String listarEnlace(Model model, HttpServletRequest request) {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSession");
		if (usuario == null) {
			return "redirect:/";
		}
        model.addAttribute("enlace", new Enlace());
        model.addAttribute("roles", rolesService.findAll());
        return "listas/listaEnlace";
    }

    @GetMapping(value = "/enlaces/{idRol}")
    public String mostrar_enlaces(@PathVariable(name = "idRol")Integer idRol, Model model) {

        Roles roles = rolesService.findOne(idRol);
        model.addAttribute("rol", roles);
        model.addAttribute("enlaces", enlaceService.findAll());
        return "content/content_enlace :: modal_enlace";
    }
    @GetMapping(value = "/enlaces_hijos/{idRol}")
    public String mostrar_enlaces_hijos(@PathVariable(name = "idRol")Integer idRol, Model model) {

        Roles roles = rolesService.findOne(idRol);
        model.addAttribute("rol", roles);
        model.addAttribute("enlaces", enlaceService.findAll());
        return "content/content_enlace :: modal_enlace2";
    }
    
    @GetMapping(value = "/nuevo_enlace")
    public String nuevo_enlace(Model model) {

        model.addAttribute("enlace", new Enlace());
        return "content/content_enlace :: modal_nuevo_enlace";
    }
    @GetMapping(value = "/nuevo_enlace_hijo")
    public String nuevo_enlace_hijo(Model model) {

        model.addAttribute("enlace", new Enlace());
        model.addAttribute("enlaces", enlaceService.findAll());
        return "content/content_enlace :: modal_nuevo_enlace_hijo";
    }
    

    @GetMapping(value = "/ListaEnlaceDisponibles")
    public String listarEnlaceDisponibles(Model model) {

        model.addAttribute("enlaces", rolesService.findAll());
        return "listas/listaEnlaceDisponibles";
    }

}
