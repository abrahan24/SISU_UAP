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
@Table(name = "tipo_seguro")
public class TipoSeguro implements Serializable{
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_seguro")
    private Integer idTipoSeguro;

    @Column(name = "tipo_seguro")
    private String tipoSeguro;

    @Column(name = "descripcion_seguro")
    private String descripcionSeguro;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    //----------------Relaciones

 @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo_seguro", fetch = FetchType.LAZY)
	private List<HistorialSeguro> historial_seguro;

public TipoSeguro() {
	super();
	// TODO Auto-generated constructor stub
}

public TipoSeguro(Integer idTipoSeguro, String tipoSeguro, String descripcionSeguro, String estado, Date registro,
		Date modificacion, List<HistorialSeguro> historial_seguro) {
	super();
	this.idTipoSeguro = idTipoSeguro;
	this.tipoSeguro = tipoSeguro;
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

public Integer getIdTipoSeguro() {
	return idTipoSeguro;
}

public void setIdTipoSeguro(Integer idTipoSeguro) {
	this.idTipoSeguro = idTipoSeguro;
}

public String getTipoSeguro() {
	return tipoSeguro;
}

public void setTipoSeguro(String tipoSeguro) {
	this.tipoSeguro = tipoSeguro;
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
	return "TipoSeguro [idTipoSeguro=" + idTipoSeguro + ", tipoSeguro=" + tipoSeguro + ", descripcionSeguro="
			+ descripcionSeguro + ", estado=" + estado + ", registro=" + registro + ", modificacion=" + modificacion
			+ ", historial_seguro=" + historial_seguro + "]";
}
 
 
 
 

}
