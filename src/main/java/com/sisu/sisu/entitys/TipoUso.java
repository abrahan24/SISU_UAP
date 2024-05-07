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

@Entity
@Setter
@Getter
@Table(name = "tipo_uso")
public class TipoUso implements Serializable{
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_uso")
    private Integer idTipoUso;

    @Column(name = "nombre_tipo_uso")
    private String nombreTipoUso;

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

    //------------------------RELACIONES----------------------------------------

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo_uso", fetch = FetchType.LAZY)
	private List<ListaLiname> lista_liname;

	public TipoUso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoUso(Integer idTipoUso, String nombreTipoUso, String descripcion, String estado, Date registro,
			Date modificacion, List<ListaLiname> lista_liname) {
		super();
		this.idTipoUso = idTipoUso;
		this.nombreTipoUso = nombreTipoUso;
		this.descripcion = descripcion;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
		this.lista_liname = lista_liname;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdTipoUso() {
		return idTipoUso;
	}

	public void setIdTipoUso(Integer idTipoUso) {
		this.idTipoUso = idTipoUso;
	}

	public String getNombreTipoUso() {
		return nombreTipoUso;
	}

	public void setNombreTipoUso(String nombreTipoUso) {
		this.nombreTipoUso = nombreTipoUso;
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

	public List<ListaLiname> getLista_liname() {
		return lista_liname;
	}

	public void setLista_liname(List<ListaLiname> lista_liname) {
		this.lista_liname = lista_liname;
	}

	@Override
	public String toString() {
		return "TipoUso [idTipoUso=" + idTipoUso + ", nombreTipoUso=" + nombreTipoUso + ", descripcion=" + descripcion
				+ ", estado=" + estado + ", registro=" + registro + ", modificacion=" + modificacion + ", lista_liname="
				+ lista_liname + "]";
	}
    
    
    
	
    
    
    

}
