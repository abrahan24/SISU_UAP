package com.sisu.sisu.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sisu.sisu.Service.IDipService;
import com.sisu.sisu.Service.IGradoService;
import com.sisu.sisu.Service.IRolesService;
import com.sisu.sisu.Service.ITiposEstadoCivilService;
import com.sisu.sisu.Service.RecetaService;
import com.sisu.sisu.Service.UsrRolesService;
import com.sisu.sisu.Service.UsuarioService;
import com.sisu.sisu.entitys.Enlace;
import com.sisu.sisu.entitys.Roles;
import com.sisu.sisu.entitys.Usuario;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class login {

	@Autowired
	UsrRolesService usrRolesService;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	private IRolesService iRolesService;

	@Autowired
	private RecetaService recetaService;

	@Autowired
	private IGradoService gradoService;

	@Autowired
	private ITiposEstadoCivilService estadoCivilService;

	@Autowired
	private IDipService dipService;

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
			@RequestParam("clave") String clave, RedirectAttributes flash) {

		Usuario user = usuarioService.loguearse(usuario, clave);

		if (user != null) {
			if (user.getRoles().size() == 0) {
				String msn = "No tiene roles vigentes, comuniquese con el encargado de sistemas";
				model.addAttribute("msn", msn);
				return "redirect:/inicio";
			}
			// Obtener el conjunto de roles
			Set<Roles> rolesSet = user.getRoles();

			// Convertir el conjunto a una lista
			List<Roles> rolesList = new ArrayList<>(rolesSet);

			// Ordenar la lista
			Collections.sort(rolesList, Comparator.comparing(Roles::getRol));

			// Añadir la lista ordenada al modelo
			model.addAttribute("lRoles", rolesList);
			model.addAttribute("idUsuario", user.getIdUsuario());
			HttpSession sesion = request.getSession();
			sesion.setAttribute("usuarioSession", user);
			return "index/selecioneRoles";

		} else {
			String msn = "Error: Revise Usuario y Clave ";
			model.addAttribute("msn", msn);
			return "redirect:/inicio";
		}
	}

	@RequestMapping(value = "/seleccionarRoles", method = RequestMethod.POST)
	public String seleccionRoles(HttpServletRequest request, Model model,
			@RequestParam("idUsuario") Integer idUsuario,
			@RequestParam("idRol") Integer idRol) {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSession");
		if (usuario == null) {
			return "index/login";
		}
		Roles roles = iRolesService.findOne(idRol);
		HttpSession sesion = request.getSession(false);
		sesion.setAttribute("usuario", usuario);
		Set<Enlace> enlacesSet = roles.getEnlaces();
		List<Enlace> enlaceList = new ArrayList<>(enlacesSet);
		enlaceList.sort(Comparator.comparing(Enlace::getNombre_enlace));
		sesion.setAttribute("sessionlPadres", enlaceList);
		sesion.setAttribute("RolSession", roles);

		return "redirect:/inicio";
	}

	@GetMapping("/inicio")
	public String inicio(HttpServletRequest request, Model model) {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSession");
		Roles rol = (Roles) request.getSession().getAttribute("RolSession");
		if (usuario == null) {
			return "redirect:/";
		}

		if (rol.getRol().equals("FARMACIA")) {
			model.addAttribute("receteas_pendientes", recetaService.listaRecetasPendientes());
			model.addAttribute("grados", gradoService.findAll());
			model.addAttribute("estados_civil", estadoCivilService.findAll());
			model.addAttribute("dips", dipService.findAll());
			try {
				model.addAttribute("dipsJson", new ObjectMapper().writeValueAsString(dipService.findAll()));
				model.addAttribute("gradosJson", new ObjectMapper().writeValueAsString(gradoService.findAll()));
				model.addAttribute("estadosCivilJson", new ObjectMapper().writeValueAsString(estadoCivilService.findAll()));
			} catch (JsonProcessingException e) {
				model.addAttribute("dipsJson", "[]"); // En caso de error
				model.addAttribute("gradosJson", "[]"); // En caso de error
				model.addAttribute("estadosCivilJson", "[]"); // En caso de error
			}
		}

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
