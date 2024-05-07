package com.sisu.sisu.entitys;

import java.io.Serializable;
import java.time.LocalDate;
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

@Setter
@Getter
@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Integer idPersona;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "ap_paterno")
    private String apPaterno;

    @Column(name = "ap_materno")
    private String apMaterno;

    @Column(name = "ci")
    private String ci;

    @Column(name = "fecha_nacimiento")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_nac;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "celular")
    private Integer celular;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;

    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    // --------------------------RELACION--------------------------------------

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
    private List<Usuario> usuarios;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idGradoAcademico")
    private GradoAcademico grado_academico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoEstadoCivil")
    private TiposEstadoCivil tipos_estado_civil;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDip")
    private Dip dip;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
    private List<Asegurado> asegurado;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona", fetch = FetchType.LAZY)
    private List<PersonalMedico> personal_medico;


	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Persona(Integer idPersona, String nombres, String apPaterno, String apMaterno, String ci,
			LocalDate fecha_nac, String sexo, String direccion, Integer celular, String estado, Date registro,
			Date modificacion, List<Usuario> usuarios, GradoAcademico grado_academico,
			TiposEstadoCivil tipos_estado_civil, Dip dip, List<Asegurado> asegurado,
			List<PersonalMedico> personal_medico) {
		super();
		this.idPersona = idPersona;
		this.nombres = nombres;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.ci = ci;
		this.fecha_nac = fecha_nac;
		this.sexo = sexo;
		this.direccion = direccion;
		this.celular = celular;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
		this.usuarios = usuarios;
		this.grado_academico = grado_academico;
		this.tipos_estado_civil = tipos_estado_civil;
		this.dip = dip;
		this.asegurado = asegurado;
		this.personal_medico = personal_medico;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}


	public Integer getIdPersona() {
		return idPersona;
	}


	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApPaterno() {
		return apPaterno;
	}


	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}


	public String getApMaterno() {
		return apMaterno;
	}


	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}


	public String getCi() {
		return ci;
	}


	public void setCi(String ci) {
		this.ci = ci;
	}


	public LocalDate getFecha_nac() {
		return fecha_nac;
	}


	public void setFecha_nac(LocalDate fecha_nac) {
		this.fecha_nac = fecha_nac;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Integer getCelular() {
		return celular;
	}


	public void setCelular(Integer celular) {
		this.celular = celular;
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


	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}


	public GradoAcademico getGrado_academico() {
		return grado_academico;
	}


	public void setGrado_academico(GradoAcademico grado_academico) {
		this.grado_academico = grado_academico;
	}


	public TiposEstadoCivil getTipos_estado_civil() {
		return tipos_estado_civil;
	}


	public void setTipos_estado_civil(TiposEstadoCivil tipos_estado_civil) {
		this.tipos_estado_civil = tipos_estado_civil;
	}


	public Dip getDip() {
		return dip;
	}


	public void setDip(Dip dip) {
		this.dip = dip;
	}


	public List<Asegurado> getAsegurado() {
		return asegurado;
	}


	public void setAsegurado(List<Asegurado> asegurado) {
		this.asegurado = asegurado;
	}


	public List<PersonalMedico> getPersonal_medico() {
		return personal_medico;
	}


	public void setPersonal_medico(List<PersonalMedico> personal_medico) {
		this.personal_medico = personal_medico;
	}


	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombres=" + nombres + ", apPaterno=" + apPaterno + ", apMaterno="
				+ apMaterno + ", ci=" + ci + ", fecha_nac=" + fecha_nac + ", sexo=" + sexo + ", direccion=" + direccion
				+ ", celular=" + celular + ", estado=" + estado + ", registro=" + registro + ", modificacion="
				+ modificacion + ", usuarios=" + usuarios + ", grado_academico=" + grado_academico
				+ ", tipos_estado_civil=" + tipos_estado_civil + ", dip=" + dip + ", asegurado=" + asegurado
				+ ", personal_medico=" + personal_medico + "]";
	}
    
    
    
    


}
