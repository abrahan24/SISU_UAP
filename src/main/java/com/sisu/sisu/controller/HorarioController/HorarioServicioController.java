package com.sisu.sisu.controller.HorarioController;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sisu.sisu.Service.HorarioServicioService;
import com.sisu.sisu.Service.HorariosService;
import com.sisu.sisu.Service.ServicioMedicoService;
import com.sisu.sisu.entitys.HorarioServicio;
import com.sisu.sisu.entitys.Usuario;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class HorarioServicioController {
    
    @Autowired
    private HorarioServicioService horarioServicioService;
    @Autowired
    private HorariosService horariosService;
    @Autowired
    private ServicioMedicoService servicioMedicoService;

    @GetMapping("/lista_horario_servicio")
    public String lista_horario_servicio(Model model, HttpServletRequest request) {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSession");
		if (usuario == null) {
			return "redirect:/";
		}
        model.addAttribute("horarios", horarioServicioService.findAll());
        return "Horario/Lista_horario_servicio";
    }
    
    @GetMapping("/nuevo_horario_servicio")
    public String nuevo_horario_servicio(Model model) {
        model.addAttribute("horario", new HorarioServicio());
        model.addAttribute("horarios", horariosService.findAll());
        model.addAttribute("servicios", servicioMedicoService.findAll());
        return "Horario/ContentHorario :: h_servicio";
    }
    
    @GetMapping("/edit_horario_servicio/{id}")
    public String edit_horario_servicio(Model model,@PathVariable(name = "id")Integer id) {
        model.addAttribute("horario", horarioServicioService.findOne(id));
        model.addAttribute("horarios", horariosService.findAll());
        model.addAttribute("servicios", servicioMedicoService.findAll());
        return "Horario/ContentHorario :: h_servicio";
    }

    @PostMapping("/guardar_horario_servicio")
    public ResponseEntity<String> guardar_horario_servicio(@Validated HorarioServicio horarioServicio) {

        if (horarioServicio.getIdHorarioServicio() == null) {
            horarioServicio.setFechaRegistroFichaa(new Date());
            horarioServicio.setEstado("A");
            horarioServicioService.save(horarioServicio);
            return ResponseEntity.ok("1");
        }else{
            horarioServicio.setModificacion(new Date());
            horarioServicio.setEstado("A");
            horarioServicioService.save(horarioServicio);
            return ResponseEntity.ok("2");
        }
    }
    
    @GetMapping(value = "/eliminar_horario_servicio/{id}")
    @ResponseBody
    public void eliminar_horario_servicio(@PathVariable(name = "id")Integer id){

        HorarioServicio horarioServicio = horarioServicioService.findOne(id);
        horarioServicio.setEstado("X");
        horarioServicioService.save(horarioServicio);
    }
    
}
