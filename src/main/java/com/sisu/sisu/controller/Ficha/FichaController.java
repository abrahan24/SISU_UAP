package com.sisu.sisu.controller.Ficha;

import java.util.Date;
import java.util.List;

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

import com.sisu.sisu.Dao.PersonalMedicoDao;
import com.sisu.sisu.Dao.PersonalMedicoFichaDao;
import com.sisu.sisu.Service.FichaService;
import com.sisu.sisu.Service.HistorialSeguroService;
import com.sisu.sisu.Service.IAseguradoService;
import com.sisu.sisu.Service.IPersonaService;
import com.sisu.sisu.Service.PersonalMedicoService;
import com.sisu.sisu.entitys.Asegurado;
import com.sisu.sisu.entitys.Ficha;
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

    @RequestMapping(value = "/vistaF", method = RequestMethod.GET)
	public String vistaFicha(Model model ) { 
        
        model.addAttribute("ficha", new Ficha());
        model.addAttribute("fichas", fichaService.findAll());

        model.addAttribute("asegurado", new Asegurado());
        model.addAttribute("asegurados", aseguradoService.findAll());

        model.addAttribute("persona", new Persona());
        model.addAttribute("personas", personaService.findAll());

		return "Fichas/listaFichaP";
	}

     //-------------------------------to list---------------------------------

     @GetMapping (value = "/listaFichasGeneral")
    public String listaFichasGeneral(Model model, @Validated Ficha ficha, HttpServletRequest request) {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSession");
		
		if (usuario == null) {
			
			return "index/login";
			
		}

        Date fechaActualD = new Date(); 

        model.addAttribute("ficha", new Ficha());
        model.addAttribute("fichas", fichaService.listaFichasFechaActual(fechaActualD));
        model.addAttribute("p_medicos", personalMedicoService.listarTodo());    

        model.addAttribute("personalMedico", new PersonalMedico());
        return "Fichas/listaFichaGeneral";
    }

     @PostMapping("/asignar_medico")
     public ResponseEntity<String> postMethodName(@RequestParam(name = "idFicha")Integer idFicha,
      @RequestParam(name = "idPersonalMedico")Integer idPersonalMedico ) {
        
        Ficha ficha = fichaService.findOne(idFicha);
        ficha.setEstado("AA");
        fichaService.save(ficha);
        PersonalMedicoFicha personalMedicoFicha = new PersonalMedicoFicha();
        personalMedicoFicha.setFicha(ficha);
        personalMedicoFicha.setPersonal_medico(personalMedicoService.buscarId(idPersonalMedico));
        personalMedicoFicha.setRegistro(new Date());
        personalMedicoFichaDao.save(personalMedicoFicha);

        return ResponseEntity.ok("1");
     }
     

    @GetMapping (value = "/fichasAsegurado/{id_usuario}")
    public String generarFicha( @PathVariable("id_usuario") int id_usuario,Model model, @Validated Ficha ficha) {

        List<PersonalMedicoFicha> listFichas = personalMedicoFichaDao.listaFichasAsignadasPersonalMedico(id_usuario);
        System.out.println(listFichas.size());
        System.out.println(id_usuario);
        model.addAttribute("fichas", listFichas);

        
        

        return "Fichas/listaFichaP";
    }
}
