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

@Getter
@Setter
@Entity
@Table(name = "tipos_estado_civil")
public class TiposEstadoCivil implements Serializable {

	private static long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo_estado_civil")
	private Integer idTipoEstadoCivil;

	@Column(name = "Nom_estado_civil")
	private String NomEstadoCivil;

	@Column(name = "estado")
	private String estado;

	@Column(name = "registro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;

	@Column(name = "modificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificacion;

	public TiposEstadoCivil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TiposEstadoCivil(Integer idTipoEstadoCivil, String nomEstadoCivil, String estado, Date registro,
			Date modificacion) {
		super();
		this.idTipoEstadoCivil = idTipoEstadoCivil;
		NomEstadoCivil = nomEstadoCivil;
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

	public Integer getIdTipoEstadoCivil() {
		return idTipoEstadoCivil;
	}

	public void setIdTipoEstadoCivil(Integer idTipoEstadoCivil) {
		this.idTipoEstadoCivil = idTipoEstadoCivil;
	}

	public String getNomEstadoCivil() {
		return NomEstadoCivil;
	}

	public void setNomEstadoCivil(String nomEstadoCivil) {
		NomEstadoCivil = nomEstadoCivil;
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
		return "TiposEstadoCivil [idTipoEstadoCivil=" + idTipoEstadoCivil + ", NomEstadoCivil=" + NomEstadoCivil
				+ ", estado=" + estado + ", registro=" + registro + ", modificacion=" + modificacion + "]";
	}

    public static TiposEstadoCivil parse(String string) {
        return null;
    }

	
	/* 
	 * RELACION */

	
	
	
	
	
}
