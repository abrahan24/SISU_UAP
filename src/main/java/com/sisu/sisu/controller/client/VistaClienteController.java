package com.sisu.sisu.controller.client;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class VistaClienteController {
    
    @RequestMapping(value = "/datosCliente", method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {
		
		System.out.println("11111111111111111111111111111111111111111111");
		return "Client/vistaDatosCliente";
	}

	@RequestMapping(value = "/inicioCliente", method = {RequestMethod.GET, RequestMethod.POST})
	public String homecliente(Model model, HttpServletRequest request) {
		
		System.out.println("SE INGRESA FICHA CONTROLLER!!!!!");

		return "Client/inicioCliente";
	}

	// @RequestMapping(value = "/inicioClienteCancel", method = RequestMethod.POST)
	// public String homeCancelCliente(Model model, HttpServletRequest request) {
		
	// 	System.out.println("11111111111111111111111111111111111111111111+33");

	// 	return "Client/inicioCliente";
	// }

	@RequestMapping(value = "/inicioCaja", method = RequestMethod.GET)
	public String homeCaja(Model model, HttpServletRequest request) {
		
		System.out.println("11111111111111111111111111111111111111111111");
		return "client/inicioCaja";
	}

    @RequestMapping(value = "/ticket", method = RequestMethod.GET)
	public String vistaFicha(Model model, HttpServletRequest request) {
		
		System.out.println("11111111111111111111111111111111111111111111");
		return "Client/vistaFicha";
	}
}
