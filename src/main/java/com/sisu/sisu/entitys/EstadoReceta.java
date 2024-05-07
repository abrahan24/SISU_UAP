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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "estado_receta")
public class EstadoReceta implements Serializable {
    private static int MY_CONSTANT = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estado_receta")
    private Integer idEstadoReceta;

    @Column(name = "nombre_estado")
    private String nombreEstado;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;

    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    // -----------------RELACIONES-----------------------------------------------

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado_receta", fetch = FetchType.LAZY)
    private List<Receta> receta;

	public EstadoReceta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstadoReceta(Integer idEstadoReceta, String nombreEstado, String descripcion, String estado, Date registro,
			Date modificacion, List<Receta> receta) {
		super();
		this.idEstadoReceta = idEstadoReceta;
		this.nombreEstado = nombreEstado;
		this.descripcion = descripcion;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
		this.receta = receta;
	}

	public static int getMyConstant() {
		return MY_CONSTANT;
	}

	public static void setMyConstant(int myConstant) {
		MY_CONSTANT = myConstant;
	}

	public Integer getIdEstadoReceta() {
		return idEstadoReceta;
	}

	public void setIdEstadoReceta(Integer idEstadoReceta) {
		this.idEstadoReceta = idEstadoReceta;
	}

	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
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

	public List<Receta> getReceta() {
		return receta;
	}

	public void setReceta(List<Receta> receta) {
		this.receta = receta;
	}

	@Override
	public String toString() {
		return "EstadoReceta [idEstadoReceta=" + idEstadoReceta + ", nombreEstado=" + nombreEstado + ", descripcion="
				+ descripcion + ", estado=" + estado + ", registro=" + registro + ", modificacion=" + modificacion
				+ ", receta=" + receta + "]";
	}
    
    
	
	
    
    
    
}
