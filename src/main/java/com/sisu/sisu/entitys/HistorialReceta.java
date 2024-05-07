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
@Table(name = "historial_receta")
public class HistorialReceta implements Serializable {
  private static long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_historial_receta")
  private Integer idHistorialReceta;

  @Column(name = "estado")
  private String estado;

  @Column(name = "registro")
  @Temporal(TemporalType.TIMESTAMP)
  private Date registro;

  @Column(name = "modificacion")
  @Temporal(TemporalType.TIMESTAMP)
  private Date modificacion;

  //----------------------------------------------------------------

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idReceta")
  private Receta receta;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "idHistorialMedico")
  private HistorialMedico historial_medico;

public HistorialReceta() {
	super(); 
}

public HistorialReceta(Integer idHistorialReceta, String estado, Date registro, Date modificacion, Receta receta,
		HistorialMedico historial_medico) {
	super();
	this.idHistorialReceta = idHistorialReceta;
	this.estado = estado;
	this.registro = registro;
	this.modificacion = modificacion;
	this.receta = receta;
	this.historial_medico = historial_medico;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

public static void setSerialversionuid(long serialversionuid) {
	serialVersionUID = serialversionuid;
}

public Integer getIdHistorialReceta() {
	return idHistorialReceta;
}

public void setIdHistorialReceta(Integer idHistorialReceta) {
	this.idHistorialReceta = idHistorialReceta;
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

public Receta getReceta() {
	return receta;
}

public void setReceta(Receta receta) {
	this.receta = receta;
}

public HistorialMedico getHistorial_medico() {
	return historial_medico;
}

public void setHistorial_medico(HistorialMedico historial_medico) {
	this.historial_medico = historial_medico;
}

@Override
public String toString() {
	return "HistorialReceta [idHistorialReceta=" + idHistorialReceta + ", estado=" + estado + ", registro=" + registro
			+ ", modificacion=" + modificacion + ", receta=" + receta + ", historial_medico=" + historial_medico + "]";
}
  
  
  
  
  
  
}
