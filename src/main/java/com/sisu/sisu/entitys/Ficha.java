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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "ficha")
public class Ficha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_ficha")
    private Integer idFicha;

    @Column(name = "fecha_registro_ficha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistroFichaa;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;

    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    // ----------------------------------------------------------------

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAsegurado")
    private Asegurado asegurado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idServicioMedico")
    private ServicioMedico servicioMedico;

    @Column(name = "horario")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horario;

    public String getCodigoAsegurado() {
        // Lógica para obtener el código del Asegurado desde la Ficha
        return this.asegurado.getCodigoAsegurado();
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ficha", fetch = FetchType.LAZY)
	  private List<PersonalMedicoFicha> personalMedicoFicha;

  

 
}
