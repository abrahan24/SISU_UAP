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
@Table(name = "tipo_personal_medico")
public class TipoPersonalMedico implements Serializable{
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_personal_medico")
    private Integer idTipoPersonalMedico;

    @Column(name = "tipo_personal")
    private String tipoPersonal;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo_personal_medico", fetch = FetchType.LAZY)
	private List<PersonalMedico> personal_medico;

public TipoPersonalMedico() {
	super();
	// TODO Auto-generated constructor stub
}

public TipoPersonalMedico(Integer idTipoPersonalMedico, String tipoPersonal, String descripcion, String estado,
		Date registro, Date modificacion, List<PersonalMedico> personal_medico) {
	super();
	this.idTipoPersonalMedico = idTipoPersonalMedico;
	this.tipoPersonal = tipoPersonal;
	this.descripcion = descripcion;
	this.estado = estado;
	this.registro = registro;
	this.modificacion = modificacion;
	this.personal_medico = personal_medico;
}

public static long getSerialversionuid() {
	return serialVersionUID;
}

public static void setSerialversionuid(long serialversionuid) {
	serialVersionUID = serialversionuid;
}

public Integer getIdTipoPersonalMedico() {
	return idTipoPersonalMedico;
}

public void setIdTipoPersonalMedico(Integer idTipoPersonalMedico) {
	this.idTipoPersonalMedico = idTipoPersonalMedico;
}

public String getTipoPersonal() {
	return tipoPersonal;
}

public void setTipoPersonal(String tipoPersonal) {
	this.tipoPersonal = tipoPersonal;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
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

public List<PersonalMedico> getPersonal_medico() {
	return personal_medico;
}

public void setPersonal_medico(List<PersonalMedico> personal_medico) {
	this.personal_medico = personal_medico;
}

@Override
public String toString() {
	return "TipoPersonalMedico [idTipoPersonalMedico=" + idTipoPersonalMedico + ", tipoPersonal=" + tipoPersonal
			+ ", descripcion=" + descripcion + ", estado=" + estado + ", registro=" + registro + ", modificacion="
			+ modificacion + ", personal_medico=" + personal_medico + "]";
}
  
  
  
  



    
}
