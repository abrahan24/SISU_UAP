package com.sisu.sisu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminControllers {


	@GetMapping("/admin")
	public String vista(Model model, HttpServletRequest request) {
		System.out.println("GOLLLLLLLLLLLL++++1");
	
		if (!request.getRequestURI().contains("/admin")) {
			// Si la URL no contiene "/admin", redirige a la página de error
			return "redirect:/pageError";
		}
	
		if (request.getSession().getAttribute("usuario") == null) {
			System.out.println("GOLLLLLLLLLLLL++++2");    
			return "index/login";
		} else {
			return "redirect:/pageError";
		}
	}
	@GetMapping("/inicioSapo")
	public String inicio(Model model, HttpServletRequest request) {
		
			return "index/inicio";
		
	}
	

    
}
