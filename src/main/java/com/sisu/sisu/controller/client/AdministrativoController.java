package com.sisu.sisu.controller.client;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.sisu.sisu.Service.IPersonaService;
import com.sisu.sisu.entitys.Persona;

@Controller
public class AdministrativoController {

    @Autowired
    private IPersonaService personaService;

    @RequestMapping(value = "/administrativo333", method = RequestMethod.POST)
	public String administrativo(HttpServletRequest request,Model model,@RequestParam("codigoAdministrativo") String codigoAdministrativo) {
		Map<String,Object> request1=new HashMap<String,Object>();
		try {
			
			
			request1.put("usuario", codigoAdministrativo);
			
			String url="https://digital.uap.edu.bo/api/londra/api/londraPost/v1/personaLondra/obtenerDatos";
			
			HttpHeaders headers=new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<HashMap> req = new HttpEntity(request1, headers);
			RestTemplate restTemplate = new RestTemplate();
		   	ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, req, Map.class);
			   
			System.out.println("7777777777777777777777777777777777777+2");
			
			if (resp.getBody().get("status").toString().equals("200")) {

				Map<String, Object> data = (Map) resp.getBody();

				String ci=data.get("per_num_doc").toString();
                String nombre=data.get("per_nombres").toString();
                String ap_paterno=data.get("per_ap_paterno").toString();
                String ap_materno=data.get("per_ap_materno").toString();
                String fecha_naci=data.get("fecha_nac").toString();
                String celular=data.get("perd_celular").toString();
				String descripcion=data.get("p_descripcion").toString();

                // Persona persona = new Persona();
                // persona.setNombres(data.get("per_nombres").toString());
                // persona.setCi(data.get("per_num_doc").toString());
                // persona.setApPaterno(data.get("per_ap_paterno").toString());
                // persona.setApMaterno(data.get("per_ap_materno").toString());

                // model.addAttribute("personaAdministrativo", persona);
				// model.addAttribute("personaUniversitaria", persona);
                // model.addAttribute("personasAdministrativos", personaService.findAll());

				System.out.println("-----------------ADMINISTRATIVO------------------");
				System.out.println("-----------------------CA: "+codigoAdministrativo+"-----------------");
				System.out.println("---------------------------CI: "+ci+"---------------");
                System.out.println("---------------------------"+nombre+"---------------");
                System.out.println("---------------------------"+fecha_naci+"---------------");
				System.out.println("---------------------------"+ap_paterno+"---------------");
				System.out.println("---------------------------"+ap_materno+"---------------");
				System.out.println("---------------------------"+celular+"---------------");
			}
			return "Client/vistaDatosAdministrativo";
		} catch (Exception e) {

			String msn = "Error: Revise su usuario y contraseña ";
			model.addAttribute("msn", msn);
			System.out.println("hola-------------------------------------");
			return "index/index";
		}
	}

//     @PostMapping(value = "/saveAdministrativo")
//     public String guardarAdmins(Model model, @ModelAttribute Persona persona) {
//     try {
        
// 		persona.setEstado("R");
//        	personaService.save(persona);
//         return "redirect:/ticket";

//     } catch (Exception e) { 
//         // Manejo de errores si ocurre alguna excepción al guardar la persona
//         String mensajeError = "Error al guardar la persona: " + e.getMessage();
//         model.addAttribute("mensajeError", mensajeError);

//         return "error"; // Puedes redirigir a una página de error
//     }
//    }
}
