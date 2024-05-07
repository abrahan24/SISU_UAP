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
@Table(name = "tipo_persona")
public class TipoPersona implements Serializable {
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_persona")
    private Integer idTipoPersona;

    @Column(name = "tipo_persona")
    private String tipoPersona;

    @Column(name = "descripcion_persona")
    private String descripcionPersona;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

	public TipoPersona() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoPersona(Integer idTipoPersona, String tipoPersona, String descripcionPersona, String estado,
			Date registro, Date modificacion) {
		super();
		this.idTipoPersona = idTipoPersona;
		this.tipoPersona = tipoPersona;
		this.descripcionPersona = descripcionPersona;
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

	public Integer getIdTipoPersona() {
		return idTipoPersona;
	}

	public void setIdTipoPersona(Integer idTipoPersona) {
		this.idTipoPersona = idTipoPersona;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getDescripcionPersona() {
		return descripcionPersona;
	}

	public void setDescripcionPersona(String descripcionPersona) {
		this.descripcionPersona = descripcionPersona;
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
		return "TipoPersona [idTipoPersona=" + idTipoPersona + ", tipoPersona=" + tipoPersona + ", descripcionPersona="
				+ descripcionPersona + ", estado=" + estado + ", registro=" + registro + ", modificacion="
				+ modificacion + "]";
	}
    
    
    
    

}
