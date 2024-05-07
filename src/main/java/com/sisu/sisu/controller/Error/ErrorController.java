package com.sisu.sisu.controller.Error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {

     @RequestMapping(value = "/pageError", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		
		System.out.println("11111111111111111111111111111111111111111111");

		return "Errores/error";
	}
    
}
