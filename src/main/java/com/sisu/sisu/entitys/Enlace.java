package com.sisu.sisu.entitys;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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

    @ManyToMany(mappedBy = "enlaces")
    private Set<Roles> roles;
    
 }
