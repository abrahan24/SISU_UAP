package com.sisu.sisu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sisu.sisu.Service.IRolesService;
import com.sisu.sisu.Service.UsrRolesService;
import com.sisu.sisu.Service.UsuarioService;
import com.sisu.sisu.entitys.Roles;
import com.sisu.sisu.entitys.Usuario;

@Controller
public class login {

	@Autowired
	UsrRolesService usrRolesService;
	
	@Autowired
	UsuarioService usuarioService;

	@Autowired
	private IRolesService iRolesService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String iniciosesion(Model model) {

		return "index/login";
	}

	@RequestMapping(value = "/loginK", method = RequestMethod.GET)
	public String Ficha(Model model, HttpServletRequest request) {

		System.out.println("11111111111111111111111111111111111111111111");
		return "index/loginK";
	}

	@RequestMapping(value = "usuarioContrasena", method = RequestMethod.POST)
	public String selecionRoles(HttpServletRequest request, Model model, @RequestParam("usuario") String usuario,
			@RequestParam("clave") String clave , RedirectAttributes flash) {
		
		Usuario user = usuarioService.loguearse(usuario, clave);

		if (user != null) {
			if (user.getRoles().size() == 0) {
				String msn = "No tiene roles vigentes, comuniquese con el encargado de sistemas";
				model.addAttribute("msn", msn);
				return "index/login";
			}
			model.addAttribute("lRoles", user.getRoles());
			model.addAttribute("idUsuario", user.getIdUsuario());
			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuarioSession", user);
			return "index/selecioneRoles";

		} else {
			String msn = "Error: Revise Usuario y Clave ";
			model.addAttribute("msn", msn);
			return "index/login";
		}
	}
	
	@RequestMapping(value = "seleccionarRoles", method = RequestMethod.POST)
	public String seleccionRoles(HttpServletRequest request, Model model, @RequestParam("idRol") Integer idRol) {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSession");
		if (usuario == null) {
			return "index/login";
		}
		Roles roles = iRolesService.findOne(idRol);
		HttpSession sesion = request.getSession(false);
		sesion.setAttribute("usuario", usuario);
		sesion.setAttribute("sessionlPadres", roles.getEnlaces());
		sesion.setAttribute("RolSession", roles);

		return "index/inicio";
	}
	
	@RequestMapping(value = "/cerrar.da", method = RequestMethod.GET)
	public String Cerrar(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}

}
