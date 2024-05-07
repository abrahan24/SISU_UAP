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
@Table(name = "receta_remedios")
public class RecetaRemedios implements Serializable{
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receta_remedios")
    private Integer idRecetaRemedios;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    //-----------------RELACIONES-----------------------------------------------

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idReceta")
    private Receta receta;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRemediosFarmacia")
    private RemediosFarmacia remedios_farmacia;

	public RecetaRemedios() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecetaRemedios(Integer idRecetaRemedios, String estado, Date registro, Date modificacion, Receta receta,
			RemediosFarmacia remedios_farmacia) {
		super();
		this.idRecetaRemedios = idRecetaRemedios;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
		this.receta = receta;
		this.remedios_farmacia = remedios_farmacia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdRecetaRemedios() {
		return idRecetaRemedios;
	}

	public void setIdRecetaRemedios(Integer idRecetaRemedios) {
		this.idRecetaRemedios = idRecetaRemedios;
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

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public RemediosFarmacia getRemedios_farmacia() {
		return remedios_farmacia;
	}

	public void setRemedios_farmacia(RemediosFarmacia remedios_farmacia) {
		this.remedios_farmacia = remedios_farmacia;
	}

	@Override
	public String toString() {
		return "RecetaRemedios [idRecetaRemedios=" + idRecetaRemedios + ", estado=" + estado + ", registro=" + registro
				+ ", modificacion=" + modificacion + ", receta=" + receta + ", remedios_farmacia=" + remedios_farmacia
				+ "]";
	}
    
    
    
    
    
    

}
