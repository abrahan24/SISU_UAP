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

@Entity
@Setter
@Getter
@Table(name = "estado_seguro")
public class EstadoSeguro implements Serializable{
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_seguro")
    private Integer idEstadoSeguro;

    @Column(name = "tipo_estado")
    private String tipoEstado;

    @Column(name = "descricao_seguro")
    private String descripcionSeguro;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado_seguro", fetch = FetchType.LAZY)
	private List<HistorialSeguro> historial_seguro;

	public EstadoSeguro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstadoSeguro(Integer idEstadoSeguro, String tipoEstado, String descripcionSeguro, String estado,
			Date registro, Date modificacion, List<HistorialSeguro> historial_seguro) {
		super();
		this.idEstadoSeguro = idEstadoSeguro;
		this.tipoEstado = tipoEstado;
		this.descripcionSeguro = descripcionSeguro;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
		this.historial_seguro = historial_seguro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdEstadoSeguro() {
		return idEstadoSeguro;
	}

	public void setIdEstadoSeguro(Integer idEstadoSeguro) {
		this.idEstadoSeguro = idEstadoSeguro;
	}

	public String getTipoEstado() {
		return tipoEstado;
	}

	public void setTipoEstado(String tipoEstado) {
		this.tipoEstado = tipoEstado;
	}

	public String getDescripcionSeguro() {
		return descripcionSeguro;
	}

	public void setDescripcionSeguro(String descripcionSeguro) {
		this.descripcionSeguro = descripcionSeguro;
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

	public List<HistorialSeguro> getHistorial_seguro() {
		return historial_seguro;
	}

	public void setHistorial_seguro(List<HistorialSeguro> historial_seguro) {
		this.historial_seguro = historial_seguro;
	}

	@Override
	public String toString() {
		return "EstadoSeguro [idEstadoSeguro=" + idEstadoSeguro + ", tipoEstado=" + tipoEstado + ", descripcionSeguro="
				+ descripcionSeguro + ", estado=" + estado + ", registro=" + registro + ", modificacion=" + modificacion
				+ ", historial_seguro=" + historial_seguro + "]";
	}
    
    
    
    
    

}
