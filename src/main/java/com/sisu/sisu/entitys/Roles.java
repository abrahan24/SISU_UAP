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
@Table(name = "roles")
@Setter
@Getter
public class Roles implements Serializable {

	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Integer idRol;
	
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "estado")
    private String estado;
    
    @Column(name = "simbolo")
    private String simbolo;
    
    @Column(name = "rol")
    private String rol;
    
    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;
    
    @Column(name = "observacion")
    private String observacion;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idRol", fetch = FetchType.LAZY)
    private List<Menu> menus_roles;

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(Integer idRol, String descripcion, String estado, String simbolo, String rol, Date registro,
			Date modificacion, String observacion) {
		super();
		this.idRol = idRol;
		this.descripcion = descripcion;
		this.estado = estado;
		this.simbolo = simbolo;
		this.rol = rol;
		this.registro = registro;
		this.modificacion = modificacion;
		this.observacion = observacion;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
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

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
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

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Override
	public String toString() {
		return "Roles [idRol=" + idRol + ", descripcion=" + descripcion + ", estado=" + estado + ", simbolo=" + simbolo
				+ ", rol=" + rol + ", registro=" + registro + ", modificacion=" + modificacion + ", observacion="
				+ observacion + "]";
	}
	
    
    
	
	
    
    
    
    
	
	
}
