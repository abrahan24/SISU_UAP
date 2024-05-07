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
@Table(name = "institucion")
public class Institucion implements Serializable{
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_institucion")
    private Integer idInstitucion;

    @Column(name = "nombre_institucion")
    private String nombreInstitucion;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "institucion", fetch = FetchType.LAZY)
	private List<HistorialSeguro> historial_seguro;

public Institucion() {
	super();
	// TODO Auto-generated constructor stub
}

public Institucion(Integer idInstitucion, String nombreInstitucion, String observacion, String estado, Date registro,
		Date modificacion, List<HistorialSeguro> historial_seguro) {
	super();
	this.idInstitucion = idInstitucion;
	this.nombreInstitucion = nombreInstitucion;
	this.observacion = observacion;
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

public Integer getIdInstitucion() {
	return idInstitucion;
}

public void setIdInstitucion(Integer idInstitucion) {
	this.idInstitucion = idInstitucion;
}

public String getNombreInstitucion() {
	return nombreInstitucion;
}

public void setNombreInstitucion(String nombreInstitucion) {
	this.nombreInstitucion = nombreInstitucion;
}

public String getObservacion() {
	return observacion;
}

public void setObservacion(String observacion) {
	this.observacion = observacion;
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
	return "Institucion [idInstitucion=" + idInstitucion + ", nombreInstitucion=" + nombreInstitucion + ", observacion="
			+ observacion + ", estado=" + estado + ", registro=" + registro + ", modificacion=" + modificacion
			+ ", historial_seguro=" + historial_seguro + "]";
}
  
  
  
  
    
}
