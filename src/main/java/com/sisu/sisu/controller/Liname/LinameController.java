package com.sisu.sisu.controller.Liname;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sisu.sisu.Service.FarmaceuticaService;
import com.sisu.sisu.Service.ListaLinameService;
import com.sisu.sisu.Service.TipoUsoService;
import com.sisu.sisu.entitys.FormaFarmaceutica;
import com.sisu.sisu.entitys.ListaLiname;
import com.sisu.sisu.entitys.TipoUso;
import com.sisu.sisu.entitys.Usuario;



@Controller
public class LinameController {

    @Autowired
    private ListaLinameService listaLinameService;

    @Autowired
    private FarmaceuticaService farmaceuticaService;

    @Autowired
    private TipoUsoService tipoUsoService;

    @GetMapping(value = "/vista")
    public String vistaLiname(Model model) {

        model.addAttribute("listLiname", new ListaLiname());
        model.addAttribute("listLinames", listaLinameService.findAll());

        model.addAttribute("farmaceutica", new FormaFarmaceutica());
        model.addAttribute("farmaceuticas", farmaceuticaService.findAll());

        model.addAttribute("tipoUso", new TipoUso());
        model.addAttribute("tipoUsos", tipoUsoService.findAll()); 

       return "Liname";
    
    }

    //-------------------------------save---------------------------------

    @PostMapping(value = "/saveLiname") // Enviar datos de Registro a Lista
	public ResponseEntity<String> guaradarLinam(@Validated ListaLiname listLiname, RedirectAttributes flash,HttpServletRequest request,
    @RequestParam(name="farmaceutica",required = false)Integer idFormaFarmaceutica,
    @RequestParam(name="tipoUso",required = false)Integer idTipoUso
    ) { 

        if (listLiname.getIdLiname() == null) {
            if (listaLinameService.getLiname_codigo(listLiname.getCodigoLiname()) == null) {
                listLiname.setEstadoLiname("A");
                listLiname.setForma_farmaceutica(farmaceuticaService.findOne(idFormaFarmaceutica));
                listLiname.setTipo_uso(tipoUsoService.findOne(idTipoUso));
                listLiname.setRegistro(new Date());
                listaLinameService.save(listLiname);
                return ResponseEntity.ok("1");
            } else {
                return ResponseEntity.ok("3");
            }
        } else {
            listLiname.setModificacion(new Date());
            listLiname.setEstadoLiname("A");
            listLiname.setForma_farmaceutica(farmaceuticaService.findOne(idFormaFarmaceutica));
            listLiname.setTipo_uso(tipoUsoService.findOne(idTipoUso));
            listaLinameService.save(listLiname);
            return ResponseEntity.ok("2");
        }
	}

    //-------------------------------to list---------------------------------

       @GetMapping(value="/l-Liname")
    public String listaLiname(Model model, @Validated ListaLiname listLiname,HttpServletRequest request) {

        Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSession");
		if (usuario == null) {
			return "redirect:/";
		}

        model.addAttribute("listLiname", new ListaLiname());
        model.addAttribute("listLinames", listaLinameService.findAll());

        model.addAttribute("farmaceutica", new FormaFarmaceutica());
        model.addAttribute("farmaceuticas", farmaceuticaService.findAll());

        model.addAttribute("tipoUso", new TipoUso());
        model.addAttribute("tipoUsos", tipoUsoService.findAll()); 
       
        return "listas/Liname/ListaLiname";
    
    }


    //-------------------------------Delete---------------------------------
    @RequestMapping(value = "/eliminLiname/{idLiname}")
    @ResponseBody
    public void eliminarLiname(@PathVariable("idLiname")Integer idLiname){

        ListaLiname listLiname = listaLinameService.findOne(idLiname);
        listLiname.setEstadoLiname("X");
        listaLinameService.save(listLiname);
    }


    //-------------------------------Edit---------------------------------
    @RequestMapping(value = "/editLiname/{idLiname}")
    public String editLiname(@PathVariable("idLiname")Integer idLiname, Model model){

        ListaLiname listLiname = listaLinameService.findOne(idLiname);
        model.addAttribute("listLiname", listLiname);

        return "redirect:/l-Liname";
    }


    @RequestMapping(value = "/listLiname/{idLiname}")
    public String getContent1(@PathVariable(value = "idLiname") Integer idLiname, Model model,
    HttpServletRequest request) {

        model.addAttribute("listLiname", listaLinameService.findOne(idLiname));
        model.addAttribute("farmaceuticas", farmaceuticaService.findAll());
        model.addAttribute("tipoUsos", tipoUsoService.findAll()); 

        return "listas/Liname/contentLiname :: contentLiname";
    }


    @PostMapping(value = "/SaveLiname")
    public String GuaradrLiname(@ModelAttribute ListaLiname listLiname,
    @RequestParam(name="farmaceutica",required = false)Integer idFormaFarmaceutica,
    @RequestParam(name="tipoUso",required = false)Integer idTipoUso
    ) {

        listLiname.setEstadoLiname("A");
        listLiname.setForma_farmaceutica(farmaceuticaService.findOne(idFormaFarmaceutica));
        listLiname.setTipo_uso(tipoUsoService.findOne(idTipoUso));
        listaLinameService.save(listLiname);
       
        return "redirect:/l-Liname";
    }


}
