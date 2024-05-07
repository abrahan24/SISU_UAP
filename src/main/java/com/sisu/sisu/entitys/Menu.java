package com.sisu.sisu.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "menues")
@Setter
@Getter
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private Integer idMenu;

    @Column(name = "estado")
    private String idEstado;

    @JoinColumn(name = "id_enlace", referencedColumnName = "id_enlace")
    @ManyToOne(optional = false)
    private Enlace idEnlace;

    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    @ManyToOne(optional = false)
    private Roles idRol;
    
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario id_usuario;

    public Menu() {

    }

    public Menu(Integer idMenu, String idEstado, Enlace idEnlace, Roles idRol, Usuario id_usuario) {
        super();
        this.idMenu = idMenu;
        this.idEstado = idEstado;
        this.idEnlace = idEnlace;
        this.idRol = idRol;
        this.id_usuario = id_usuario;
    }

    public Integer getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Integer idMenu) {
        this.idMenu = idMenu;
    }

    public String getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public Enlace getIdEnlace() {
        return idEnlace;
    }

    public void setIdEnlace(Enlace idEnlace) {
        this.idEnlace = idEnlace;
    }

    public Roles getIdRol() {
        return idRol;
    }

    public void setIdRol(Roles idRol) {
        this.idRol = idRol;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

	@Override
	public String toString() {
		return "Menu [idMenu=" + idMenu + ", idEstado=" + idEstado + ", idEnlace=" + idEnlace + ", idRol=" + idRol
				+ ", id_usuario=" + id_usuario + "]";
	}
    
    
    
    
    
    
    
    
    

}
