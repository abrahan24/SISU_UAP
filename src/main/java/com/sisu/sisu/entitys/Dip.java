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

@Getter
@Setter
@Entity
@Table(name = "dip")
public class Dip implements Serializable {

	private static long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dip")
	private Integer idDip;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "codDip")
	private String codDip;

	@Column(name = "estado")
	private String estado;

	@Column(name = "registro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;

	@Column(name = "modificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificacion;

    //-----------------------RELACIONES-----------------------------------------

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "dip", fetch = FetchType.LAZY)
	private List<Persona> persona;

	public Dip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dip(Integer idDip, String descripcion, String codDip, String estado, Date registro, Date modificacion,
			List<Persona> persona) {
		super();
		this.idDip = idDip;
		this.descripcion = descripcion;
		this.codDip = codDip;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
		this.persona = persona;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdDip() {
		return idDip;
	}

	public void setIdDip(Integer idDip) {
		this.idDip = idDip;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodDip() {
		return codDip;
	}

	public void setCodDip(String codDip) {
		this.codDip = codDip;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public List<Persona> getPersona() {
		return persona;
	}

	public void setPersona(List<Persona> persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Dip [idDip=" + idDip + ", descripcion=" + descripcion + ", codDip=" + codDip + ", estado=" + estado
				+ ", registro=" + registro + ", modificacion=" + modificacion + ", persona=" + persona + "]";
	}
	
	
	
	

}