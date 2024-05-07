package com.sisu.sisu.entitys;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "historial_medico_servicio")
public class HistorialMedicoServicio implements Serializable {
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial_medico_servicio")
    private Integer idHistorialMedicoServicio;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyy-MM-dd")
    private Date fecha;

    @Column(name = "hora")
    private LocalTime hora;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;

    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    //---------------------RELACIONES-------------------------------------------


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMedicoServicio")
    private MedicoServicio medico_servicio;

     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idHistorialMedico")
    private HistorialMedico historial_medico;

	public HistorialMedicoServicio() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HistorialMedicoServicio(Integer idHistorialMedicoServicio, Date fecha, LocalTime hora, String estado,
			Date registro, Date modificacion, MedicoServicio medico_servicio, HistorialMedico historial_medico) {
		super();
		this.idHistorialMedicoServicio = idHistorialMedicoServicio;
		this.fecha = fecha;
		this.hora = hora;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
		this.medico_servicio = medico_servicio;
		this.historial_medico = historial_medico;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdHistorialMedicoServicio() {
		return idHistorialMedicoServicio;
	}

	public void setIdHistorialMedicoServicio(Integer idHistorialMedicoServicio) {
		this.idHistorialMedicoServicio = idHistorialMedicoServicio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
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

	public MedicoServicio getMedico_servicio() {
		return medico_servicio;
	}

	public void setMedico_servicio(MedicoServicio medico_servicio) {
		this.medico_servicio = medico_servicio;
	}

	public HistorialMedico getHistorial_medico() {
		return historial_medico;
	}

	public void setHistorial_medico(HistorialMedico historial_medico) {
		this.historial_medico = historial_medico;
	}

	@Override
	public String toString() {
		return "HistorialMedicoServicio [idHistorialMedicoServicio=" + idHistorialMedicoServicio + ", fecha=" + fecha
				+ ", hora=" + hora + ", estado=" + estado + ", registro=" + registro + ", modificacion=" + modificacion
				+ ", medico_servicio=" + medico_servicio + ", historial_medico=" + historial_medico + "]";
	}
     
     
     
     
     
	
     
     


}
