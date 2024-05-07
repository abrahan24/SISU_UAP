package com.sisu.sisu.entitys;

import java.io.Serializable;

import javax.persistence.Basic;
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
@Getter
@Setter
@Table(name = "enlace")
public class Enlace implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_enlace")
    private Integer idEnlace;

    @Column(name = "estado")
    private String estado;

    @Column(name = "enlace")
    private String nombre_enlace;

    @Column(name = "ruta")
    private String ruta;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "tabla")
    private Integer tabla;

    @Column(name = "obs")
    private String obs;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario id_usuario;

    public Enlace(Integer idEnlace, String estado, String nombre_enlace, String ruta, String imagen, Integer tabla, String obs,
            Usuario id_usuario) {
        super();
        this.idEnlace = idEnlace;
        this.estado = estado;
        this.nombre_enlace = nombre_enlace;
        this.ruta = ruta;
        this.imagen = imagen;
        this.tabla = tabla;
        this.obs = obs;
        this.id_usuario = id_usuario;
    }

    public Enlace() {

    }

    public Integer getIdEnlace() {
        return idEnlace;
    }

    public void setIdEnlace(Integer idEnlace) {
        this.idEnlace = idEnlace;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre_enlace() {
        return nombre_enlace;
    }

    public void setNombre_enlace(String nombre_enlace) {
        this.nombre_enlace = nombre_enlace;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getTabla() {
        return tabla;
    }

    public void setTabla(Integer tabla) {
        this.tabla = tabla;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }
    

 }
