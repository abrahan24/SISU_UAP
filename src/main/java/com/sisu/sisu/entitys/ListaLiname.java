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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "lista_liname")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ListaLiname implements Serializable{
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista_liname")
    private Integer idLiname;

    @Column(name = "medicamento")
    private String medicamento;

    @Column(name = "concentracion")
    private String concentracion;

    @Column(name = "codigo_liname")
    private String codigoLiname;

    @Column(name = "fecha_incluido")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaIncluido;

    @Column(name = "fecha_excluido")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaExcluido;

    @Column(name = "estado_liname")
    private String estadoLiname;

    @Column(name = "codigo_ATQ")
    private String codigoATQ;



    @Column(name = "registro")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;


    //--------------------REMEDIOS--------------------------------------------

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lista_liname", fetch = FetchType.LAZY)
    private List<RemediosFarmacia> remedios_farmacia;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lista_liname", fetch = FetchType.LAZY)
    private List<HistorialLiname> historial_liname;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lista_liname", fetch = FetchType.LAZY)
    private List<RecetaRemedios> receta_remedios;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idFormaFarmaceutica")
    private FormaFarmaceutica forma_farmaceutica;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoUso")
    private TipoUso tipo_uso;

    // @JsonIgnore
    // @ManyToMany(cascade = CascadeType.ALL, mappedBy = "linames", fetch = FetchType.LAZY)
    // private List<Recetario> recetarios;



    
    
	
	
    
    
    
    

}
