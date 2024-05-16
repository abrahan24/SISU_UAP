package com.sisu.sisu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sisu.sisu.Service.IMenuService;
import com.sisu.sisu.Service.UsrRolesService;
import com.sisu.sisu.Service.UsuarioService;
import com.sisu.sisu.entitys.Menu;
import com.sisu.sisu.entitys.UsrRoles;
import com.sisu.sisu.entitys.Usuario;

@Controller
public class login {

	@Autowired
	UsrRolesService usrRolesService;
	
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	IMenuService menuService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String iniciosesion(Model model) {

		return "index/login";
	}

	

	@RequestMapping(value = "/loginK", method = RequestMethod.GET)
	public String Ficha(Model model, HttpServletRequest request) {

		System.out.println("11111111111111111111111111111111111111111111");
		return "index/loginK";
	}

	@RequestMapping(value = "roles", method = RequestMethod.GET)
	public String roles(Model model, HttpServletRequest request) {
		
		
		UsrRoles usr=new UsrRoles();
		
		List<UsrRoles>listadeUsuarios=usrRolesService.findAll();
		
		System.out.println("hola");

		model.addAttribute("listadeUsuarios", listadeUsuarios);
		return "formularios/formulario";
	}
	
	
	//NUEVOS CONTROLADORES
	
	@RequestMapping(value = "usuarioContrasena", method = RequestMethod.POST)
	public String selecionRoles(HttpServletRequest request, Model model,HttpServletResponse response, @RequestParam("usuario") String usuario,
			@RequestParam("clave") String clave) {
		
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	    response.setHeader("Pragma", "no-cache");
	    response.setDateHeader("Expires", 0);
		
		System.out.println("---" + usuario + "---" + clave + "---");

		Usuario user = usuarioService.loguearse(usuario, clave);

		if (user != null) {
			List<UsrRoles> lRolesUsr = usrRolesService.listRolesUsuario(user);
			System.out.println("-------------------------------------------------");
			System.out.println("rolesList " + lRolesUsr.size());
			System.out.println("-------------------------------------------------");

			if (lRolesUsr.size() == 0) {
				String msn = "No tiene roles vigentes, comuniquese con el encargado de sistemas";
				model.addAttribute("msn", msn);
				return "index/login";

			}
			
			model.addAttribute("lRoles", lRolesUsr);

			HttpSession sesion = request.getSession();

			sesion.setAttribute("sessionlRoles", lRolesUsr);
			sesion.setAttribute("usuarioSession", user);

			System.out.println("TIENE ROLES HABILITADOS-------------------------------------");
			return "index/selecioneRoles";
			// return "uap/da/sistemada/vistas/login/mostrarRoles";

		} else {

			String msn = "Error: Revise Usuario y Clave ";
			model.addAttribute("msn", msn);
			System.out.println("hola-------------------------------------");

			return "index/login";
		}

	}
	
	
	@RequestMapping(value = "seleccionarRoles", method = RequestMethod.POST)
	public String seleccionRoles(HttpServletRequest request, Model model, @RequestParam("idUsrRol") Integer idUsrRol) {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioSession");
		
		if (usuario == null) {
			
			return "index/login";
			
		}

		System.out.println("Rol-- " + idUsrRol);

		UsrRoles usrRol = new UsrRoles();

		usrRol = usrRolesService.findByIdUsrRol(idUsrRol);
		System.out.println("USUARIO ROL" + usrRol.getIdUsrRol());


		List<Menu> lEnlaces = menuService.findByIdRol(usrRol.getIdRol());
		System.out.println("tama " + lEnlaces.size());

		List<Menu> lHijos = menuService.findByIdRol(usrRol.getIdRol());

		model.addAttribute("Padres", lEnlaces);
		model.addAttribute("Hijos", lHijos);
		model.addAttribute("usuario", usuario);

		HttpSession sesion = request.getSession(true);
		sesion.setAttribute("usuario", usuario);
		sesion.setAttribute("sessionlPadres", lHijos);
		sesion.setAttribute("usrRolSession", usrRol);

		//return "formularios/Contenido";
		return "index/inicio";
	}
	
	

	@RequestMapping(value = "/cerrar.da", method = RequestMethod.GET)
	public String Cerrar(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();

			System.out.print(request.getSession().getAttribute("estado_user"));

		}
		return "redirect:/";
		
	}

	
	
}
