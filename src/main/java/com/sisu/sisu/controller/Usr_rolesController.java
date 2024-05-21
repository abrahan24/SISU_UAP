package com.sisu.sisu.controller;


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
import org.springframework.web.bind.annotation.RequestParam;

import com.sisu.sisu.Service.IRolesService;
import com.sisu.sisu.Service.UsrRolesService;
import com.sisu.sisu.Service.UsuarioService;
import com.sisu.sisu.entitys.Roles;
import com.sisu.sisu.entitys.UsrRoles;
import com.sisu.sisu.entitys.Usuario;

@Controller
public class Usr_rolesController {


    @Autowired
    private UsrRolesService usrrolesservice;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private IRolesService iRolesService;

    //----------------------Metodo listar----------------------------
    
    @GetMapping(value = "/ListaUsr")
    public String listaUs(Model model, @Validated UsrRoles usrRoles) {

        model.addAttribute("usrroles1", usrrolesservice.findAll());

        model.addAttribute("usuarios", usuarioService.findAll());

        model.addAttribute("roles", iRolesService.findAll());

        return "listas/ListaUsr";

    }

    // -------------------------asignacion de
    // rol---------------------------------------

    @GetMapping(value = "/asignacionrol/{idUsuario}")
    public String asignacion(Model model, @PathVariable("idUsuario") Integer idUsuario) {

        System.out.println("+++++++++++++++++++++++++1");
        Usuario usuario = usuarioService.findOne(idUsuario);

        if (usuario != null) {
            System.out.println(
                    "NO ES NULO, Y SE YAMA " + "-" + usuario.getPersona().getNombres() + "-" + usuario.getPersona().getApMaterno()
                            + "-" + usuario.getPersona().getDireccion()+  "-" + usuario.getPersona().getEstado());
        } else {
            System.out.println("es nulo");
        }
        usuario.setEstado_usuario("A");
        System.out.println("+++++++++++++++++++++++++3");
        model.addAttribute("usuario", new Usuario());
        System.out.println("+++++++++++++++++++++++++4");
        model.addAttribute("usuarios", usuario);
        System.out.println("+++++++++++++++++++++++++5");
        model.addAttribute("roles", iRolesService.findAll());
        System.out.println("el tamaño de la lista es" + iRolesService.findAll().size());

        return "listas/ListaPrueva";
    }

    @PostMapping("/guardar_roles")
    public ResponseEntity<String> guardar_roles(@RequestParam(name = "idUsuario") Integer idUsuario,
            @RequestParam(name = "idRol", required = false) Integer[] idRol) {
        Usuario usuario = usuarioService.findOne(idUsuario);

        if (usuario == null) {
            for (int i = 0; i < idRol.length; i++) {

                UsrRoles usrRoles = new UsrRoles();
    
                usrRoles.setEstado("A");
                usrRoles.setRegistro(new Date());
                usrRoles.setIdRol(iRolesService.findOne(idRol[i]));
                usrRoles.setIdUsuario(usuario);
                usrrolesservice.save(usrRoles);
                
            }
            return ResponseEntity.ok("1");

        }else{
            Usuario u = usuarioService.findOne(idUsuario);

            for (UsrRoles usrRoles : u.getUsr_Roles()) {
                for (int i = 0; i < idRol.length; i++) {
                    if (usrRoles.getIdRol().getIdRol() != idRol[i]) {
                        UsrRoles usr = new UsrRoles();
                        usr.setEstado("A");
                        usr.setModificacion(new Date());
                        usr.setIdRol(iRolesService.findOne(idRol[i]));
                        usr.setIdUsuario(u);
                        usrrolesservice.save(usr);
                    }else{
                        return ResponseEntity.ok("3");
                    }
                }
            }

            return ResponseEntity.ok("2");

        }
        
    }


    @RequestMapping(value = "eliminarUsr/{idUsrRol}")
    private String eliminarUsr(@PathVariable("idUsrRol") Integer idUsrRol){
        UsrRoles usrRoles = usrrolesservice.findOne(idUsrRol);
        usrRoles.setEstado("X");
        usrrolesservice.save(usrRoles);
        return "redirect:listas/ListaUsr";
    }

    @GetMapping(value = "/editar_roles/{idUsuario}")
    public String editar_roles(@PathVariable(name = "idUsuario")Integer idUsuario, Model model) {
        Usuario usuario = usuarioService.findOne(idUsuario);

        model.addAttribute("idUsuario", usuario.getIdUsuario());
        model.addAttribute("roles", iRolesService.findAll());
        model.addAttribute("roles_asignados", usuario.getUsr_Roles());
        return "content/content_user :: modal_user";
    }
    

    @GetMapping(value = "/roles/{idUsuario}")
    public String obtener_Roles(@PathVariable(name = "idUsuario")Integer idUsuario, Model model) {

        Usuario usuario = usuarioService.findOne(idUsuario);


        model.addAttribute("idUsuario", idUsuario);
        model.addAttribute("roles", iRolesService.findAll());
        model.addAttribute("roles_asignados", usuario.getUsr_Roles());

        return "content/content_user :: modal_user";
    }
    

    @GetMapping(value = "/cont")
    public String Content(Model model){

        System.out.println("Holas:");
        model.addAttribute("roles", iRolesService.findAll());

        return "content/contentInfo :: content1";
    }


    //metodo que muuesta datos del usuario, los roles que tiene y los lista los que se les puede asignar mas

    @GetMapping(value = "/VerificarRol")
    public String verificarUsr(Model model, HttpServletRequest request , @RequestParam("idUsuario") Integer idUsuario, 
            @RequestParam(name = "solicitudesSeleccionadas", required = false) Integer[] solicitudesSeleccionadas){
        System.out.println("Se esta obteniendo al usuario:" + idUsuario);

        model.addAttribute("usuarios", usuarioService.findOne(idUsuario));

        return "listas/UsrEdit";
    }

}
