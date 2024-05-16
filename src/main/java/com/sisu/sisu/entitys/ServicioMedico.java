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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "servicio_medico")
public class ServicioMedico implements Serializable {

	private static long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_servicio_medico")
	private Integer idServicioMedico;

	@Column(name = "cantidad_fichas")
	private Integer cantidad_fichas;

	@Column(name = "estado")
	private String estado;

	@Column(name = "registro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;

	@Column(name = "modificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificacion;

	// --------------------------RELACION--------------------------------------

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "servicio_medico", fetch = FetchType.LAZY)
	private List<MedicoServicio> medico_servicio;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioMedico", fetch = FetchType.LAZY)
	private List<Ficha> ficha;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "servicioMedico", fetch = FetchType.LAZY)
	private List<HorarioServicio> horarioServicio;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idServicio")
	private Servicio servicio;

	

}
