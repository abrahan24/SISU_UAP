package com.sisu.sisu.entitys;

import java.io.Serializable;
import java.time.LocalDate;
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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orden_laboratorio")
@Setter
@Getter
public class OrdenLaboratorio implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_orden_laboratorio;

    private LocalDate fecha_solicitud;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_paciente")
	private Asegurado  asegurado;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_personal_medico")
	private PersonalMedico  personalMedico;

    private String estado_orden;
    
    private String estado;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;
}
