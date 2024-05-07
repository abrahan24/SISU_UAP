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

	public Receta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Receta(Integer idReceta, Date fecha, String prescripcionMedica, Date registro, Date modificacion,
			String estado, List<RecetaRemedios> receta_remedios, List<HistorialReceta> historial_receta,
			TipoReceta tipo_receta, EstadoReceta estado_receta) {
		super();
		this.idReceta = idReceta;
		this.fecha = fecha;
		this.prescripcionMedica = prescripcionMedica;
		this.registro = registro;
		this.modificacion = modificacion;
		this.estado = estado;
		this.receta_remedios = receta_remedios;
		this.historial_receta = historial_receta;
		this.tipo_receta = tipo_receta;
		this.estado_receta = estado_receta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(Integer idReceta) {
		this.idReceta = idReceta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getPrescripcionMedica() {
		return prescripcionMedica;
	}

	public void setPrescripcionMedica(String prescripcionMedica) {
		this.prescripcionMedica = prescripcionMedica;
	}

	public Date getRegistro() {
		return registro;
	}

	public void setRegistro(Date registro) {
		this.registro = registro;
	}

	public Date getModificacion() {
		return modificacion;
	}

	public void setModificacion(Date modificacion) {
		this.modificacion = modificacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<RecetaRemedios> getReceta_remedios() {
		return receta_remedios;
	}

	public void setReceta_remedios(List<RecetaRemedios> receta_remedios) {
		this.receta_remedios = receta_remedios;
	}

	public List<HistorialReceta> getHistorial_receta() {
		return historial_receta;
	}

	public void setHistorial_receta(List<HistorialReceta> historial_receta) {
		this.historial_receta = historial_receta;
	}

	public TipoReceta getTipo_receta() {
		return tipo_receta;
	}

	public void setTipo_receta(TipoReceta tipo_receta) {
		this.tipo_receta = tipo_receta;
	}

	public EstadoReceta getEstado_receta() {
		return estado_receta;
	}

	public void setEstado_receta(EstadoReceta estado_receta) {
		this.estado_receta = estado_receta;
	}

	@Override
	public String toString() {
		return "Receta [idReceta=" + idReceta + ", fecha=" + fecha + ", prescripcionMedica=" + prescripcionMedica
				+ ", registro=" + registro + ", modificacion=" + modificacion + ", estado=" + estado
				+ ", receta_remedios=" + receta_remedios + ", historial_receta=" + historial_receta + ", tipo_receta="
				+ tipo_receta + ", estado_receta=" + estado_receta + "]";
	}
    
    
    
    
    

}
