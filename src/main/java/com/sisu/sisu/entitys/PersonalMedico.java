package com.sisu.sisu.entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Setter
@Getter
@Table(name = "personal_medico")
public class PersonalMedico implements Serializable{
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personal_medico")
    private Integer idPersonalMedico;

    @Column(name = "fecha_inico")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date fechaInicio;

    @Column(name = "fecha_final")
	@DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private Date fechaFinal;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    @Column(name = "especialidad")
    private String especialidad;

    //---------------------RELACIONES-------------------------------------------

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPersona")
    private Persona persona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoRegistroMedico")
    private TipoRegistroMedico tipo_registro_medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idTipoPersonalMedico")
    private TipoPersonalMedico tipo_personal_medico;

   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personal_medico", fetch = FetchType.LAZY)
	  private List<MedicoServicio> medico_servicio;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personal_medico", fetch = FetchType.LAZY)
	  private List<PersonalMedicoTurno> personalMedicoTurno;

      @OneToMany(cascade = CascadeType.ALL, mappedBy = "personal_medico", fetch = FetchType.LAZY)
	  private List<PersonalMedicoFicha> personalMedicoFicha;

      @OneToMany(cascade = CascadeType.ALL, mappedBy = "personal_medico", fetch = FetchType.LAZY)
	  private List<HorarioMedico> horarioMedico;




}
