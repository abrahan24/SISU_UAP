package com.sisu.sisu.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "atencion_medica")
public class AtencionMedica implements Serializable {
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atencion_medica")
    private Integer idAtencionMedica;

    @Column(name = "fecha_atencion_medica")
    private Date fechaAtencionMedica;

    @Column(name = "hora")
    private String hora;

    @Column(name = "campo")
    private String campo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

	public AtencionMedica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AtencionMedica(Integer idAtencionMedica, Date fechaAtencionMedica, String hora, String campo, String estado,
			Date registro, Date modificacion) {
		super();
		this.idAtencionMedica = idAtencionMedica;
		this.fechaAtencionMedica = fechaAtencionMedica;
		this.hora = hora;
		this.campo = campo;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdAtencionMedica() {
		return idAtencionMedica;
	}

	public void setIdAtencionMedica(Integer idAtencionMedica) {
		this.idAtencionMedica = idAtencionMedica;
	}

	public Date getFechaAtencionMedica() {
		return fechaAtencionMedica;
	}

	public void setFechaAtencionMedica(Date fechaAtencionMedica) {
		this.fechaAtencionMedica = fechaAtencionMedica;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
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

	@Override
	public String toString() {
		return "AtencionMedica [idAtencionMedica=" + idAtencionMedica + ", fechaAtencionMedica=" + fechaAtencionMedica
				+ ", hora=" + hora + ", campo=" + campo + ", estado=" + estado + ", registro=" + registro
				+ ", modificacion=" + modificacion + "]";
	}
    
    
    
    
    
    
}
