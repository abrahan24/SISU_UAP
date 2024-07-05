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
@Getter
@Setter
@Table(name = "receta")
public class Receta implements Serializable {
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receta")
    private Integer idReceta;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "prescripcion_medica")
    private String prescripcionMedica;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    @Column(name = "estado")
    private String estado;
    //-------------------RELACIONES---------------------------------------------

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receta", fetch = FetchType.LAZY)
	private List<RecetaRemedios> receta_remedios;

     @OneToMany(cascade = CascadeType.ALL, mappedBy = "receta", fetch = FetchType.LAZY)
	private List<HistorialReceta> historial_receta;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipoRe")
    private TipoReceta tipo_receta;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEstadoReceta")
    private EstadoReceta estado_receta;

	
    
    
    
    
    

}
