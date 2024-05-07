package com.sisu.sisu.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.sisu.sisu.Dao.IAseguradoDao;
import com.sisu.sisu.Service.FichaService;
import com.sisu.sisu.Service.HistorialSeguroService;
import com.sisu.sisu.Service.IAseguradoService;
import com.sisu.sisu.Service.IPersonaService;
import com.sisu.sisu.entitys.Asegurado;
import com.sisu.sisu.entitys.Dip;
import com.sisu.sisu.entitys.EstadoSeguro;
import com.sisu.sisu.entitys.Ficha;
import com.sisu.sisu.entitys.GradoAcademico;
import com.sisu.sisu.entitys.HistorialSeguro;
import com.sisu.sisu.entitys.Institucion;
import com.sisu.sisu.entitys.Persona;
import com.sisu.sisu.entitys.TipoSeguro;
import com.sisu.sisu.entitys.TiposEstadoCivil;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class FichaSisuController {

	@Autowired
	private FichaService fichaService;

	@Autowired
	private HistorialSeguroService historialSeguroService;

	@Autowired
	private IPersonaService personaService;

	@Autowired
	private IAseguradoService aseguradoService;

	@RequestMapping(value = "universitario", method = RequestMethod.GET)
	public String obtenerDatosUniversitario(HttpServletRequest request, Model model,
			@RequestParam("codigoUniversitario") String ru) {

		System.out.println("--------------------MOSTRANDO DATOS UNIVERSITARIO------------------");
		System.out.println("EL RU DEL UNIVERSITARIO ES :" + ru);

		Map<String, Object> requests = new HashMap<String, Object>();

		try {

			requests.put("ru", ru);

			String url = "http://181.115.188.250:9993/v1/service/api/cee024514f4e4b1f970bfb2b6486b421";
			String key = "key 70c8b6fc339aa5e6312dd42edf0636558948bb6008f1a0f867885d5e60e26c57";

			HttpHeaders headers = new HttpHeaders();

			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("x-api-key", key);

			HttpEntity<HashMap> req = new HttpEntity(requests, headers);
			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, req, Map.class);

			model.addAttribute("activarCreacionFicha", false);

			if (resp.getBody().get("status").toString().equals("200")) {
				Map<String, Object> data = (Map) resp.getBody().get("data");

				model.addAttribute("nombreUniversitario", data.get("nombres").toString());
				model.addAttribute("ci", data.get("ci").toString());
				model.addAttribute("ru", data.get("ru").toString());
				model.addAttribute("apPaterno", data.get("apellido_paterno").toString());
				model.addAttribute("apMaterno", data.get("apellido_materno").toString());
				model.addAttribute("fechaNacimiento", data.get("fecha_nacimiento").toString());
				model.addAttribute("direccion", data.get("direccion").toString());
				model.addAttribute("correo", data.get("correo").toString());
				model.addAttribute("carrera", data.get("carrera").toString());
				model.addAttribute("celular", data.get("celular").toString());
				model.addAttribute("tipoSanguineo", data.get("tipo_sanguineo").toString());
				model.addAttribute("sexo", data.get("sexo").toString());
				model.addAttribute("estadoMatriculacion", data.get("estado_matriculacion").toString());
				System.out.println("EL NOMBRE DEL UNIVERSITARIO ES " + data.get("nombres").toString());
				// Otros atributos...

				Persona newUnipersona = personaService.findByCi(data.get("ci").toString());

				if (newUnipersona != null) {

					personaCreada = newUnipersona;
					System.out.println("------------ ESTE UNIVERSITARIO YA ESTÁ REGISTRADO EN LA BD -----------------");
					return "Client/vistaDatosUniversitario";

				} else {
					newUnipersona = new Persona();
					Dip dip = new Dip();
					GradoAcademico gradoAcademico = new GradoAcademico();
					TiposEstadoCivil tiposEstadoCivil = new TiposEstadoCivil();

					dip.setIdDip(8);
					gradoAcademico.setIdGradoAcademico(1);
					tiposEstadoCivil.setIdTipoEstadoCivil(1);

					newUnipersona.setEstado("RU");
					newUnipersona.setNombres(data.get("nombres").toString());
					newUnipersona.setApPaterno(data.get("apellido_paterno").toString());
					newUnipersona.setApMaterno(data.get("apellido_materno").toString());
					newUnipersona.setCi(data.get("ci").toString());
					newUnipersona.setDireccion(data.get("direccion").toString());
					newUnipersona.setCelular(Integer.parseInt(data.get("celular").toString()));
					newUnipersona.setSexo(data.get("sexo").toString());
					newUnipersona.setDip(dip);
					newUnipersona.setGrado_academico(gradoAcademico);
					newUnipersona.setTipos_estado_civil(tiposEstadoCivil);
					newUnipersona.setFecha_nac(LocalDate.parse(data.get("fecha_nacimiento").toString()));

					personaService.save(newUnipersona);

					personaCreada = newUnipersona;

					System.out.println("/--------------------------------------------------------/");
					System.out.println("¡guardo! UNIVERISTARIO registrado en la tabla persona  ¡guardo!");
					System.out.println("/--------------------------------------------------------/");

				}

				Asegurado codigoAseguradoUniExistente = aseguradoService
						.findAseguradoByPersonaId(personaCreada.getIdPersona());

				if (codigoAseguradoUniExistente != null) {

					codigoAseguradoUniCreado = codigoAseguradoUniExistente;

					System.out.println(
							"------------- ESTE UNIVERSITARIO YA TIENE UN CODIGO ASEGURADO EN LA BD --------------------------");

				} else {
					String codigoAsegurado = generateCodigoAsegurado(newUnipersona);
					Asegurado asegurado = new Asegurado();

					// Después de guardar el asegurado

					asegurado.setCodigoAsegurado(codigoAsegurado);
					asegurado.setPersona(newUnipersona);
					asegurado.setEstado("A");
					aseguradoService.save(asegurado);

					codigoAseguradoUniCreado = asegurado;

					System.out.println("/------------------------------------------------/");
					System.out.println("SE GENERO EL CODIGO ASEGURADO PARA: " + newUnipersona.getNombres());
					System.out.println("/------------------------------------------------/");

					EstadoSeguro estadoSeguro = new EstadoSeguro();
					Institucion institucion = new Institucion();
					TipoSeguro tipoSeguro = new TipoSeguro();

					estadoSeguro.setIdEstadoSeguro(1);
					institucion.setIdInstitucion(1);
					tipoSeguro.setIdTipoSeguro(1);

					HistorialSeguro historialSeguro = new HistorialSeguro();
					historialSeguro.setCodigoSeguroPrincipal(codigoAsegurado);
					historialSeguro.setEstado("A"); // (o el estado que desees)
					historialSeguro.setFechaAlta(new Date());
					historialSeguro.setFechaBaja(new Date());
					historialSeguro.setTitularHS(true);
					historialSeguro.setAsegurado(asegurado);
					historialSeguro.setEstado_seguro(estadoSeguro);
					historialSeguro.setInstitucion(institucion);
					historialSeguro.setTipo_seguro(tipoSeguro);
					historialSeguroService.save(historialSeguro);

					return "Client/vistaDatosUniversitario";
				}

			}
			return "Client/inicioCliente";

		} catch (Exception e) {
			e.printStackTrace();
			String msn = "Error: Revise su usuario y contraseña ";
			model.addAttribute("msn", msn);
			System.out.println("hola-------------------------------------");

			return "index/index";
		}
	}

	private Persona personaCreada;
	private Asegurado codigoAseguradoUniCreado;

	@RequestMapping(value = "/generarFicha", method = RequestMethod.POST)
	public String generarFicha(Model model) {

		Asegurado asegurado = aseguradoService.findAseguradoByPersonaId(personaCreada.getIdPersona());

		if (codigoAseguradoUniCreado != null) {
			Ficha existeFicha = fichaService.findFichaByAseguradoId(codigoAseguradoUniCreado.getIdAsegurado());

			if (existeFicha != null) {
				System.out.println("YA TIENES UNA FICHA PARIENTE");
			} else {
				Ficha ficha = new Ficha();
				ficha.setEstado("A");
				ficha.setFechaRegistroFichaa(new Date());
				ficha.setAsegurado(asegurado);
				fichaService.save(ficha);
			}
			return "redirect:/inicioCliente";
		} else {
			System.out.println("NO EN CUNATRA CODIGO UNIVERSITARIO ASEGURADO");
			return "redirect:/inicioCliente";
		}

	}

	private String generateCodigoAsegurado(Persona persona) {
		String nombre = persona.getNombres();
		String apPaterno = persona.getApPaterno();
		String apMaterno = persona.getApMaterno();
		String ci = persona.getCi();

		// Obtener la primera letra de cada palabra y el CI
		String codigoAsegurado = String.valueOf(nombre.charAt(0)) +
				String.valueOf(apPaterno.charAt(0)) +
				String.valueOf(apMaterno.charAt(0)) +
				ci;

		return codigoAsegurado;
	}

	/*
	 * -------------------------------- DOCENTE
	 * ---------------------------------------------------------
	 */

	@RequestMapping(value = "docente", method = RequestMethod.GET)
	public String docente(HttpServletRequest request, Model model,
			@RequestParam("codigoDocente") String rd) {

		Map<String, Object> request1 = new HashMap<>();

		try {
			System.out.println("el codigo docente es" + rd);

			request1.put("rd", rd);

			String url = "http://181.115.188.250:9993/v1/service/api/ae7ce0054d4c4f38a4a92bf1c0422b55";
			String key = "key 70c8b6fc339aa5e6312dd42edf0636558948bb6008f1a0f867885d5e60e26c57";

			HttpHeaders headers = new HttpHeaders();

			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("x-api-key", key);

			HttpEntity<Map<String, Object>> req = new HttpEntity<>(request1, headers);
			RestTemplate restTemplate = new RestTemplate();

			ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, req, Map.class);
			System.out.println(
					"---------------" + resp.getBody().get("status").toString() + "--------------------------");

			if (resp.getBody().get("status").toString().equals("200")) {
				System.out.println("----------------------------------SS--------");

				Map<String, Object> data = (Map) resp.getBody().get("data");

				System.out.println("------------RD: " + rd + "---------");
				System.out.println("------------------------------------------");
				System.out.println("EL NOMBRE DEL DOCENTE ES " + data.get("nombres").toString());
				System.out.println("-----------------DOCENTE------------------");

				String DatosDocente = data.get("nombres").toString();

				model.addAttribute("DatosDocente", DatosDocente);

				model.addAttribute("apellidoPaterno", data.get("apellido_paterno").toString());
				model.addAttribute("apellidoMaterno", data.get("apellido_materno").toString());
				model.addAttribute("ci", data.get("ci").toString());
				model.addAttribute("fechaNacimiento", data.get("fecha_nacimiento").toString());
				model.addAttribute("titulo", data.get("titulo").toString());
				model.addAttribute("gradoAcademico", data.get("grado_academico").toString());
				model.addAttribute("rd", data.get("rd").toString());
				model.addAttribute("tipoSanguineoD", data.get("tipo_sanguineo").toString());
				model.addAttribute("sexoD", data.get("sexo").toString());
				model.addAttribute("celularD", data.get("celular").toString());
				model.addAttribute("direccionD", data.get("direccion").toString());
				model.addAttribute("activo", data.get("activo").toString());
				System.out.println("---------------------------------------------------------------------------");
				System.out.println("EL NOMBRE DEL DOCENTE ES: " + data.get("nombres").toString());
				System.out.println("---------------------------------------------------------------------------");

				Persona existePersonaD = personaService.findByCi(data.get("ci").toString());

				if (existePersonaD != null) {

					personaDocenteCreado = existePersonaD;
					System.out.println(
							" ------------------ ESTE DOCENTE YA ESTÁ REGISTRADO EN LA BASE DE DATOS -----------------");
				} else {

					System.out.println("--------------------------------------------------------");
					System.out.println("PREGUNTO PREGUNTO DOCENTE");
					System.out.println("--------------------------------------------------------");

					existePersonaD = new Persona();

					Dip dip = new Dip();
					GradoAcademico gradoAcademico = new GradoAcademico();
					TiposEstadoCivil tiposEstadoCivil = new TiposEstadoCivil();

					dip.setIdDip(8);
					gradoAcademico.setIdGradoAcademico(1);
					tiposEstadoCivil.setIdTipoEstadoCivil(1);

					existePersonaD.setEstado("RD");
					existePersonaD.setNombres(data.get("nombres").toString());
					existePersonaD.setApPaterno(data.get("apellido_paterno").toString());
					existePersonaD.setApMaterno(data.get("apellido_materno").toString());
					existePersonaD.setCi(data.get("ci").toString());
					existePersonaD.setDireccion(data.get("direccion").toString());
					existePersonaD.setCelular(Integer.parseInt(data.get("celular").toString()));
					existePersonaD.setSexo(data.get("sexo").toString());
					existePersonaD.setFecha_nac(LocalDate.parse(data.get("fecha_nacimiento").toString()));
					personaService.save(existePersonaD);

					personaDocenteCreado = existePersonaD;

					System.out.println("/--------------------------------------------------------/");
					System.out.println("¡guardo! DOCENTE registrado en la tabla persona ¡guardo!");
					System.out.println("/--------------------------------------------------------/");
				}

				Asegurado codigoAseguradoDocExiste = aseguradoService
						.findAseguradoByPersonaId(existePersonaD.getIdPersona());

				if (codigoAseguradoDocExiste != null) {

					codigoAseguradoDocenteCreado = codigoAseguradoDocExiste;

					System.out.println(
							" -------------- ESTE DOCENTE YA TIENE UN CODIGO ASEGURADO EN LA BASE DE DATOS -----------------");
				} else {
					String codigoAsegurado = generateCodigoAsegurado(existePersonaD);

					Asegurado aseguradoD = new Asegurado();
					aseguradoD.setCodigoAsegurado(codigoAsegurado);
					aseguradoD.setPersona(existePersonaD);
					aseguradoD.setEstado("A");
					aseguradoService.save(aseguradoD);

					codigoAseguradoDocenteCreado = aseguradoD;

					System.out.println("/------------------------------------------------/");
					System.out.println("SE GENERO EL CODIGO ASEGURADO PARA: " + existePersonaD.getNombres());
					System.out.println("/------------------------------------------------/");

					HistorialSeguro historialSeguro = new HistorialSeguro();
					historialSeguro.setCodigoSeguroPrincipal(codigoAsegurado);
					historialSeguro.setEstado("A"); // (o el estado que desees)
					historialSeguro.setFechaAlta(new Date());
					historialSeguro.setFechaBaja(new Date());
					historialSeguro.setTitularHS(true);
					historialSeguro.setAsegurado(aseguradoD);
					historialSeguroService.save(historialSeguro);
				}
			}
			return "Client/vistaDatosDocente";
		} catch (Exception e) {
			e.printStackTrace();
			String msn = "Error: Revise su usuario y contraseña ";
			model.addAttribute("msn", msn);
			System.out.println("hola-------------------------------------");

			return "index/index";
		}
	}

	private Persona personaDocenteCreado;
	private Asegurado codigoAseguradoDocenteCreado;

	@RequestMapping(value = "/generarFichaD", method = RequestMethod.POST)
	public String generarFichaD(Model model) {

		Asegurado asegurado = aseguradoService.findAseguradoByPersonaId(personaDocenteCreado.getIdPersona());

		Ficha existeFicha = fichaService.findFichaByAseguradoId(codigoAseguradoDocenteCreado.getIdAsegurado());

		if (existeFicha != null) {
			System.out.println("ESTE DOCENTE YA TIENES UNA FICHA PARIENTE");
		} else {
			Ficha ficha = new Ficha();
			ficha.setEstado("A");
			ficha.setFechaRegistroFichaa(new Date());
			ficha.setAsegurado(asegurado);
			fichaService.save(ficha);
			System.out.println("LA FICHA PARA ESTE DOCENTE SE HA CREADO");
		}

		return "redirect:/inicioCliente";
	}

	/*
	 * -----------------------------------------------------------------------------
	 * ---------------
	 */

	@RequestMapping(value = "/administrativo", method = RequestMethod.GET)
	public String administrativo(HttpServletRequest request, Model model,
			@RequestParam("codigoAdministrativo") String codigoAdministrativo) {
		Map<String, Object> request1 = new HashMap<>();
		try {
			request1.put("usuario", codigoAdministrativo);

			String url = "http://virtual.uap.edu.bo:7174/api/londraPost/v1/personaLondra/obtenerDatos";

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<Map<String, Object>> req = new HttpEntity<>(request1, headers);

			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<Map> resp = restTemplate.exchange(url, HttpMethod.POST, req, Map.class);

			System.out.println("7777777777777777777777777777777777777+2");

			if (resp.getBody().get("status").toString().equals("200")) {
				System.out.println("hola-------------------------------------kiwi1");
				Map<String, Object> data = (Map) resp.getBody();
				System.out.println("hola-------------------------------------kiwi2");

				model.addAttribute("nombres", data.get("per_nombres").toString());
				model.addAttribute("apPaterno", data.get("per_ap_paterno").toString());
				model.addAttribute("apMaterno", data.get("per_ap_materno").toString());
				model.addAttribute("CA", data.get("per_id").toString());
				model.addAttribute("ci", data.get("per_num_doc").toString());
				model.addAttribute("fechaNacimientoA", data.get("fecha_nac").toString());
				model.addAttribute("sexoA", data.get("per_sexo").toString());
				model.addAttribute("gmailA", data.get("perd_email_personal").toString());
				model.addAttribute("descripcionA", data.get("p_descripcion").toString());
				model.addAttribute("descripcionA2", data.get("cp_descripcion").toString());
				model.addAttribute("nivel", data.get("nivelInstruccion").toString());

				Persona existPersonaA = personaService.findByCi(data.get("per_num_doc").toString());

				if (existPersonaA != null) {
					personaACreada = existPersonaA;
					System.out.println(
							"----------------- ESTE ADMINISTRATIVO YA ESTÁ REGISTRADO EN LA BASE DE DATOS ----------------------");

				} else {
					System.out.println("--------------------------------------------------------");
					System.out.println("PREGUNTO PREGUNTO ADMINISTRATIVO");
					System.out.println("--------------------------------------------------------");

					existPersonaA = new Persona();

					Dip dip = new Dip();
					GradoAcademico gradoAcademico = new GradoAcademico();
					TiposEstadoCivil tiposEstadoCivil = new TiposEstadoCivil();

					dip.setIdDip(10);
					gradoAcademico.setIdGradoAcademico(1);
					tiposEstadoCivil.setIdTipoEstadoCivil(1);

					existPersonaA.setEstado("RA");
					existPersonaA.setNombres(data.get("per_nombres").toString());
					existPersonaA.setApPaterno(data.get("per_ap_paterno").toString());
					existPersonaA.setApMaterno(data.get("per_ap_materno").toString());
					existPersonaA.setCi(data.get("per_num_doc").toString());
					existPersonaA.setSexo(data.get("per_sexo").toString());
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate fechaNacimiento = LocalDate.parse(data.get("fecha_nac").toString(), formatter);
					existPersonaA.setFecha_nac(fechaNacimiento);
					personaService.save(existPersonaA);

					personaACreada = existPersonaA;

					System.out.println("/--------------------------------------------------------/");
					System.out.println("PERSONA ADMINISTRATIVA GUARDADA");
					System.out.println("/--------------------------------------------------------/");
				}

				Asegurado codigoAseguradoAExiste = aseguradoService
						.findAseguradoByPersonaId(existPersonaA.getIdPersona());

				if (codigoAseguradoAExiste != null) {

					codigoAseguradoAdCreado = codigoAseguradoAExiste;
					System.out.println(
							" ----------------------- ESTE ADMINISTRATIVO YA TIENE UN CODIGO ASEGURADO EN LA BASE DE DATOS ---------------------------");

				} else {
					String codigoAsegurado = generateCodigoAsegurado(existPersonaA);

					Asegurado aseguradoA = new Asegurado();
					aseguradoA.setCodigoAsegurado(codigoAsegurado);
					aseguradoA.setPersona(existPersonaA);
					aseguradoA.setEstado("A");
					aseguradoService.save(aseguradoA);

					codigoAseguradoAdCreado = aseguradoA;

					System.out.println("/------------------------------------------------/");
					System.out.println("SE GENERO EL CODIGO ASEGURADO PARA: " + existPersonaA.getNombres());
					System.out.println("/------------------------------------------------/");

					HistorialSeguro historialSeguro = new HistorialSeguro();
					historialSeguro.setCodigoSeguroPrincipal(codigoAsegurado);
					historialSeguro.setEstado("A"); // (o el estado que desees)
					historialSeguro.setFechaAlta(new Date());
					historialSeguro.setFechaBaja(new Date());
					historialSeguro.setTitularHS(true);
					historialSeguro.setAsegurado(aseguradoA);
					historialSeguroService.save(historialSeguro);
				}

			}
			System.out.println("hola-------------------------------------kiwi3");
			return "Client/vistaDatosAdministrativo";
		} catch (Exception e) {
			e.printStackTrace();
			String msn = "Error: Revise su usuario y contraseña ";
			model.addAttribute("msn", msn);
			System.out.println("hola-------------------------------------");

			return "index/index";
		}
	}

	private Persona personaACreada;
	private Asegurado codigoAseguradoAdCreado;

	@RequestMapping(value = "/generarFichaA", method = RequestMethod.POST)
	public String generarFichaA(Model model) {

		Asegurado asegurado = aseguradoService.findAseguradoByPersonaId(personaACreada.getIdPersona());

		Ficha existeFicha = fichaService.findFichaByAseguradoId(codigoAseguradoAdCreado.getIdAsegurado());
		LocalDate fechaRegistroFicha = null;
		if (existeFicha != null) {
			fechaRegistroFicha = existeFicha.getFechaRegistroFichaa().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			System.out.println("ESTE ADMINISTRATIVO YA TIENE UNA FICHA");
			// Aquí puedes agregar cualquier acción adicional si la ficha ya existe
		} else {
			Ficha ficha = new Ficha();
			ficha.setEstado("A");
			ficha.setFechaRegistroFichaa(new Date());
			ficha.setAsegurado(asegurado);

			// Verificar si la fecha de registro de la ficha es igual a la fecha actual
			LocalDate fechaActual = LocalDate.now();
			fechaRegistroFicha = ficha.getFechaRegistroFichaa().toInstant().atZone(ZoneId.systemDefault())
					.toLocalDate();

			if (fechaRegistroFicha.equals(fechaActual)) {
				System.out.println(
						"La fecha de registro de la ficha es igual a la fecha actual. No se guarda la ficha.");
				
			} else {
				fichaService.save(ficha);
				System.out.println("LA FICHA PARA ESTE ADMINISTRATIVO SE HA CREADO");
				
			}
		}

		return "redirect:/inicioCliente";
	}

	@RequestMapping(value = "particular", method = RequestMethod.GET)
	public String particular(HttpServletRequest request, Model model) {
		System.out.print("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAA++PARTICULAR");
		return "index/index";
	}

}