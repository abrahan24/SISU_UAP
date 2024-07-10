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

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "receta_laboratorios")
public class RecetaLaboratorios implements Serializable{
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receta_laboratorios")
    private Integer idRecetaLaboratorios;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;


    //-----------------RELACIONES-----------------------------------------------
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idReceta")
    private Receta receta;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_laboratorio")
    private Laboratorio laboratorio;



	
    
    
    
    
    
    

}
