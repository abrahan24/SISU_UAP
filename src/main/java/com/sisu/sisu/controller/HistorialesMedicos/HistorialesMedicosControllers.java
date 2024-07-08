package com.sisu.sisu.controller.HistorialesMedicos;

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
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sisu.sisu.Dao.IRecetaRemedioDao;
import com.sisu.sisu.Dao.TipoRecetaDao;
import com.sisu.sisu.Service.HistorialMedicoService;
import com.sisu.sisu.Service.HistorialRecetaService;
import com.sisu.sisu.Service.IAseguradoService;
import com.sisu.sisu.Service.ITipoRecetaService;
import com.sisu.sisu.Service.ListaLinameService;
import com.sisu.sisu.Service.RecetaService;
import com.sisu.sisu.entitys.Asegurado;
import com.sisu.sisu.entitys.Ficha;
import com.sisu.sisu.entitys.HistoriaClinica;
import com.sisu.sisu.entitys.HistorialMedico;
import com.sisu.sisu.entitys.HistorialReceta;
import com.sisu.sisu.entitys.HorarioMedico;
import com.sisu.sisu.entitys.ListaLiname;
import com.sisu.sisu.entitys.PersonalMedico;
import com.sisu.sisu.entitys.PersonalMedicoFicha;
import com.sisu.sisu.entitys.Receta;
import com.sisu.sisu.entitys.RecetaRemedios;
import com.sisu.sisu.entitys.TipoReceta;
import com.sisu.sisu.entitys.Usuario;

@Controller
public class HistorialesMedicosControllers {

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

    @PostMapping(value = "/generarReceta", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> generarReceta(
            @RequestParam(value = "medicamentos") List<Integer> lista_medicamentos,
            @RequestParam(value = "cantidad") List<String> lista_cantidad,
            @RequestParam(value = "id_asegurado") Integer id_asegurado,
            @RequestParam(value = "indicacion") String indicacion, HttpServletRequest request) {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSession");
        String id_usuario = usuario.getIdUsuario()+"";
        Date fechaActualD = new Date();
        TipoReceta tipoReceta = tipoRecetaService.findOne(1);
        Asegurado asegurado = aseguradoService.findOne(id_asegurado);
        // CREAR LA RECETA
        Receta receta = new Receta();
        receta.setEstado("S");
        receta.setTipo_receta(tipoReceta);
        receta.setFecha(fechaActualD);
        receta.setDescripcion(indicacion);
        recetaService.registrarReceta(receta);

        for (int i = 0; i < lista_medicamentos.size(); i++) {
            ListaLiname liname = listaLinameService.findOne(lista_medicamentos.get(i));
            RecetaRemedios recetaRemedios = new RecetaRemedios();
            recetaRemedios.setEstado("A");
            recetaRemedios.setCantidad_recetada(lista_cantidad.get(i));
            recetaRemedios.setLista_liname(liname);
            recetaRemedios.setReceta(receta);
            recetaRemedioDao.save(recetaRemedios);
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
        return ResponseEntity.ok(id_usuario);
    
        
    }
}
