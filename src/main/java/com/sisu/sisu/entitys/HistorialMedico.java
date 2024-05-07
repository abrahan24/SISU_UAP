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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "historial_medico")
public class HistorialMedico implements Serializable {
  private static long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_historial_medico")
  private Integer idHistorialMedico;

  @Column(name = "observacion")
  private String Observacion;

  @Column(name = "fecha_Historial_medico")
  @DateTimeFormat(pattern = "yyy-MM-dd")
  private Date Fecha;

  @Column(name = "estado")
  private String estado;

  @Column(name = "registro")
  @Temporal(TemporalType.TIMESTAMP)
  private Date registro;

  @Column(name = "modificacion")
  @Temporal(TemporalType.TIMESTAMP)
  private Date modificacion;

  // ----------------------RELACIONES------------------------------------------

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idAsegurado")
  private Asegurado asegurado;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idConceptoServicio")
  private ConceptosServicios concepto_servicio;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "historial_medico", fetch = FetchType.LAZY)
  private List<HistorialReceta> historial_receta;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "historial_medico", fetch = FetchType.LAZY)
  private List<HistorialMedicoServicio> historial_medico_servicio;

public HistorialMedico() {
	super();
	// TODO Auto-generated constructor stub
}


public HistorialMedico(Integer idHistorialMedico, String Observacion, Date Fecha, String estado, Date registro,
		Date modificacion, Asegurado asegurado, ConceptosServicios concepto_servicio,
		List<HistorialReceta> historial_receta, List<HistorialMedicoServicio> historial_medico_servicio) {
	super();
	this.idHistorialMedico = idHistorialMedico;
	this.Observacion = Observacion;
	this.Fecha = Fecha;
	this.estado = estado;
	this.registro = registro;
	this.modificacion = modificacion;
	this.asegurado = asegurado;
	this.concepto_servicio = concepto_servicio;
	this.historial_receta = historial_receta;
	this.historial_medico_servicio = historial_medico_servicio;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

public static void setSerialversionuid(long serialversionuid) {
	serialVersionUID = serialversionuid;
}

public Integer getIdHistorialMedico() {
	return idHistorialMedico;
}

public void setIdHistorialMedico(Integer idHistorialMedico) {
	this.idHistorialMedico = idHistorialMedico;
}

public String getOberservacion() {
	return Observacion;
}

public void setOberservacion(String oberservacion) {
	Observacion = oberservacion;
}

public Date getFecha() {
	return Fecha;
}

public void setFecha(Date Fecha) {
	this.Fecha = Fecha;
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

public Asegurado getAsegurado() {
	return asegurado;
}

public void setAsegurado(Asegurado asegurado) {
	this.asegurado = asegurado;
}

public ConceptosServicios getConcepto_servicio() {
	return concepto_servicio;
}

public void setConcepto_servicio(ConceptosServicios concepto_servicio) {
	this.concepto_servicio = concepto_servicio;
}

public List<HistorialReceta> getHistorial_receta() {
	return historial_receta;
}

public void setHistorial_receta(List<HistorialReceta> historial_receta) {
	this.historial_receta = historial_receta;
}

public List<HistorialMedicoServicio> getHistorial_medico_servicio() {
	return historial_medico_servicio;
}

public void setHistorial_medico_servicio(List<HistorialMedicoServicio> historial_medico_servicio) {
	this.historial_medico_servicio = historial_medico_servicio;
}

@Override
public String toString() {
	return "HistorialMedico [idHistorialMedico=" + idHistorialMedico + ", Oberservacion=" + Observacion + ", fecha="
			+ Fecha + ", estado=" + estado + ", registro=" + registro + ", modificacion=" + modificacion
			+ ", asegurado=" + asegurado + ", concepto_servicio=" + concepto_servicio + ", historial_receta="
			+ historial_receta + ", historial_medico_servicio=" + historial_medico_servicio + "]";
}

}
