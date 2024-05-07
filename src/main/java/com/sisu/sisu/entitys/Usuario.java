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

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "usuarios")
public class Usuario implements Serializable {

	private static long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer idUsuario;

	@Column(name = "apodo")
	private String apodo;

	@Column(name = "clave")
	private String clave;

	@Column(name = "estado")
	private String estado_usuario;

	@Column(name = "registro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;

	@Column(name = "modificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificacion;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_usuario", fetch = FetchType.LAZY)
    private List<Menu> menus;

  public String getApodo() {
    return apodo;
  }

	// --------------------------RELACION--------------------------------------

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPersona")
	private Persona persona;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<UsrRoles> usr_Roles;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer idUsuario, String apodo, String clave, String estado_usuario, Date registro,
			Date modificacion,
			Persona persona) {
		super();
		this.idUsuario = idUsuario;
		this.apodo = apodo;
		this.clave = clave;
		this.estado_usuario = estado_usuario;
		this.registro = registro;
		this.modificacion = modificacion;
		this.persona = persona;

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEstado_usuario() {
		return estado_usuario;
	}

	public void setEstado_usuario(String estado_usuario) {
		this.estado_usuario = estado_usuario;
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

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", apodo=" + apodo + ", clave=" + clave + ", estado_usuario="
				+ estado_usuario + ", registro=" + registro + ", modificacion=" + modificacion + ", persona=" + persona
				+ "]";
	}

}