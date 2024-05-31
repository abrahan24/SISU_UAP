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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sisu.sisu.Service.HorarioMedicoService;
import com.sisu.sisu.Service.HorariosService;
import com.sisu.sisu.Service.PersonalMedicoService;
import com.sisu.sisu.entitys.HorarioMedico;
import com.sisu.sisu.entitys.HorarioServicio;
import com.sisu.sisu.entitys.Usuario;

@Controller
public class HorarioMedicoController {

    @Autowired
    private HorarioMedicoService horarioMedicoService;

    @Autowired
    private HorariosService horariosService;
    
    @Autowired
    private PersonalMedicoService personalMedicoService;
    
    @GetMapping("/lista_horario_medico")
    public String lista_horario_medico(Model model, HttpServletRequest request) {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSession");
		if (usuario == null) {
			return "redirect:/";
		}
        model.addAttribute("horarios", horarioMedicoService.findAll());
        return "Horario/Lista_horario_medico";
    }

    @GetMapping("/nuevo_horario_medico")
    public String nuevo_horario_medico(Model model) {
        model.addAttribute("horario", new HorarioMedico());
        model.addAttribute("horarios", horariosService.findAll());
        model.addAttribute("medicos", personalMedicoService.listarTodo());
        return "Horario/ContentHorario :: h_medico";
    }
    
    @GetMapping("/edit_horario_medico/{id}")
    public String edit_horario_medico(Model model,@PathVariable(name = "id")Integer id) {
        model.addAttribute("horario", horarioMedicoService.findOne(id));
        model.addAttribute("horarios", horariosService.findAll());
        model.addAttribute("medicos", personalMedicoService.listarTodo());
        return "Horario/ContentHorario :: h_medico";
    }

    @PostMapping("/guardar_horario_medico")
    public ResponseEntity<String> guardar_horario_medico(@Validated HorarioMedico horarioMedico) {

        if (horarioMedico.getIdHorarioMedico() == null) {
            horarioMedico.setFechaRegistroFichaa(new Date());
            horarioMedico.setEstado("A");
            horarioMedicoService.save(horarioMedico);
            return ResponseEntity.ok("1");
        }else{
            horarioMedico.setModificacion(new Date());
            horarioMedico.setEstado("A");
            horarioMedicoService.save(horarioMedico);
            return ResponseEntity.ok("2");
        }
    }
    
    @GetMapping(value = "/eliminar_horario_medico/{id}")
    @ResponseBody
    public void eliminar_horario_medico(@PathVariable(name = "id")Integer id){

        HorarioMedico horarioMedico = horarioMedicoService.findOne(id);
        horarioMedico.setEstado("X");
        horarioMedicoService.save(horarioMedico);
    }
}
