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

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "laboratorio")
public class Laboratorio implements Serializable {


    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laboratorio")
    private Integer idLaboratorio;

    @Column(name = "nombre_laboratorio")
    private String nombre_laboratorio;

    @Column(name = "descripcion", length = 1000)
    private String descripcion;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    @Column(name = "estado")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_laboratorio")
	private TipoLaboratorio tipoLaboratorio;



    //-------------------RELACIONES---------------------------------------------

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "laboratorio", fetch = FetchType.LAZY)
	private List<RecetaLaboratorios> receta_laboratorios;


    
  
	
    
    
    
    
    

}
