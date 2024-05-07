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
@Table(name = "personal_medico")
public class PersonalMedico implements Serializable{
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personal_medico")
    private Integer idPersonalMedico;

    @Column(name = "fecha_inico")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date fechaInicio;

    @Column(name = "fecha_final")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date fechaFinal;

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
    @JoinColumn(name = "idPersona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoRegistroMedico")
    private TipoRegistroMedico tipo_registro_medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoPersonalMedico")
    private TipoPersonalMedico tipo_personal_medico;

   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personal_medico", fetch = FetchType.LAZY)
	  private List<MedicoServicio> medico_servicio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personal_medico", fetch = FetchType.LAZY)
	  private List<PersonalMedicoTurno> personalMedicoTurno;
/* 
	public PersonalMedico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonalMedico(Integer idPersonalMedico, Date fechaInicio, Date fechaFinal, String estado, Date registro,
			Date modificacion, Persona persona, TipoRegistroMedico tipo_registro_medico,
			TipoPersonalMedico tipo_personal_medico, List<MedicoServicio> medico_servicio,
			List<PersonalMedicoTurno> personalMedicoTurno) {
		super();
		this.idPersonalMedico = idPersonalMedico;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
		this.persona = persona;
		this.tipo_registro_medico = tipo_registro_medico;
		this.tipo_personal_medico = tipo_personal_medico;
		this.medico_servicio = medico_servicio;
		this.personalMedicoTurno = personalMedicoTurno;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdPersonalMedico() {
		return idPersonalMedico;
	}

	public void setIdPersonalMedico(Integer idPersonalMedico) {
		this.idPersonalMedico = idPersonalMedico;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
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

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public TipoRegistroMedico getTipo_registro_medico() {
		return tipo_registro_medico;
	}

	public void setTipo_registro_medico(TipoRegistroMedico tipo_registro_medico) {
		this.tipo_registro_medico = tipo_registro_medico;
	}

	public TipoPersonalMedico getTipo_personal_medico() {
		return tipo_personal_medico;
	}

	public void setTipo_personal_medico(TipoPersonalMedico tipo_personal_medico) {
		this.tipo_personal_medico = tipo_personal_medico;
	}

	public List<MedicoServicio> getMedico_servicio() {
		return medico_servicio;
	}

	public void setMedico_servicio(List<MedicoServicio> medico_servicio) {
		this.medico_servicio = medico_servicio;
	}

	public List<PersonalMedicoTurno> getPersonalMedicoTurno() {
		return personalMedicoTurno;
	}

	public void setPersonalMedicoTurno(List<PersonalMedicoTurno> personalMedicoTurno) {
		this.personalMedicoTurno = personalMedicoTurno;
	}

	@Override
	public String toString() {
		return "PersonalMedico [idPersonalMedico=" + idPersonalMedico + ", fechaInicio=" + fechaInicio + ", fechaFinal="
				+ fechaFinal + ", estado=" + estado + ", registro=" + registro + ", modificacion=" + modificacion
				+ ", persona=" + persona + ", tipo_registro_medico=" + tipo_registro_medico + ", tipo_personal_medico="
				+ tipo_personal_medico + ", medico_servicio=" + medico_servicio + ", personalMedicoTurno="
				+ personalMedicoTurno + "]";
	}

    
    
    
*/
}
