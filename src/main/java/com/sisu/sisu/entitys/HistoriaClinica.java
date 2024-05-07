package com.sisu.sisu.entitys;

import java.io.Serializable;
import java.time.chrono.HijrahChronology;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "historia_clinica")
public class HistoriaClinica implements Serializable {

	private static long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_historia_clinica")
	private Integer idHistoriaClinica;

	@Column(name = "fecha_registro_hc")
	private Date fechaAtencionMedica;

		@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_historia_seguro")
	private HistorialSeguro historialSeguro;
	/*
	 * @Column(name = "fecha_registro_hc")
	 * Calendar calendario = Calendar.getInstance();
	 * private Date fechaAtencionMedica= calendario.getTime();
	 */
	private Date registro;

	@Column(name = "estado_Clinica")
	private String estadoHistoriaClinica;

	// ---------DATOS DEL INFORMANTE----------

	@Column(name = "relacion_infor")
	private String relacionInformante;

	@Column(name = "nombre_infor")
	private String nombreInformante;

	@Column(name = "domicilio_infor")
	private String domicilioInformante;

	// ----------SIGNOS VITALES-------------

	@Column(name = "peso")
	private float peso;

	@Column(name = "talla")
	private String talla;

	@Column(name = "presion_arterial")
	private float presiónArterial;

	@Column(name = "frecuencia_cardiaca")
	private Integer frecuenciaCardiaca;

	@Column(name = "frecuencia_respiratoria")
	private Integer frecuenciaRespiratoria;

	@Column(name = "temperatura_corporal")
	private float temperaturaCorporal;

	// ----------MOTIVO DE CONSULTA ; ENFERMEDAD ACTUAL-------------

	@Column(name = "motivo_consulta")
	private String motivoConsulta;

	@Column(name = "enfermedad_actual")
	private String enfermedadActual;

	// ----------Ant. Personales Patologicos ; Ant. Familiares
	// Patologicos-------------

	@Column(name = "enf_congenitas")
	private String enfCongenitas;

	@Column(name = "quirurgicos")
	private String quirurgicos;

	@Column(name = "alergias_patologicos")
	private String alergiasPatologicos;

	@Column(name = "patologias")
	private String patologias;

	@Column(name = "antFamiliares_patologicos")
	private String antFamiliaresPatologicos;

	// ----------Ant. Personales No Patologicos-------------

	@Column(name = "grupo_sanguineo")
	private String grupoSanguineo;

	@Column(name = "alergias_No_patologicos")
	private String alergiasNoPatologicos;

	@Column(name = "factores_riesgo")
	private String factoresRiesgo;

	// ----------Antecedentes Gineco-obstetricos-------------

	@Column(name = "menarca")
	private Integer menarca;

	@Column(name = "menst_ritmo")
	private String menstRitmo;

	@Column(name = "menopausia")
	private String menopausia;

	@Column(name = "numero_embarazos") // G
	private Integer numeroEmbarazos;

	@Column(name = "numero_partos") // P
	private Integer numeroPartos;

	@Column(name = "numero_abortos") // A
	private Integer numeroAbortos;

	@Column(name = "numero_cesarias") // A
	private Integer numeroCesarias;

	@Column(name = "vida_sexual")
	private String vidaSexual;

	@Column(name = "metodo_anticeptivo")
	private String metodoAnticeptivo;

	// ----------ESTADO DEL PACIENTE IMPRESIÓN GENERAL-------------

	@Column(name = "estado_paciente")
	private String estadoPaciente;

	@Column(name = "cabeza")
	private String cabeza;

	@Column(name = "cuello")
	private String cuello;

	@Column(name = "torax")
	private String torax;

	@Column(name = "abdomen")
	private String abdomen;

	@Column(name = "extremidades")
	private String extremidades;

	@Column(name = "neurologico")
	private String neurologico;

	@Column(name = "examenes_complementarios")
	private String examenesComplementarios;

	@Column(name = "diagnostico")
	private String diagnostico;

	@Column(name = "tratamiento")
	private String tratamiento;


	


	public HistoriaClinica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HistoriaClinica(Integer idHistoriaClinica, Calendar calendario, Date fechaAtencionMedica,
			String estadoHistoriaClinica, String relacionInformante, String nombreInformante,
			String domicilioInformante, float peso, String talla, float presiónArterial, Integer frecuenciaCardiaca,
			Integer frecuenciaRespiratoria, float temperaturaCorporal, String motivoConsulta,
			String enfermedadActual, String enfCongenitas, String quirurgicos, String alergiasPatologicos,
			String patologias, String antFamiliaresPatologicos, String grupoSanguineo, String alergiasNoPatologicos,
			String factoresRiesgo, Integer menarca, String menstRitmo, String menopausia, Integer numeroEmbarazos,
			Integer numeroPartos, Integer numeroAbortos, Integer numeroCesarias, String vidaSexual,
			String metodoAnticeptivo, String estadoPaciente, String cabeza, String cuello, String torax,
			String abdomen, String extremidades, String neurologico, String examenesComplementarios,
			String diagnostico, String tratamiento) {
		super();
		this.idHistoriaClinica = idHistoriaClinica;
		// this.calendario = calendario;
		this.fechaAtencionMedica = fechaAtencionMedica;
		this.estadoHistoriaClinica = estadoHistoriaClinica;
		this.relacionInformante = relacionInformante;
		this.nombreInformante = nombreInformante;
		this.domicilioInformante = domicilioInformante;
		this.peso = peso;
		this.talla = talla;
		this.presiónArterial = presiónArterial;
		this.frecuenciaCardiaca = frecuenciaCardiaca;
		this.frecuenciaRespiratoria = frecuenciaRespiratoria;
		this.temperaturaCorporal = temperaturaCorporal;
		this.motivoConsulta = motivoConsulta;
		this.enfermedadActual = enfermedadActual;
		this.enfCongenitas = enfCongenitas;
		this.quirurgicos = quirurgicos;
		this.alergiasPatologicos = alergiasPatologicos;
		this.patologias = patologias;
		this.antFamiliaresPatologicos = antFamiliaresPatologicos;
		this.grupoSanguineo = grupoSanguineo;
		this.alergiasNoPatologicos = alergiasNoPatologicos;
		this.factoresRiesgo = factoresRiesgo;
		this.menarca = menarca;
		this.menstRitmo = menstRitmo;
		this.menopausia = menopausia;
		this.numeroEmbarazos = numeroEmbarazos;
		this.numeroPartos = numeroPartos;
		this.numeroAbortos = numeroAbortos;
		this.numeroCesarias = numeroCesarias;
		this.vidaSexual = vidaSexual;
		this.metodoAnticeptivo = metodoAnticeptivo;
		this.estadoPaciente = estadoPaciente;
		this.cabeza = cabeza;
		this.cuello = cuello;
		this.torax = torax;
		this.abdomen = abdomen;
		this.extremidades = extremidades;
		this.neurologico = neurologico;
		this.examenesComplementarios = examenesComplementarios;
		this.diagnostico = diagnostico;
		this.tratamiento = tratamiento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdHistoriaClinica() {
		return idHistoriaClinica;
	}

	public void setIdHistoriaClinica(Integer idHistoriaClinica) {
		this.idHistoriaClinica = idHistoriaClinica;
	}

	/*
	 * public Calendar getCalendario() {
	 * return calendario;
	 * }
	 * 
	 * public void setCalendario(Calendar calendario) {
	 * this.calendario = calendario;
	 * }
	 */

	public Date getFechaAtencionMedica() {
		return fechaAtencionMedica;
	}

	public void setFechaAtencionMedica(Date fechaAtencionMedica) {
		this.fechaAtencionMedica = fechaAtencionMedica;
	}

	public String getEstadoHistoriaClinica() {
		return estadoHistoriaClinica;
	}

	public void setEstadoHistoriaClinica(String estadoHistoriaClinica) {
		this.estadoHistoriaClinica = estadoHistoriaClinica;
	}

	public String getRelacionInformante() {
		return relacionInformante;
	}

	public void setRelacionInformante(String relacionInformante) {
		this.relacionInformante = relacionInformante;
	}

	public String getNombreInformante() {
		return nombreInformante;
	}

	public void setNombreInformante(String nombreInformante) {
		this.nombreInformante = nombreInformante;
	}

	public String getDomicilioInformante() {
		return domicilioInformante;
	}

	public void setDomicilioInformante(String domicilioInformante) {
		this.domicilioInformante = domicilioInformante;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public float getPresiónArterial() {
		return presiónArterial;
	}

	public void setPresiónArterial(float presiónArterial) {
		this.presiónArterial = presiónArterial;
	}

	public Integer getFrecuenciaCardiaca() {
		return frecuenciaCardiaca;
	}

	public void setFrecuenciaCardiaca(Integer frecuenciaCardiaca) {
		this.frecuenciaCardiaca = frecuenciaCardiaca;
	}

	public Integer getFrecuenciaRespiratoria() {
		return frecuenciaRespiratoria;
	}

	public void setFrecuenciaRespiratoria(Integer frecuenciaRespiratoria) {
		this.frecuenciaRespiratoria = frecuenciaRespiratoria;
	}

	public float getTemperaturaCorporal() {
		return temperaturaCorporal;
	}

	public void setTemperaturaCorporal(float temperaturaCorporal) {
		this.temperaturaCorporal = temperaturaCorporal;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

	public String getEnfermedadActual() {
		return enfermedadActual;
	}

	public void setEnfermedadActual(String enfermedadActual) {
		this.enfermedadActual = enfermedadActual;
	}

	public String getEnfCongenitas() {
		return enfCongenitas;
	}

	public void setEnfCongenitas(String enfCongenitas) {
		this.enfCongenitas = enfCongenitas;
	}

	public String getQuirurgicos() {
		return quirurgicos;
	}

	public void setQuirurgicos(String quirurgicos) {
		this.quirurgicos = quirurgicos;
	}

	public String getAlergiasPatologicos() {
		return alergiasPatologicos;
	}

	public void setAlergiasPatologicos(String alergiasPatologicos) {
		this.alergiasPatologicos = alergiasPatologicos;
	}

	public String getPatologias() {
		return patologias;
	}

	public void setPatologias(String patologias) {
		this.patologias = patologias;
	}

	public String getAntFamiliaresPatologicos() {
		return antFamiliaresPatologicos;
	}

	public void setAntFamiliaresPatologicos(String antFamiliaresPatologicos) {
		this.antFamiliaresPatologicos = antFamiliaresPatologicos;
	}

	public String getGrupoSanguineo() {
		return grupoSanguineo;
	}

	public void setGrupoSanguineo(String grupoSanguineo) {
		this.grupoSanguineo = grupoSanguineo;
	}

	public String getAlergiasNoPatologicos() {
		return alergiasNoPatologicos;
	}

	public void setAlergiasNoPatologicos(String alergiasNoPatologicos) {
		this.alergiasNoPatologicos = alergiasNoPatologicos;
	}

	public String getFactoresRiesgo() {
		return factoresRiesgo;
	}

	public void setFactoresRiesgo(String factoresRiesgo) {
		this.factoresRiesgo = factoresRiesgo;
	}

	public Integer getMenarca() {
		return menarca;
	}

	public void setMenarca(Integer menarca) {
		this.menarca = menarca;
	}

	public String getMenstRitmo() {
		return menstRitmo;
	}

	public void setMenstRitmo(String menstRitmo) {
		this.menstRitmo = menstRitmo;
	}

	public String getMenopausia() {
		return menopausia;
	}

	public void setMenopausia(String menopausia) {
		this.menopausia = menopausia;
	}

	public Integer getNumeroEmbarazos() {
		return numeroEmbarazos;
	}

	public void setNumeroEmbarazos(Integer numeroEmbarazos) {
		this.numeroEmbarazos = numeroEmbarazos;
	}

	public Integer getNumeroPartos() {
		return numeroPartos;
	}

	public void setNumeroPartos(Integer numeroPartos) {
		this.numeroPartos = numeroPartos;
	}

	public Integer getNumeroAbortos() {
		return numeroAbortos;
	}

	public void setNumeroAbortos(Integer numeroAbortos) {
		this.numeroAbortos = numeroAbortos;
	}

	public Integer getNumeroCesarias() {
		return numeroCesarias;
	}

	public void setNumeroCesarias(Integer numeroCesarias) {
		this.numeroCesarias = numeroCesarias;
	}

	public String getVidaSexual() {
		return vidaSexual;
	}

	public void setVidaSexual(String vidaSexual) {
		this.vidaSexual = vidaSexual;
	}

	public String getMetodoAnticeptivo() {
		return metodoAnticeptivo;
	}

	public void setMetodoAnticeptivo(String metodoAnticeptivo) {
		this.metodoAnticeptivo = metodoAnticeptivo;
	}

	public String getEstadoPaciente() {
		return estadoPaciente;
	}

	public void setEstadoPaciente(String estadoPaciente) {
		this.estadoPaciente = estadoPaciente;
	}

	public String getCabeza() {
		return cabeza;
	}

	public void setCabeza(String cabeza) {
		this.cabeza = cabeza;
	}

	public String getCuello() {
		return cuello;
	}

	public void setCuello(String cuello) {
		this.cuello = cuello;
	}

	public String getTorax() {
		return torax;
	}

	public void setTorax(String torax) {
		this.torax = torax;
	}

	public String getAbdomen() {
		return abdomen;
	}

	public void setAbdomen(String abdomen) {
		this.abdomen = abdomen;
	}

	public String getExtremidades() {
		return extremidades;
	}

	public void setExtremidades(String extremidades) {
		this.extremidades = extremidades;
	}

	public String getNeurologico() {
		return neurologico;
	}

	public void setNeurologico(String neurologico) {
		this.neurologico = neurologico;
	}

	public String getExamenesComplementarios() {
		return examenesComplementarios;
	}

	public void setExamenesComplementarios(String examenesComplementarios) {
		this.examenesComplementarios = examenesComplementarios;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	@Override
	public String toString() {
		return "HistoriaClinica [idHistoriaClinica=" + idHistoriaClinica
		// + ", calendario=" + calendario
				+ ", fechaAtencionMedica=" + fechaAtencionMedica + ", estadoHistoriaClinica="
				+ estadoHistoriaClinica + ", relacionInformante=" + relacionInformante + ", nombreInformante="
				+ nombreInformante + ", domicilioInformante=" + domicilioInformante + ", peso=" + peso + ", talla="
				+ talla + ", presiónArterial=" + presiónArterial + ", frecuenciaCardiaca=" + frecuenciaCardiaca
				+ ", frecuenciaRespiratoria=" + frecuenciaRespiratoria + ", temperaturaCorporal="
				+ temperaturaCorporal + ", motivoConsulta=" + motivoConsulta + ", enfermedadActual="
				+ enfermedadActual + ", enfCongenitas=" + enfCongenitas + ", quirurgicos=" + quirurgicos
				+ ", alergiasPatologicos=" + alergiasPatologicos + ", patologias=" + patologias
				+ ", antFamiliaresPatologicos=" + antFamiliaresPatologicos + ", grupoSanguineo=" + grupoSanguineo
				+ ", alergiasNoPatologicos=" + alergiasNoPatologicos + ", factoresRiesgo=" + factoresRiesgo
				+ ", menarca=" + menarca + ", menstRitmo=" + menstRitmo + ", menopausia=" + menopausia
				+ ", numeroEmbarazos=" + numeroEmbarazos + ", numeroPartos=" + numeroPartos + ", numeroAbortos="
				+ numeroAbortos + ", numeroCesarias=" + numeroCesarias + ", vidaSexual=" + vidaSexual
				+ ", metodoAnticeptivo=" + metodoAnticeptivo + ", estadoPaciente=" + estadoPaciente + ", cabeza="
				+ cabeza + ", cuello=" + cuello + ", torax=" + torax + ", abdomen=" + abdomen + ", extremidades="
				+ extremidades + ", neurologico=" + neurologico + ", examenesComplementarios="
				+ examenesComplementarios + ", diagnostico=" + diagnostico + ", tratamiento=" + tratamiento + "]";
	}

}
