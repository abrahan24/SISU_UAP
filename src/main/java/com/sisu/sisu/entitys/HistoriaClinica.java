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
	private String peso;

	@Column(name = "talla")
	private String talla;

	@Column(name = "presion_arterial")
	private String presionArterial;

	@Column(name = "frecuencia_cardiaca")
	private String frecuenciaCardiaca;

	@Column(name = "frecuencia_respiratoria")
	private String frecuenciaRespiratoria;

	@Column(name = "temperatura_corporal")
	private String temperaturaCorporal;

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
	private String menarca;

	@Column(name = "pap")
	private String pap; //Papanicolaou

	@Column(name = "fum")
	private String fum; //FUM Fecha de la Última Menstruación

	@Column(name = "num_hijos")
	private String num_hijos; //C

	@Column(name = "menst_ritmo")
	private String menstRitmo;

	@Column(name = "menopausia")
	private String menopausia;

	@Column(name = "numero_embarazos") // G
	private String numeroEmbarazos;

	@Column(name = "numero_partos") // P
	private String numeroPartos;

	@Column(name = "numero_abortos") // A
	private String numeroAbortos;

	@Column(name = "numero_cesarias") // A
	private String numeroCesarias;

	@Column(name = "vida_sexual")
	private String vidaSexual;

	@Column(name = "metodo_anticeptivo")
	private String metodoAnticeptivo;

	// ----------EXAMEN OBSTÉTRICO-------------
	@Column(name = "afu")
	private String afu; //A.F.U. Altura del Fondo Uterino

	@Column(name = "posicion_feto")
	private String posicion_feto; //Se refiere a la posición del feto dentro del útero en relación con la pelvis materna

	@Column(name = "situacion_feto")
	private String situacion_feto; //se refiere a la parte del cuerpo fetal que está más cercana al canal del parto

	@Column(name = "presentacion_feto")
	private String presentacion_feto; //describe la parte del cuerpo fetal que está más próxima al canal del parto

	@Column(name = "movimiento_fetal")
	private String movimiento_fetal; // indica si la paciente percibe los movimientos del feto dentro del útero

	@Column(name = "du")
	private String du; // Diámetro Uterino

	@Column(name = "tacto_vaginal")
	private String tacto_vaginal; 

	@Column(name = "especulo")
	private String especulo; // instrumento médico utilizado en ginecología para examinar la vagina y el cuello uterino de una paciente



	// ----------ESTADO DEL PACIENTE IMPRESIÓN GENERAL-------------

	@Column(name = "estado_paciente")
	private String estadoPaciente;

	@Column(name = "piel_mucosa")
	private String piel_mucosa;

	@Column(name = "cabeza_cuello")
	private String cabeza_cuello;

	@Column(name = "cardiovascular")
	private String cardiovascular;

	@Column(name = "respiratorio")
	private String respiratorio;

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

	@Column(name = "conducta")
	private String conducta;

	@Column(name = "imc")
	private String imc;

	


	


}
