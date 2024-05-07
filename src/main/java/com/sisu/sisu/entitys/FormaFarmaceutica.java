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
@Table(name = "forma_farmaceutica")
public class FormaFarmaceutica implements Serializable {
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forma_farmaceutica")
    private Integer idFormaFarmaceutica;

    @Column(name = "nombre_forma_farmaceutica")
    private String nombreFormaFarmaceutica;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estadoFF")
    private String estadoFF;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;


    //------------------------RELACIONES----------------------------------------

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "forma_farmaceutica", fetch = FetchType.LAZY)
	private List<ListaLiname> lista_liname;


	public FormaFarmaceutica() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FormaFarmaceutica(Integer idFormaFarmaceutica, String nombreFormaFarmaceutica, String descripcion,
			String estadoFF, Date registro, Date modificacion, List<ListaLiname> lista_liname) {
		super();
		this.idFormaFarmaceutica = idFormaFarmaceutica;
		this.nombreFormaFarmaceutica = nombreFormaFarmaceutica;
		this.descripcion = descripcion;
		this.estadoFF = estadoFF;
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


	public Integer getIdFormaFarmaceutica() {
		return idFormaFarmaceutica;
	}


	public void setIdFormaFarmaceutica(Integer idFormaFarmaceutica) {
		this.idFormaFarmaceutica = idFormaFarmaceutica;
	}


	public String getNombreFormaFarmaceutica() {
		return nombreFormaFarmaceutica;
	}


	public void setNombreFormaFarmaceutica(String nombreFormaFarmaceutica) {
		this.nombreFormaFarmaceutica = nombreFormaFarmaceutica;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getEstadoFF() {
		return estadoFF;
	}


	public void setEstadoFF(String estadoFF) {
		this.estadoFF = estadoFF;
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
		return "FormaFarmaceutica [idFormaFarmaceutica=" + idFormaFarmaceutica + ", nombreFormaFarmaceutica="
				+ nombreFormaFarmaceutica + ", descripcion=" + descripcion + ", estadoFF=" + estadoFF + ", registro="
				+ registro + ", modificacion=" + modificacion + ", lista_liname=" + lista_liname + "]";
	}
    
    
    
    
    
    
    
    
}
