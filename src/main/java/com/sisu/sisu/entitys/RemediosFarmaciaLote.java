package com.sisu.sisu.entitys;

import java.io.Serializable;
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

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "remedios_farmacia_lote")
public class RemediosFarmaciaLote implements Serializable{
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_remedios_farmacia_lote")
    private Integer idRemediosFarmaciaLote;

    @Column(name = "fecha_ingreso")
    private Date fechaIngreso;

    @Column(name = "precio_venta")
    private String precioVenta;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    @Column(name = "estado")
	private String estado;

    

    //---------------------------RELACIONES-------------------------------------

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRemedioLote")
    private RemedioLote remedio_lote;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRemediosFarmacia")
    private RemediosFarmacia remedios_farmacia;

	public RemediosFarmaciaLote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RemediosFarmaciaLote(Integer idRemediosFarmaciaLote, Date fechaIngreso, String precioVenta,
			String observacion, Date registro, Date modificacion, String estado, RemedioLote remedio_lote,
			RemediosFarmacia remedios_farmacia) {
		super();
		this.idRemediosFarmaciaLote = idRemediosFarmaciaLote;
		this.fechaIngreso = fechaIngreso;
		this.precioVenta = precioVenta;
		this.observacion = observacion;
		this.registro = registro;
		this.modificacion = modificacion;
		this.estado = estado;
		this.remedio_lote = remedio_lote;
		this.remedios_farmacia = remedios_farmacia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdRemediosFarmaciaLote() {
		return idRemediosFarmaciaLote;
	}

	public void setIdRemediosFarmaciaLote(Integer idRemediosFarmaciaLote) {
		this.idRemediosFarmaciaLote = idRemediosFarmaciaLote;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(String precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public RemedioLote getRemedio_lote() {
		return remedio_lote;
	}

	public void setRemedio_lote(RemedioLote remedio_lote) {
		this.remedio_lote = remedio_lote;
	}

	public RemediosFarmacia getRemedios_farmacia() {
		return remedios_farmacia;
	}

	public void setRemedios_farmacia(RemediosFarmacia remedios_farmacia) {
		this.remedios_farmacia = remedios_farmacia;
	}

	@Override
	public String toString() {
		return "RemediosFarmaciaLote [idRemediosFarmaciaLote=" + idRemediosFarmaciaLote + ", fechaIngreso="
				+ fechaIngreso + ", precioVenta=" + precioVenta + ", observacion=" + observacion + ", registro="
				+ registro + ", modificacion=" + modificacion + ", estado=" + estado + ", remedio_lote=" + remedio_lote
				+ ", remedios_farmacia=" + remedios_farmacia + "]";
	}
    
    
    
    
    
    



}
