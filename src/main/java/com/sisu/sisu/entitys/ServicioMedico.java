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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "servicio_medico")
public class ServicioMedico implements Serializable {

	private static long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servicio_medico")
	private Integer idServicioMedico;

	@Column(name = "cantidad_fichas")
	private Integer cantidad_fichas;

	@Column(name = "estado")
	private String estado;

	@Column(name = "registro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;

	@Column(name = "modificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificacion;

	// --------------------------RELACION--------------------------------------

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "servicio_medico", fetch = FetchType.LAZY)
	private List<MedicoServicio> medico_servicio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idServicio")
	private Servicio servicio;

	public ServicioMedico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServicioMedico(Integer idServicioMedico, Integer cantidad_fichas, String estado, Date registro,
			Date modificacion, List<MedicoServicio> medico_servicio, Servicio servicio) {
		super();
		this.idServicioMedico = idServicioMedico;
		this.cantidad_fichas = cantidad_fichas;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
		this.medico_servicio = medico_servicio;
		this.servicio = servicio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdServicioMedico() {
		return idServicioMedico;
	}

	public void setIdServicioMedico(Integer idServicioMedico) {
		this.idServicioMedico = idServicioMedico;
	}

	public Integer getCantidad_fichas() {
		return cantidad_fichas;
	}

	public void setCantidad_fichas(Integer cantidad_fichas) {
		this.cantidad_fichas = cantidad_fichas;
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

	public List<MedicoServicio> getMedico_servicio() {
		return medico_servicio;
	}

	public void setMedico_servicio(List<MedicoServicio> medico_servicio) {
		this.medico_servicio = medico_servicio;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	@Override
	public String toString() {
		return "ServicioMedico [idServicioMedico=" + idServicioMedico + ", cantidad_fichas=" + cantidad_fichas
				+ ", estado=" + estado + ", registro=" + registro + ", modificacion=" + modificacion
				+ ", medico_servicio=" + medico_servicio + ", servicio=" + servicio + "]";
	}

}
