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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "medico_servicio")
public class MedicoServicio implements Serializable {
	private static long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_medico_servicio")
	private Integer idMedicoServicio;

	@Column(name = "fecha_asignacion")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaAsignacion;

	@Column(name = "estado")
	private String estado;

	@Column(name = "registro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;

	@Column(name = "modificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificacion;

	// ----------------------------------------------------------------

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idServicioMedico")
	private ServicioMedico servicio_medico;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPersonalMedico")
	private PersonalMedico personal_medico;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "medico_servicio", fetch = FetchType.LAZY)
	private List<HistorialMedicoServicio> historial_medico_servicio;

	public MedicoServicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedicoServicio(Integer idMedicoServicio, Date fechaAsignacion, String estado, Date registro,
			Date modificacion, ServicioMedico servicio_medico, PersonalMedico personal_medico,
			List<HistorialMedicoServicio> historial_medico_servicio) {
		super();
		this.idMedicoServicio = idMedicoServicio;
		this.fechaAsignacion = fechaAsignacion;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
		this.servicio_medico = servicio_medico;
		this.personal_medico = personal_medico;
		this.historial_medico_servicio = historial_medico_servicio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdMedicoServicio() {
		return idMedicoServicio;
	}

	public void setIdMedicoServicio(Integer idMedicoServicio) {
		this.idMedicoServicio = idMedicoServicio;
	}

	public Date getFechaAsignaqcion() {
		return fechaAsignacion;
	}

	public void setFechaAsignaqcion(Date fechaAsignaqcion) {
		this.fechaAsignacion = fechaAsignaqcion;
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

	public ServicioMedico getServicio_medico() {
		return servicio_medico;
	}

	public void setServicio_medico(ServicioMedico servicio_medico) {
		this.servicio_medico = servicio_medico;
	}

	public PersonalMedico getPersonal_medico() {
		return personal_medico;
	}

	public void setPersonal_medico(PersonalMedico personal_medico) {
		this.personal_medico = personal_medico;
	}

	public List<HistorialMedicoServicio> getHistorial_medico_servicio() {
		return historial_medico_servicio;
	}

	public void setHistorial_medico_servicio(List<HistorialMedicoServicio> historial_medico_servicio) {
		this.historial_medico_servicio = historial_medico_servicio;
	}

	@Override
	public String toString() {
		return "MedicoServicio [idMedicoServicio=" + idMedicoServicio + ", fechaAsignacion=" + fechaAsignacion
				+ ", estado=" + estado + ", registro=" + registro + ", modificacion=" + modificacion
				+ ", servicio_medico=" + servicio_medico + ", personal_medico=" + personal_medico
				+ ", historial_medico_servicio=" + historial_medico_servicio + "]";
	}

}
