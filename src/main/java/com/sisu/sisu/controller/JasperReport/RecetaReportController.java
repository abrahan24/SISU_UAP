package com.sisu.sisu.controller.JasperReport;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sisu.sisu.Service.IPersonaService;
import com.sisu.sisu.Service.UtilidadesService.UtilidadesService;
import com.sisu.sisu.entitys.Persona;

@Controller
public class RecetaReportController {
    
    @Autowired
    private IPersonaService personaService;    

    @Autowired
    private UtilidadesService utilidadesService;

    @GetMapping("/Reporte")
    public ResponseEntity<ByteArrayResource> ReportePDF(Model model, HttpServletRequest request)
            throws NumberFormatException, Exception {

        Persona persona = personaService.findOne(2);
        String nombreArchivo = "RECIBO_RECETARIO.jrxml";
        
        
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("idPersona", persona.getIdPersona());

        ByteArrayOutputStream stream = utilidadesService.Exportar_Reporte(nombreArchivo);

        byte[] bytes = stream.toByteArray();

        ByteArrayResource resource = new ByteArrayResource(bytes);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "inline;filename=" + "Reporte PERSONA"
                                + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .contentLength(bytes.length)
                .body(resource);
    }
}
