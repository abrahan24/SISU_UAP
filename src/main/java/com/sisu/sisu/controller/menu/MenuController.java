package com.sisu.sisu.controller.menu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sisu.sisu.Service.IEnlaceService;
import com.sisu.sisu.Service.IMenuService;
import com.sisu.sisu.Service.IRolesService;
import com.sisu.sisu.Service.UsuarioService;
import com.sisu.sisu.entitys.Enlace;
import com.sisu.sisu.entitys.Menu;
import com.sisu.sisu.entitys.Roles;
import com.sisu.sisu.entitys.Usuario;

@Controller
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IEnlaceService enlaceService;

    @Autowired
    private IRolesService rolesService;

    @Autowired
    private UsuarioService usuarioService;

    /* FORM MENU 1 */

    @GetMapping("/formMenu2/{enlaceId}")
    public String procesarEnlace(@PathVariable("enlaceId") Integer enlaceId, Model model) {

        System.out.println("El enlace es: " + enlaceId + "+++++++++++++++++++++++++++++++++1");

        model.addAttribute("menu", new Menu());
        model.addAttribute("menus", menuService.findAll());

        // model.addAttribute("enlaceHijo", new Enlace());
        model.addAttribute("enlace", new Enlace());
        // List<Enlace> listaEnlaceHijos = enlaceService.listaEnlaceHijo(enlaceId);
        List<Enlace> listaEnlaceHijos = enlaceService.listaEnlaceHijo(enlaceId);

        model.addAttribute("listaEnlaceHijo", enlaceService.listaEnlaceHijo(enlaceId));
        System.out.println("El enlace es: " + enlaceService.listaEnlaceHijo(enlaceId).size() + "+++++++++++++++++++++++++++++++++1");

        model.addAttribute("role", new Roles());
        model.addAttribute("roles", rolesService.findAll());

        model.addAttribute("idEnlacePadre", enlaceId); // agregado hoy 23/11
        System.out.println("el enlace padre: " + enlaceId); // agregado hoy 23/11

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        model.addAttribute("idEnlacePadre", enlaceId);
        System.out.println("el enlace padre: " + enlaceId+ "+++++++++++++++++++++++++++++++++LA COTORRISA");
    
 
        System.out.println("El enlace es: " + enlaceId + "+++++++++++++++++++++++++++++++++1");
        System.out.println(listaEnlaceHijos.size());
        // model.addAttribute("listaEnlacesHijo",
        // enlaceService.listaEnlaceHijo(idEnlacePadre));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++1");
        System.out.println("El enlace es: " + enlaceId + "+++++++++++++++++++++++++++++++++2");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++3");
        System.out.println(enlaceService.listaEnlaceHijo(20).size());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++4");

        return "formularios/formaAsignarRol1";

    }

    @PostMapping(value = "/guardarMenu")
    public String guardarMenu(@Validated Menu menu, RedirectAttributes flash, HttpServletRequest request,
            @RequestParam(name = "role", required = false) Integer idRol) {

        menu.setIdRol(rolesService.findOne((idRol)));
        menu.setIdEstado("A");
        menuService.save(menu);

        return "redirect:/formMenu1";
    }

    @PostMapping(value = "/guardarEnlaceRolMenu")
    public String manejarFormulario(@RequestParam(name = "idRol") Integer idRol,@RequestParam(name = "idEnlacePadre") Integer idEnlacePadre,
            @RequestParam(name = "solicitudesSeleccionadas", required = false)Integer [] solicitudesSeleccionadas) {
      
    	System.out.println("EL ID ENLACE PADRE ES: " +idEnlacePadre+"teste");        
    	Roles roles = rolesService.findOne(idRol);
    	
    	         Menu menuPadre = new Menu();
    	         	
    	            menuPadre.setIdEstado("A");
    	            menuPadre.setIdEnlace(enlaceService.findOne(idEnlacePadre));
    	            menuPadre.setIdRol(rolesService.findOne(roles.getIdRol()));
    	            menuPadre.setId_usuario(usuarioService.findOne(1));
    	            menuService.save(menuPadre);
    	            
                for (int i = 0; i < solicitudesSeleccionadas.length; i++) {
                    
                    Enlace enlace = enlaceService.findOne(solicitudesSeleccionadas[i]);

                    System.out.println(roles.getRol()+" "+enlace.getNombre_enlace());
                   

                   Menu menu = new Menu();
                   menu.setIdEnlace(enlaceService.findOne(solicitudesSeleccionadas[i]));
                   menu.setIdRol(rolesService.findOne(roles.getIdRol())); 
                   menu.setId_usuario(usuarioService.findOne(1));
                   menu.setIdEstado("A");
                   menuService.save(menu);
                }
        return "redirect:/ListaEnlace";
        
    }

    @GetMapping(value = "/listaMenu")
    public String listaMenu(Model model, @RequestParam("idEnlacePadre") Integer idEnlacePadre) {

        model.addAttribute("menu", new Enlace());
        model.addAttribute("menus", menuService.findAll());

        model.addAttribute("role", new Roles());
        model.addAttribute("roles", rolesService.findAll());

        // model.addAttribute("enlace", new Enlace());
        // model.addAttribute("listaEnlaceHijo", enlaceService.listaEnlaceHijo(idEnlacePadre));

        return "listas/listaMenu";
    }

}
