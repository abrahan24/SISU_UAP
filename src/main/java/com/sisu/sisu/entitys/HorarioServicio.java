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

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "horario_servicio")
public class HorarioServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_horario_servicio")
    private Integer idHorarioServicio;

    @Column(name = "cantidad_fichas")
	private Integer cantidad_fichas;

    @Column(name = "fecha_registro_ficha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistroFichaa;

    @Column(name = "estado")
    private String estado;

    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idServicioMedico")
    private ServicioMedico servicioMedico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idHorario")
    private Horarios horarios;
}
