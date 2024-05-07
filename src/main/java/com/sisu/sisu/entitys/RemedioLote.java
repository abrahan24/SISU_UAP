package com.sisu.sisu.entitys;

import java.io.Serializable;
import java.time.LocalDate;
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
@Table(name = "remedio_lote")
public class RemedioLote implements Serializable {
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_remedio_lote")
    private Integer idRemedioLote;

    @Column(name = "precio_lote")
    private String precioLote;

    @Column(name = "fecha_vencimiento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaVencimiento;

    @Column(name = "cantidad")
    private String cantidad;

    @Column(name = "numero_lote")
    private String numeroLote;

    @Column(name = "estado_remedioL")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;


    //----------------------RELACIONES------------------------------------------
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idProveedor")
    private Proveedor proveedor;


	public RemedioLote() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RemedioLote(Integer idRemedioLote, String precioLote, LocalDate fechaVencimiento, String cantidad,
			String numeroLote, String estado, Date registro, Date modificacion, Proveedor proveedor) {
		super();
		this.idRemedioLote = idRemedioLote;
		this.precioLote = precioLote;
		this.fechaVencimiento = fechaVencimiento;
		this.cantidad = cantidad;
		this.numeroLote = numeroLote;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
		this.proveedor = proveedor;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}


	public Integer getIdRemedioLote() {
		return idRemedioLote;
	}


	public void setIdRemedioLote(Integer idRemedioLote) {
		this.idRemedioLote = idRemedioLote;
	}


	public String getPrecioLote() {
		return precioLote;
	}


	public void setPrecioLote(String precioLote) {
		this.precioLote = precioLote;
	}


	public LocalDate getFechaVencimiento() {
		return fechaVencimiento;
	}


	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}


	public String getCantidad() {
		return cantidad;
	}


	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}


	public String getNumeroLote() {
		return numeroLote;
	}


	public void setNumeroLote(String numeroLote) {
		this.numeroLote = numeroLote;
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


	public Proveedor getProveedor() {
		return proveedor;
	}


	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	@Override
	public String toString() {
		return "RemedioLote [idRemedioLote=" + idRemedioLote + ", precioLote=" + precioLote + ", fechaVencimiento="
				+ fechaVencimiento + ", cantidad=" + cantidad + ", numeroLote=" + numeroLote + ", estado=" + estado
				+ ", registro=" + registro + ", modificacion=" + modificacion + ", proveedor=" + proveedor + "]";
	}
    
    
    
    
    
    
    

    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "remedio_lote", fetch = FetchType.LAZY)
	// private List<RemediosFarmaciaLote> remedios_farmacia_lote;

    // @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "servicios")
    // private Proveedor servicios;
}
