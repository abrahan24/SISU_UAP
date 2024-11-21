package com.sisu.sisu.controller.usuario;

import java.text.ParseException;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.sisu.sisu.Service.IPersonaService;
import com.sisu.sisu.Service.IRolesService;
import com.sisu.sisu.Service.UsrRolesService;
import com.sisu.sisu.Service.UsuarioService;
import com.sisu.sisu.entitys.Roles;
import com.sisu.sisu.entitys.Usuario;
import org.springframework.web.bind.annotation.RequestBody;





@Controller
public class Usr_rolesController {


    @Autowired
    private UsrRolesService usrrolesservice;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private IRolesService iRolesService;

    @Autowired
    private IPersonaService personaService;

    
    // @GetMapping(value = "/ListaUsr")
    // public String listaUs(Model model, @Validated UsrRoles usrRoles) {

    //     model.addAttribute("usrroles1", usrrolesservice.findAll());

    //     model.addAttribute("usuarios", usuarioService.findAll());

    //     model.addAttribute("roles", iRolesService.findAll());

    //     return "listas/ListaUsr";

    // }


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
    public ResponseEntity<String> guardar_roles(@Validated Usuario usuario,
            @RequestParam(name = "idRol", required = false) Integer[] idRol) throws ParseException {

        if (usuario == null) {
            return ResponseEntity.ok("1");
        } else {
            usuario.setRegistro(usuario.getRegistro());
            usuario.setModificacion(new Date());
            usuarioService.save(usuario);
            return ResponseEntity.ok("2");
        }
    }

    @GetMapping("/nuevo_user")
    public String nuevo_user(Model model) {

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("personas", personaService.findAll());
        return "content/content_user :: modal_new_user";
    }
    
    @PostMapping("/guardar_user")
    public ResponseEntity<String> guardar_usuario(@Validated Usuario usuario,
            @RequestParam(name = "idPersona") Integer idPersona) {

        if (usuario.getIdUsuario() == null) {
            if (usuarioService.validar_persona(idPersona) == null) {
                usuario.setRegistro(new Date());
                usuario.setEstado_usuario("A");
                usuario.setPersona(personaService.findOne(idPersona));
                usuarioService.save(usuario);
                return ResponseEntity.ok("1");
            } else {
                return ResponseEntity.ok("2");
            }

        } else {
            Usuario u = usuarioService.findOne(usuario.getIdUsuario());

            u.setModificacion(new Date());
            u.setApodo(usuario.getApodo());
            u.setClave(usuario.getClave());
            u.setPersona(personaService.findOne(idPersona));
            u.setEstado_usuario("A");
            usuarioService.save(u);
            return ResponseEntity.ok("3");

        }
    }
    
   
    @GetMapping(value = "/roles/{idUsuario}")
    public String obtener_Roles_User(@PathVariable(name = "idUsuario")Integer idUsuario, Model model) {

        Usuario usuario = usuarioService.findOne(idUsuario);

        // model.addAttribute("idUsuario", usuario.getIdUsuario());
        model.addAttribute("roles", iRolesService.findAll());
        model.addAttribute("usuario", usuario);

        return "content/content_user :: modal_user";
    }

    @GetMapping(value = "/role/{idRol}")
    public String obtener_Roles(@PathVariable(name = "idRol")Integer idRol, Model model) {

        Roles roles = iRolesService.findOne(idRol);

        model.addAttribute("role", roles);

        return "content :: contentRol";
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
