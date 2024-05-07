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
@Table(name = "personal_medicoTurno")
public class PersonalMedicoTurno implements Serializable{
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personal_medico_turno")
    private Integer idPersonalMedicoTurno;

    @Column(name = "fecha_turno")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date fechaTurno;

    @Column(name = "fecha_registro")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date fechaRegistro;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;

    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    //---------------------RELACIONES-------------------------------------------

   @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPersonalMedico")
    private PersonalMedico personal_medico;

public PersonalMedicoTurno() {
	super();
	// TODO Auto-generated constructor stub
}

public PersonalMedicoTurno(Integer idPersonalMedicoTurno, Date fechaTurno, Date fechaRegistro, String estado,
		Date registro, Date modificacion, PersonalMedico personal_medico) {
	super();
	this.idPersonalMedicoTurno = idPersonalMedicoTurno;
	this.fechaTurno = fechaTurno;
	this.fechaRegistro = fechaRegistro;
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

public Integer getIdPersonalMedicoTurno() {
	return idPersonalMedicoTurno;
}

public void setIdPersonalMedicoTurno(Integer idPersonalMedicoTurno) {
	this.idPersonalMedicoTurno = idPersonalMedicoTurno;
}

public Date getFechaTurno() {
	return fechaTurno;
}

public void setFechaTurno(Date fechaTurno) {
	this.fechaTurno = fechaTurno;
}

public Date getFechaRegistro() {
	return fechaRegistro;
}

public void setFechaRegistro(Date fechaRegistro) {
	this.fechaRegistro = fechaRegistro;
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

public PersonalMedico getPersonal_medico() {
	return personal_medico;
}

public void setPersonal_medico(PersonalMedico personal_medico) {
	this.personal_medico = personal_medico;
}

@Override
public String toString() {
	return "PersonalMedicoTurno [idPersonalMedicoTurno=" + idPersonalMedicoTurno + ", fechaTurno=" + fechaTurno
			+ ", fechaRegistro=" + fechaRegistro + ", estado=" + estado + ", registro=" + registro + ", modificacion="
			+ modificacion + ", personal_medico=" + personal_medico + "]";
}
   
   
   
   
   
    
}
