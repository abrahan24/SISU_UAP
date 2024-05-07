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

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "historial_liname")
public class HistorialLiname implements Serializable{
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial_liname")
    private Integer idHistorialLiname;

    @Column(name = "estado_historial_liname")
    private String estadoHistorialLiname;

    @Column(name = "fecha_historial_liname")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaHistorialLiname;

    @Column(name = "precio")
    private String precio;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    //---------------------RELACIONES-------------------------------------------

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idLiname")
    private ListaLiname lista_liname;

	public HistorialLiname() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HistorialLiname(Integer idHistorialLiname, String estadoHistorialLiname, Date fechaHistorialLiname,
			String precio, String observacion, Date registro, Date modificacion, ListaLiname lista_liname) {
		super();
		this.idHistorialLiname = idHistorialLiname;
		this.estadoHistorialLiname = estadoHistorialLiname;
		this.fechaHistorialLiname = fechaHistorialLiname;
		this.precio = precio;
		this.observacion = observacion;
		this.registro = registro;
		this.modificacion = modificacion;
		this.lista_liname = lista_liname;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdHistorialLiname() {
		return idHistorialLiname;
	}

	public void setIdHistorialLiname(Integer idHistorialLiname) {
		this.idHistorialLiname = idHistorialLiname;
	}

	public String getEstadoHistorialLiname() {
		return estadoHistorialLiname;
	}

	public void setEstadoHistorialLiname(String estadoHistorialLiname) {
		this.estadoHistorialLiname = estadoHistorialLiname;
	}

	public Date getFechaHistorialLiname() {
		return fechaHistorialLiname;
	}

	public void setFechaHistorialLiname(Date fechaHistorialLiname) {
		this.fechaHistorialLiname = fechaHistorialLiname;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
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

	public ListaLiname getLista_liname() {
		return lista_liname;
	}

	public void setLista_liname(ListaLiname lista_liname) {
		this.lista_liname = lista_liname;
	}

	@Override
	public String toString() {
		return "HistorialLiname [idHistorialLiname=" + idHistorialLiname + ", estadoHistorialLiname="
				+ estadoHistorialLiname + ", fechaHistorialLiname=" + fechaHistorialLiname + ", precio=" + precio
				+ ", observacion=" + observacion + ", registro=" + registro + ", modificacion=" + modificacion
				+ ", lista_liname=" + lista_liname + "]";
	}
    
    
    
    
    
}
