package com.sisu.sisu.controller.Ficha;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sisu.sisu.Dao.HorarioServicioDao;
import com.sisu.sisu.Dao.PersonalMedicoDao;
import com.sisu.sisu.Dao.PersonalMedicoFichaDao;
import com.sisu.sisu.Service.FichaService;
import com.sisu.sisu.Service.HistorialSeguroService;
import com.sisu.sisu.Service.HorarioMedicoService;
import com.sisu.sisu.Service.IAseguradoService;
import com.sisu.sisu.Service.IPersonaService;
import com.sisu.sisu.Service.ListaLinameService;
import com.sisu.sisu.Service.PersonalMedicoService;
import com.sisu.sisu.entitys.Asegurado;
import com.sisu.sisu.entitys.Ficha;
import com.sisu.sisu.entitys.HorarioMedico;
import com.sisu.sisu.entitys.HorarioServicio;
import com.sisu.sisu.entitys.ListaLiname;
import com.sisu.sisu.entitys.Persona;
import com.sisu.sisu.entitys.PersonalMedico;
import com.sisu.sisu.entitys.PersonalMedicoFicha;
import com.sisu.sisu.entitys.Usuario;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class FichaController {

    @Autowired
    private FichaService fichaService;

    @Autowired
    private IPersonaService personaService;

    @Autowired
    private IAseguradoService aseguradoService;

    @Autowired
    private PersonalMedicoService personalMedicoService;

    @Autowired
    private PersonalMedicoFichaDao personalMedicoFichaDao;

    @Autowired
    private HorarioServicioDao horarioServicioDao;

    @Autowired
    private HorarioMedicoService horarioMedicoService;

    @Autowired
    private ListaLinameService listaLinameService;

    private static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

    @RequestMapping(value = "/vistaF", method = RequestMethod.GET)
    public String vistaFicha(Model model) {

        model.addAttribute("ficha", new Ficha());
        model.addAttribute("fichas", fichaService.findAll());

        model.addAttribute("asegurado", new Asegurado());
        model.addAttribute("asegurados", aseguradoService.findAll());

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", personaService.findAll());

        return "Fichas/listaFichaP";
    }

    // -------------------------------to list---------------------------------

    @GetMapping(value = "/listaFichasGeneral")
    public String listaFichasGeneral(Model model, @Validated Ficha ficha, HttpServletRequest request) {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSession");

        if (usuario == null) {

            return "redirect:/";

        }
        Date fechaActualD = new Date();

        model.addAttribute("ficha", new Ficha());
        model.addAttribute("fichas", fichaService.listaFichasFechaActual(fechaActualD));
        // model.addAttribute("p_medicos", personalMedicoService.listarTodo());

        model.addAttribute("personalMedico", new PersonalMedico());
        return "Fichas/listaFichaGeneral";
    }

    @GetMapping(value = "/lista_medicos/{idFicha}")
    public String getMethodName(@PathVariable(name = "idFicha") Integer idFicha, Model model,HttpServletRequest request) {
        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSession");

        if (usuario == null) {

            return "redirect:/";

        }
        model.addAttribute("ficha", new Ficha());
        model.addAttribute("idFicha", idFicha);
        model.addAttribute("p_medicos", personalMedicoService.listaPersonalMedicoPorServicioFicha(idFicha));
        model.addAttribute("horarios_s", horarioServicioDao.listaHorariosServicios(idFicha));
        model.addAttribute("horarios", new HorarioServicio());
        model.addAttribute("personalMedico", new PersonalMedico());
        return "Fichas/Content_modal :: contentM";
    }

    @PostMapping("/asignar_medico")
    public ResponseEntity<String> postMethodName(@RequestParam(name = "idFicha") Integer idFicha,
            @RequestParam(name = "idPersonalMedico") Integer idPersonalMedico,
            @RequestParam(name = "fechaAtencion") String fechaAtencion) {

        // Define el formato de la fecha y hora recibida
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        // Parsear la cadena a LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.parse(fechaAtencion, formatter);

        LocalDate fechaActual = LocalDate.now();
        DayOfWeek diaDeLaSemana = fechaActual.getDayOfWeek();
        String nombreDiaEnEspanol = diaDeLaSemana.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
        String nombreDiaCapitalizado = capitalizeFirstLetter(nombreDiaEnEspanol);

        // Convertir LocalDateTime a Date
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        PersonalMedico personalMedico = personalMedicoService.buscarId(idPersonalMedico);
        Ficha ficha = fichaService.findOne(idFicha);
        ficha.setEstado("AA");
        ficha.setHorario(date);

        PersonalMedicoFicha personalMedicoFicha = new PersonalMedicoFicha();
        personalMedicoFicha.setFicha(ficha);
        personalMedicoFicha.setPersonal_medico(personalMedicoService.buscarId(idPersonalMedico));
        personalMedicoFicha.setRegistro(new Date());
        personalMedicoFicha.setHorario(date);

        List<HorarioMedico> listaHorariosMedicos = horarioMedicoService
                .listaHorariosMedicos(personalMedico.getIdPersonalMedico());
        List<Ficha> listaFichasMedicosAsignadas = fichaService.listaFichasAsignadas(idPersonalMedico);

        for (HorarioMedico horario : listaHorariosMedicos) {

            if (horario.getHorarios().getDia().equals(nombreDiaCapitalizado)) {
                System.out.println(listaFichasMedicosAsignadas.size() + " =?>?= " + horario.getCantidad_fichas());
                if (listaFichasMedicosAsignadas.size() >= horario.getCantidad_fichas()) {
                    return ResponseEntity.ok("error2"); // Limite
                }
            }
        }
        fichaService.save(ficha);
        personalMedicoFichaDao.save(personalMedicoFicha);

        return ResponseEntity.ok("1");
    }
    @GetMapping("/linames")
    @ResponseBody
    public List<ListaLiname> obtenerLinames(Model model) {
    
       
        return listaLinameService.findAll();
    }

    @GetMapping(value = "/fichasAsegurado/{id_usuario}")
    public String generarFicha(@PathVariable("id_usuario") int id_usuario, Model model, @Validated Ficha ficha,
            HttpServletRequest request) {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSession");

        if (usuario == null) {

            return "redirect:/";

        }
        // Obtener la fecha actual y formatearla
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaActual.format(formatter);

        List<PersonalMedicoFicha> listFichas = personalMedicoFichaDao.listaFichasAsignadasPersonalMedico(id_usuario);
        System.out.println(listFichas.size());
        System.out.println(id_usuario);
        model.addAttribute("fichas", listFichas);
        model.addAttribute("linames", listaLinameService.findAll());
        model.addAttribute("idUsuario", usuario.getIdUsuario());
        model.addAttribute("fecha", fechaFormateada);


        return "Fichas/listaFichaP";
    }

    @PostMapping(value = "/rechazar-ficha/{idFicha}")
    @ResponseBody
    public void rechazarFicha(HttpServletRequest request, Model model,
            @PathVariable("idFicha") int idFicha) {
        Ficha ficha = fichaService.findOne(idFicha);
        ficha.setEstado("X");
        fichaService.save(ficha);

    }

    @PostMapping(value = "/completar-ficha/{idFicha}")
    @ResponseBody
    public void completarFicha(HttpServletRequest request, Model model,
            @PathVariable("idFicha") int idFicha) {
        Ficha ficha = fichaService.findOne(idFicha);
        ficha.setEstado("AAA");
        fichaService.save(ficha);

    }

    @GetMapping(value = "/fichasAseguradoC/{id_usuario}")
    public String fichasAseguradoCompletados(@PathVariable("id_usuario") int id_usuario, Model model,
            @Validated Ficha ficha, HttpServletRequest request) {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSession");

        if (usuario == null) {

            return "index/login";

        }

        List<PersonalMedicoFicha> listFichas = personalMedicoFichaDao.personalMedicoFichasCompletadas(id_usuario);
        System.out.println(listFichas.size());
        System.out.println(id_usuario);
        model.addAttribute("fichas", listFichas);
        model.addAttribute("idUsuario", usuario.getIdUsuario());

        return "Fichas/listaFichaCompletadas";
    }

}
