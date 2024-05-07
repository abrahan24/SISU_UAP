package com.sisu.sisu.entitys;

import java.io.Serializable;
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

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipo_receta")
public class TipoReceta implements Serializable{
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_receta")
    private Integer idTipoRe;

    @Column(name = "descripcion_receta")
    private String descripcionReceta;

     @Column(name = "vigencia_receta")
    private String vigencia_receta;

    @Column(name = "estado")
    private String estado;
    
    @Column(name = "registro")
    private String registro;
    
    @Column(name = "modificacion")  
    private String modificacion;    

    //-------------------RELACIONES---------------------------------------------

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo_receta", fetch = FetchType.LAZY)
	private List<Receta> receta;

	public TipoReceta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoReceta(Integer idTipoRe, String descripcionReceta, String vigencia_receta, String estado,
			String registro, String modificacion, List<Receta> receta) {
		super();
		this.idTipoRe = idTipoRe;
		this.descripcionReceta = descripcionReceta;
		this.vigencia_receta = vigencia_receta;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
		this.receta = receta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdTipoRe() {
		return idTipoRe;
	}

	public void setIdTipoRe(Integer idTipoRe) {
		this.idTipoRe = idTipoRe;
	}

	public String getDescripcionReceta() {
		return descripcionReceta;
	}

	public void setDescripcionReceta(String descripcionReceta) {
		this.descripcionReceta = descripcionReceta;
	}

	public String getVigencia_receta() {
		return vigencia_receta;
	}

	public void setVigencia_receta(String vigencia_receta) {
		this.vigencia_receta = vigencia_receta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getModificacion() {
		return modificacion;
	}

	public void setModificacion(String modificacion) {
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
		return "TipoReceta [idTipoRe=" + idTipoRe + ", descripcionReceta=" + descripcionReceta + ", vigencia_receta="
				+ vigencia_receta + ", estado=" + estado + ", registro=" + registro + ", modificacion=" + modificacion
				+ ", receta=" + receta + "]";
	}
    
    
    
    
    
    
}

