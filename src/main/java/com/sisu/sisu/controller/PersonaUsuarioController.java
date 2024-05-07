package com.sisu.sisu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sisu.sisu.Service.EstadoCivilService;
import com.sisu.sisu.Service.IDipService;
import com.sisu.sisu.Service.IGradoService;
import com.sisu.sisu.Service.IPersonaService;
import com.sisu.sisu.Service.UsuarioService;
import com.sisu.sisu.entitys.Dip;
import com.sisu.sisu.entitys.GradoAcademico;
import com.sisu.sisu.entitys.Persona;
import com.sisu.sisu.entitys.TiposEstadoCivil;
import com.sisu.sisu.entitys.Usuario;

@Controller
public class PersonaUsuarioController {

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private IDipService dipService;

    @Autowired
    private IGradoService gradoService;

    @Autowired
    private EstadoCivilService estadoCivilService;

    @GetMapping(value = "/formPerUsuario") // Pagina principal
    public String registroPersona(Model model) {

        model.addAttribute("persona1", new Persona());
        model.addAttribute("personas1", personaService.findAll());

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        model.addAttribute("dip", new Dip());
        model.addAttribute("dips", dipService.findAll());

        model.addAttribute("grado", new GradoAcademico());
        model.addAttribute("grados", gradoService.findAll());

        model.addAttribute("estadoCivil", new TiposEstadoCivil());
        model.addAttribute("estadosCiviles", estadoCivilService.findAll());

        return "index/login";

    }

    @PostMapping(value = "/savePerUsuario")
    @Transactional // Asegura que todas las operaciones dentro del método sean atómicas
    public String guardarPersona(@Validated Persona persona1, Model model, RedirectAttributes flash,
            HttpServletRequest request,
            @RequestParam(name = "apodo", required = false) String apodo,
            @RequestParam(name = "clave", required = false) String clave,
            @RequestParam(name = "grado", required = false) Integer idGradoAcademico,
            @RequestParam(name = "dip", required = false) Integer idDip,
            @RequestParam(name = "estadoCivil", required = false) Integer idTipoEstadoCivil) {

        try {
            Persona existingPersona = personaService.validarCI(persona1.getCi());
            if (existingPersona != null) {
                // Establecer un mensaje de error y devolver a la página del formulario
                model.addAttribute("error",
                        "Ya existe una persona con el mismo número de carnet (CI): " + existingPersona.getNombres());
                return "error";
            }

            persona1.setEstado("PP");
            persona1.setGrado_academico(gradoService.findOne(idGradoAcademico));
            persona1.setDip(dipService.findOne(idDip));
            persona1.setTipos_estado_civil(estadoCivilService.findOne(idTipoEstadoCivil));

            // Solo guarda la persona al final, después de todas las modificaciones
            personaService.save(persona1);

            Usuario usuario = new Usuario();
            usuario.setApodo(apodo);
            usuario.setClave(clave);
            usuario.setEstado_usuario("PP");

            usuario.setPersona(persona1);
            usuarioService.save(usuario);

            return "redirect:/listaPerUsuario";
        } catch (Exception e) {
            flash.addFlashAttribute("error", "Error al intentar guardar la persona.");
            return "error";
        }
    }

    @PostMapping(value = "/SavePerUsuario") // Enviar datos de Registro a Lista
    public String guardarPersona_2(RedirectAttributes flash, HttpServletRequest request,
            @RequestParam(name = "idPersona") Integer id_persona,
            @RequestParam(name = "idUsuario") Integer idUsuario,
            @RequestParam(name = "nombres") String nombres,
            @RequestParam(name = "apPaterno") String apPaterno,
            @RequestParam(name = "apMaterno") String apMaterno,
            @RequestParam(name = "ci") String ci,
            @RequestParam(name = "celular") Integer celular,
            @RequestParam(name = "Direccion") String Direccion,
            @RequestParam(name = "apodo") String apodo,
            @RequestParam(name = "clave") String clave,
            @RequestParam(name = "grado", required = false) Integer idGradoAcademico,
            @RequestParam(name = "dip", required = false) Integer idDip,
            @RequestParam(name = "estadoCivil", required = false) Integer idTipoEstadoCivil) {

        Persona persona = personaService.findOne(id_persona);

        persona.setNombres(nombres);
        persona.setApPaterno(apPaterno);
        persona.setApMaterno(apMaterno);
        persona.setCi(ci);
        persona.setEstado("PP");
        persona.setGrado_academico(gradoService.findOne(idGradoAcademico));
        persona.setDip(dipService.findOne(idDip));
        persona.setTipos_estado_civil(estadoCivilService.findOne(idTipoEstadoCivil));
        personaService.save(persona); // guardas todos los datos de la persona (1)

        Usuario usuario = usuarioService.findOne(idUsuario); // creas un nuevo registro de usuario

        usuario.setPersona(persona);
        usuario.setApodo(apodo);
        usuario.setClave(clave);
        usuarioService.save(usuario);

        return "redirect:/listaPerUsuario";
    }

    @GetMapping(value = "/listaPerUsuario")
    public String listaUs(Model model, @Validated Persona persona1, Usuario usuario) {

        model.addAttribute("persona1", new Persona());
        model.addAttribute("personas1", personaService.findAll());

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarioService.findAll());

        model.addAttribute("dip", new Dip());
        model.addAttribute("dips", dipService.findAll());

        model.addAttribute("grado", new GradoAcademico());
        model.addAttribute("grados", gradoService.findAll());

        model.addAttribute("estadoCivil", new TiposEstadoCivil());
        model.addAttribute("estadosCiviles", estadoCivilService.findAll());

        return "listas/listaPerUsuario";

    }

    // -------------------------EDITAR---------------------------------------

    @GetMapping(value = "/editarPer/{idUsuario}")
    public String editarUs(Model model, @PathVariable("idUsuario") Integer idUsuario) {

        // Obtener la persona y el usuario correspondientes al ID proporcionado

        Usuario usuario = usuarioService.findOne(idUsuario);
        Persona persona = personaService.findOne(usuario.getPersona().getIdPersona());

        // Asegurarse de que la persona y el usuario existen
        if (persona != null && usuario != null) {
            // Configurar el estado de la persona y el usuario si es necesario
            persona.setEstado("PP");
            usuario.setEstado_usuario("PP");

            // Agregar la persona y el usuario al modelo
            model.addAttribute("persona1", persona);
            model.addAttribute("usuario", usuario);

            // Agregar otros atributos al modelo si es necesario
            model.addAttribute("personas1", personaService.findAll());
            model.addAttribute("usuarios1", usuarioService.findAll());
            model.addAttribute("dip", new Dip());
            model.addAttribute("dips", dipService.findAll());
            model.addAttribute("grado", new GradoAcademico());
            model.addAttribute("grados", gradoService.findAll());
            model.addAttribute("estadoCivil", new TiposEstadoCivil());
            model.addAttribute("estadosCiviles", estadoCivilService.findAll());

            return "listas/listaPerUsuario";
        } else {
            // Manejo de errores si la persona o el usuario no existen
            return "redirect:/paginaDeError"; // Reemplaza "paginaDeError" por tu página de manejo de errores
        }
    }

    @RequestMapping(value = "/usuario/{idUsuario}")
    public String getContent1(@PathVariable(value = "idUsuario") Integer idUsuario, Model model,
            HttpServletRequest request) {

        Usuario usuario = usuarioService.findOne(idUsuario);

        model.addAttribute("usuario", usuario);

        model.addAttribute("persona1", personaService.findOne(usuario.getPersona().getIdPersona()));
        model.addAttribute("dips", dipService.findAll());
        model.addAttribute("grados", gradoService.findAll());
        model.addAttribute("estadosCiviles", estadoCivilService.findAll());

        return "content :: content2";
    }

    // -------------------------ELIMINAR---------------------------------------

    @RequestMapping(value = "/eliminarUsuario/{idUsuario}")
    public String eliminarPersona(@PathVariable("idUsuario") Integer idUsuario) {
        Usuario usuario = usuarioService.findOne(idUsuario);
        Persona persona = personaService.findOne(usuario.getIdUsuario());
        persona.setEstado("X");
        usuario.setEstado_usuario("X");
        personaService.save(persona);
        usuarioService.save(usuario);
        return "redirect:/listaPerUsuario";
    }

}