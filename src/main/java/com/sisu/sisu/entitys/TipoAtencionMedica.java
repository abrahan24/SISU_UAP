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
@Table(name = "tipo_atencion_medica")
public class TipoAtencionMedica implements Serializable {
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_atencion_medica")
    private Integer idTipoAtencionMedica;
    
    @Column(name = "tipo_atencion")
    private String tipoAtencion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

	public TipoAtencionMedica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoAtencionMedica(Integer idTipoAtencionMedica, String tipoAtencion, String estado, Date registro,
			Date modificacion) {
		super();
		this.idTipoAtencionMedica = idTipoAtencionMedica;
		this.tipoAtencion = tipoAtencion;
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

	public Integer getIdTipoAtencionMedica() {
		return idTipoAtencionMedica;
	}

	public void setIdTipoAtencionMedica(Integer idTipoAtencionMedica) {
		this.idTipoAtencionMedica = idTipoAtencionMedica;
	}

	public String getTipoAtencion() {
		return tipoAtencion;
	}

	public void setTipoAtencion(String tipoAtencion) {
		this.tipoAtencion = tipoAtencion;
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
		return "TipoAtencionMedica [idTipoAtencionMedica=" + idTipoAtencionMedica + ", tipoAtencion=" + tipoAtencion
				+ ", estado=" + estado + ", registro=" + registro + ", modificacion=" + modificacion + "]";
	}
    
    
    
	
    
    
}
