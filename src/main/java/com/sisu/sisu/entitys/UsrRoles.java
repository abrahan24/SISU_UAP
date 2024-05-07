package com.sisu.sisu.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="usr_roles")
public class UsrRoles implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usr_rol")
    private Integer idUsrRol;
    
    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;
    
   @Column(name = "estado")
   private String estado;
   
   @Column(name = "descripcion")
   private String descripcion;
   
   @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
   @ManyToOne(optional = false)
   private Roles idRol;

   @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
   @ManyToOne(optional = false)
   private Usuario idUsuario;

public UsrRoles() {
	super();
	// TODO Auto-generated constructor stub
}

public UsrRoles(Integer idUsrRol, Date registro, Date modificacion, String estado, String descripcion, Roles idRol,
		Usuario idUsuario) {
	super();
	this.idUsrRol = idUsrRol;
	this.registro = registro;
	this.modificacion = modificacion;
	this.estado = estado;
	this.descripcion = descripcion;
	this.idRol = idRol;
	this.idUsuario = idUsuario;
}

public Integer getIdUsrRol() {
	return idUsrRol;
}

public void setIdUsrRol(Integer idUsrRol) {
	this.idUsrRol = idUsrRol;
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

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public Roles getIdRol() {
	return idRol;
}

public void setIdRol(Roles idRol) {
	this.idRol = idRol;
}

public Usuario getIdUsuario() {
	return idUsuario;
}

public void setIdUsuario(Usuario idUsuario) {
	this.idUsuario = idUsuario;
}

@Override
public String toString() {
	return "UsrRoles [idUsrRol=" + idUsrRol + ", registro=" + registro + ", modificacion=" + modificacion + ", estado="
			+ estado + ", descripcion=" + descripcion + ", idRol=" + idRol + ", idUsuario=" + idUsuario + "]";
}
   
  
   
    
}
