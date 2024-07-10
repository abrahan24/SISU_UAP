package com.sisu.sisu.controller.Laboratorio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sisu.sisu.Dao.IRecetaRemedioDao;
import com.sisu.sisu.Dao.LaboratorioDao;
import com.sisu.sisu.Dao.TipoRecetaDao;
import com.sisu.sisu.Service.HistorialMedicoService;
import com.sisu.sisu.Service.HistorialRecetaService;
import com.sisu.sisu.Service.IAseguradoService;
import com.sisu.sisu.Service.ITipoRecetaService;
import com.sisu.sisu.Service.LaboratorioService;
import com.sisu.sisu.Service.ListaLinameService;
import com.sisu.sisu.Service.RecetaLaboratorioService;
import com.sisu.sisu.Service.RecetaService;
import com.sisu.sisu.Service.ResetaRemedioService;
import com.sisu.sisu.Service.UtilidadesService.UtilidadesService;
import com.sisu.sisu.entitys.Asegurado;
import com.sisu.sisu.entitys.Ficha;
import com.sisu.sisu.entitys.HistoriaClinica;
import com.sisu.sisu.entitys.HistorialMedico;
import com.sisu.sisu.entitys.HistorialReceta;
import com.sisu.sisu.entitys.HorarioMedico;
import com.sisu.sisu.entitys.Laboratorio;
import com.sisu.sisu.entitys.ListaLiname;
import com.sisu.sisu.entitys.PersonalMedico;
import com.sisu.sisu.entitys.PersonalMedicoFicha;
import com.sisu.sisu.entitys.Receta;
import com.sisu.sisu.entitys.RecetaLaboratorios;
import com.sisu.sisu.entitys.RecetaRemedios;
import com.sisu.sisu.entitys.TipoReceta;
import com.sisu.sisu.entitys.Usuario;

import net.sf.jasperreports.engine.JRException;

@Controller
public class laboratorioController {

    @Autowired
    private ITipoRecetaService tipoRecetaService;

    @Autowired
    private ListaLinameService listaLinameService;

    @Autowired
    private RecetaService recetaService;

    @Autowired
    private IRecetaRemedioDao recetaRemedioDao;

    @Autowired
    private HistorialMedicoService historialMedicoService;

    @Autowired
    private HistorialRecetaService historialRecetaService;

    @Autowired
    private IAseguradoService aseguradoService;

    @Autowired
    private ResetaRemedioService resetaRemedioService;

    @Autowired
    private UtilidadesService utilidadesServices;

    @Autowired
    private LaboratorioService laboratorioService;

    @Autowired
    private RecetaLaboratorioService recetaLaboratorioService;

    //TODO PARA RECETA INICIO
    @GetMapping(value = "/listaAseguradosLaboratorioGeneral")
    public String listaAseguradosLaboratorioGeneral(Model model, HttpServletRequest request) {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSession");

        if (usuario == null) {

            return "redirect:/";

        }
        Date fechaActualD = new Date();

        model.addAttribute("listaAsegurado", aseguradoService.findAll());
        model.addAttribute("laboratorios", laboratorioService.listarTodo());
        model.addAttribute("fecha", fechaActualD);

        return "Laboratorio/listaAseguradosGeneral";
    }

   
    @PostMapping(value = "/generarSolicitudLaboratorio", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> generarSolicitudLaboratorio(
            @RequestParam(value = "laboratorio") List<Integer> lista_laboratorio,
            @RequestParam(value = "id_asegurado") Integer id_asegurado,
            @RequestParam(value = "otros") String otros,
            @RequestParam(value = "gabinete") String gabinete, HttpServletRequest request) {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSession");
        String id_usuario = usuario.getIdUsuario()+"";
        Date fechaActualD = new Date();
        TipoReceta tipoReceta = tipoRecetaService.findOne(3);
        Asegurado asegurado = aseguradoService.findOne(id_asegurado);
        // CREAR LA RECETA
        Receta receta = new Receta();
        receta.setEstado("S");
        receta.setTipo_receta(tipoReceta);
        receta.setFecha(fechaActualD);
        receta.setOtros(otros);
        receta.setId_usuario(usuario.getIdUsuario());
        receta.setEstudio_gabinete(gabinete);
        recetaService.registrarReceta(receta);

        for (int i = 0; i < lista_laboratorio.size(); i++) {
            Laboratorio laboratorio = laboratorioService.buscarLaboratorioId(lista_laboratorio.get(i));
            RecetaLaboratorios recetaLaboratorios = new RecetaLaboratorios();
            recetaLaboratorios.setEstado("A");
            recetaLaboratorios.setLaboratorio(laboratorio);
            recetaLaboratorios.setReceta(receta);
            recetaLaboratorioService.registrar(recetaLaboratorios);
        }

        HistorialMedico historialMedicoValidar = historialMedicoService.getHistorialMedico_por_id_seguro(id_asegurado);

        if (historialMedicoValidar != null) {
            System.out.println(
							" ----------------------- ESTE ASEGURADO YA TIENE UN HISTORIAL MEDICO EN LA BASE DE DATOS ---------------------------");
            HistorialReceta historialReceta = new HistorialReceta();
            historialReceta.setEstado("A");
            historialReceta.setHistorial_medico(historialMedicoValidar);
            historialReceta.setReceta(receta);
            historialRecetaService.save(historialReceta);
        } else {
            System.out.println(
                " ----------------------- ESTE ASEGURADO NOO TIENE UN HISTORIAL MEDICO EN LA BASE DE DATOS ---------------------------");
            HistorialMedico historialMedico = new HistorialMedico();
            historialMedico.setEstado("A");
            historialMedico.setAsegurado(asegurado);
            historialMedicoService.save(historialMedico);
            HistorialReceta historialReceta = new HistorialReceta();
            historialReceta.setEstado("A");
            historialReceta.setHistorial_medico(historialMedico);
            historialReceta.setReceta(receta);
            historialRecetaService.save(historialReceta);

        }
        return ResponseEntity.ok("1");
    
        
    }
   

    
}
