package com.sisu.sisu.controller.Ficha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sisu.sisu.Service.FichaService;
import com.sisu.sisu.Service.HistoriaClinicaService;
import com.sisu.sisu.Service.HistorialSeguroService;
import com.sisu.sisu.Service.IAseguradoService;
import com.sisu.sisu.entitys.Ficha;
import com.sisu.sisu.entitys.HistoriaClinica;
import com.sisu.sisu.entitys.HistorialSeguro;

@Controller
public class HistorialSeguroController {

    @Autowired
    private HistorialSeguroService historialSeguroService;

    @Autowired
    private HistoriaClinicaService historiaClinicaService;
    
    @Autowired
    private FichaService fichaService;

    @Autowired
    private IAseguradoService aseguradoService;

    @GetMapping(value = "/vistaHistorialSeguro/{idAsegurado}/{idFicha}")
    public String vistaHistorial(@PathVariable(value = "idFicha") Integer idFicha, Model model, @PathVariable(value = "idAsegurado")Integer idAsegurado) {

        
        Ficha ficha = fichaService.findOne(idFicha);
        if (ficha != null) {
            ficha.setEstado("R");
        fichaService.save(ficha);
        }
        
       HistorialSeguro historialSeguro = historialSeguroService.getHistorial_por_id_seguro(idFicha);
        historialSeguro = historialSeguroService.getHistorial_por_id_seguro(idFicha);
        
        model.addAttribute("historiaClinica", new HistoriaClinica());
        model.addAttribute("asegurado", aseguradoService.findOne(idAsegurado));
        model.addAttribute("historial_seguro", historialSeguro);
    
        System.out.println("NOMBRE: " + historialSeguro.getAsegurado().getPersona().getNombres());
        System.out.println("IDFicha: " + idFicha);
    
        // Devolver la vista correspondiente
        return "formularios/formHistoriaClinica";
    }
}
