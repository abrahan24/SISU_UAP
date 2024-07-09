package com.sisu.sisu.controller.Farmacia;

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
import com.sisu.sisu.Dao.TipoRecetaDao;
import com.sisu.sisu.Service.HistorialMedicoService;
import com.sisu.sisu.Service.HistorialRecetaService;
import com.sisu.sisu.Service.IAseguradoService;
import com.sisu.sisu.Service.ITipoRecetaService;
import com.sisu.sisu.Service.ListaLinameService;
import com.sisu.sisu.Service.RecetaService;
import com.sisu.sisu.Service.ResetaRemedioService;
import com.sisu.sisu.Service.UtilidadesService.UtilidadesService;
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

import net.sf.jasperreports.engine.JRException;

@Controller
public class farmaciaController {

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

    //TODO PARA RECETA INICIO
    @GetMapping(value = "/listaRecetasGeneral")
    public String listaRecetasGeneral(Model model, HttpServletRequest request) {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSession");

        if (usuario == null) {

            return "redirect:/";

        }
        Date fechaActualD = new Date();

        model.addAttribute("listaRecetasP", recetaService.listaRecetasPendientes());
        model.addAttribute("listaRecetasG", recetaService.listaRecetasGeneral());
        return "farmacia/listaRecetaGeneral";
    }

    @GetMapping("/obtenerRecetaRemedios")
    @ResponseBody
    public List<RecetaRemedios> obtenerRecetaRemedios(@RequestParam int idReceta) {
        return resetaRemedioService.listaRecetaRemediosPorIdReceta(idReceta);
    }


    @PostMapping(value = "/generarRecetaFarmacia", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> generarRecetaFarmacia(
            @RequestParam(value = "id_receta2") Integer id_receta,
            // @RequestParam(value = "medicamentos") List<Integer> lista_medicamentos,
            // @RequestParam(value = "cantidadR") List<String> lista_cantidadR,
              @RequestParam(value = "id_remedio") List<Integer> lista_remedio,
            @RequestParam(value = "cantidadD") List<String> lista_cantidadD,
       HttpServletRequest request) {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSession");
        String id_usuario = usuario.getIdUsuario()+"";
        Date fechaActualD = new Date();
        TipoReceta tipoReceta = tipoRecetaService.findOne(1);
        // Asegurado asegurado = aseguradoService.findOne(id_asegurado);


        // CREAR LA RECETA
        Receta receta = recetaService.buscarRecetaId(id_receta);
        receta.setEstado("A");
        receta.setTipo_receta(tipoReceta);
        receta.setId_usuario(usuario.getIdUsuario());
        receta.setFecha_farmacia(fechaActualD);
        // receta.setFecha(fechaActualD);
        recetaService.registrarReceta(receta);

        for (int i = 0; i < lista_remedio.size(); i++) {
    
            RecetaRemedios recetaRemedios = resetaRemedioService.buscarId(lista_remedio.get(i));
            recetaRemedios.setEstado("A");
            recetaRemedios.setReceta(receta);
            recetaRemedios.setCantidad_dispensada(lista_cantidadD.get(i));
            recetaRemedioDao.save(recetaRemedios);
        }

      
        return ResponseEntity.ok("1");
    
        
    }

    @PostMapping(value ="/recibo_receta")
    public ResponseEntity<ByteArrayResource> recibo_receta(
    @RequestParam(name = "id_receta" ,required = false)Integer id_receta,
    HttpServletRequest request) throws IOException, JRException, SQLException {

        String nombreArchivo = "RECIBO_RECETARIO.jrxml";

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("id_receta", id_receta);

        ByteArrayOutputStream stream = utilidadesServices.compilarAndExportarReporte(nombreArchivo,parametros);

        byte[] bytes = stream.toByteArray();

        ByteArrayResource resource = new ByteArrayResource(bytes);
        
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "inline;filename=" + "Recibo Receta"
                                + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(bytes.length)
                .body(resource);
    }
}
