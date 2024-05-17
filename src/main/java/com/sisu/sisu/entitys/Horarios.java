package com.sisu.sisu.entitys;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "horarios")
public class Horarios implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_horario")
    private Integer idHorario;

      @Column(name = "fecha_registro_ficha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistroFichaa;

    @Column(name = "estado")
    private String estado;


    @Column(name = "horario")
    private LocalDateTime horario;

    @Column(name = "dia")
    private String dia;

    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horarios", fetch = FetchType.LAZY)
	private List<HorarioServicio> horarioServicio;


}
