package com.sisu.sisu.controller.Farmacia;

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


}

