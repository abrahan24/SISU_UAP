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
@Table(name = "servicio")
public class Servicio implements Serializable {
	private static long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servicio")
	private Integer idServicio;

	@Column(name = "servicio")
	private Integer servicio;

	@Column(name = "descripcion")
	private Integer descripcion;

	@Column(name = "estado")
	private String estado;
 
	@Column(name = "modificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificacion;

	@Column(name = "registro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;
	
	@Column(name = "servicios")
	private String servicios;

	// --------------------------RELACION--------------------------------------

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "servicio", fetch = FetchType.LAZY)
	private List<ServicioMedico> servicio_medico;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "servicio", fetch = FetchType.LAZY)
	private List<ConceptosServicios> concepto_servicio;

	public Servicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Servicio(Integer idServicio, Integer servicio, Integer descripcion, String estado, Date registro,
			Date modificacion, List<ServicioMedico> servicio_medico, List<ConceptosServicios> concepto_servicio) {
		super();
		this.idServicio = idServicio;
		this.servicio = servicio;
		this.descripcion = descripcion;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
		this.servicio_medico = servicio_medico;
		this.concepto_servicio = concepto_servicio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	public Integer getServiacio() {
		return servicio;
	}

	public void setServiacio(Integer serviacio) {
		this.servicio = serviacio;
	}

	public Integer getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(Integer descripcion) {
		this.descripcion = descripcion;
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

	public List<ServicioMedico> getServicio_medico() {
		return servicio_medico;
	}

	public void setServicio_medico(List<ServicioMedico> servicio_medico) {
		this.servicio_medico = servicio_medico;
	}

	public List<ConceptosServicios> getConcepto_servicio() {
		return concepto_servicio;
	}

	public void setConcepto_servicio(List<ConceptosServicios> concepto_servicio) {
		this.concepto_servicio = concepto_servicio;
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", servicio=" + servicio + ", descripcion=" + descripcion
				+ ", estado=" + estado + ", registro=" + registro + ", modificacion=" + modificacion
				+ ", servicio_medico=" + servicio_medico + ", concepto_servicio=" + concepto_servicio + "]";
	}

}
