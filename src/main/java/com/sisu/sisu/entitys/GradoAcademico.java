package com.sisu.sisu.entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "grado_academico")
public class GradoAcademico implements Serializable {

	private static long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = " id_grado_academico")
	private Integer idGradoAcademico;

	@Column(name = "nombre_grado")
	private String nombre_gradoAcademico;

	@Column(name = "estado")
	private String estado;

	@Column(name = "simbolo")
	private String simbolo;

	@Column(name = "nombre_institucion")
	private String nombre_institucion;

	@Column(name = "status")
	private String status;


	@Column(name = "registro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;

	@Column(name = "modificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificacion;

	@Column(name = "observacion")
	private String observacion;


	//--------------------------RELACION--------------------------------------

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grado_academico", fetch = FetchType.LAZY)
	private List<Persona> persona;


	public GradoAcademico() {
		super();
		// TODO Auto-generated constructor stub
	}


	public GradoAcademico(Integer idGradoAcademico, String nombre_gradoAcademico, String estado, String simbolo,
			String nombre_institucion, String status, Date registro, Date modificacion, String observacion,
			List<Persona> persona) {
		super();
		this.idGradoAcademico = idGradoAcademico;
		this.nombre_gradoAcademico = nombre_gradoAcademico;
		this.estado = estado;
		this.simbolo = simbolo;
		this.nombre_institucion = nombre_institucion;
		this.status = status;
		this.registro = registro;
		this.modificacion = modificacion;
		this.observacion = observacion;
		this.persona = persona;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}


	public Integer getIdGradoAcademico() {
		return idGradoAcademico;
	}


	public void setIdGradoAcademico(Integer idGradoAcademico) {
		this.idGradoAcademico = idGradoAcademico;
	}


	public String getNombre_gradoAcademico() {
		return nombre_gradoAcademico;
	}


	public void setNombre_gradoAcademico(String nombre_gradoAcademico) {
		this.nombre_gradoAcademico = nombre_gradoAcademico;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getSimbolo() {
		return simbolo;
	}


	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}


	public String getNombre_institucion() {
		return nombre_institucion;
	}


	public void setNombre_institucion(String nombre_institucion) {
		this.nombre_institucion = nombre_institucion;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getRegistro() {
		return registro;
	}


	public void setRegistro(Date registro) {
		this.registro = registro;
	}


	public Date getModificacion() {
		return modificacion;
	}


	public void setModificacion(Date modificacion) {
		this.modificacion = modificacion;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public List<Persona> getPersona() {
		return persona;
	}


	public void setPersona(List<Persona> persona) {
		this.persona = persona;
	}


	@Override
	public String toString() {
		return "GradoAcademico [idGradoAcademico=" + idGradoAcademico + ", nombre_gradoAcademico="
				+ nombre_gradoAcademico + ", estado=" + estado + ", simbolo=" + simbolo + ", nombre_institucion="
				+ nombre_institucion + ", status=" + status + ", registro=" + registro + ", modificacion="
				+ modificacion + ", observacion=" + observacion + ", persona=" + persona + "]";
	}
	
	
	
	
	
	



}
