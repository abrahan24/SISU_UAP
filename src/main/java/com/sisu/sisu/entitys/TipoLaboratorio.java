package com.sisu.sisu.entitys;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tipo_laboratorio")
@Setter
@Getter
public class TipoLaboratorio implements Serializable{
    
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tipo_laboratorio;

    private String nombre;

    private String estado;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;
}
