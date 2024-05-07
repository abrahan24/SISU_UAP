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
@Table(name = "tipo_proveedor")
public class TipoProveedor implements Serializable{
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_proveedor")
    private Integer idTipoProveedor;

    @Column(name = "nombre_proveedor")
    private String nombreProveedor;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "estado_proveedor")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    //-----------------RELACIONES-----------------------------------------------

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipo_proveedor", fetch = FetchType.LAZY)
	private List<Proveedor> proveedor;

	public TipoProveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoProveedor(Integer idTipoProveedor, String nombreProveedor, String descripcion, String estado,
			Date registro, Date modificacion, List<Proveedor> proveedor) {
		super();
		this.idTipoProveedor = idTipoProveedor;
		this.nombreProveedor = nombreProveedor;
		this.descripcion = descripcion;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
		this.proveedor = proveedor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdTipoProveedor() {
		return idTipoProveedor;
	}

	public void setIdTipoProveedor(Integer idTipoProveedor) {
		this.idTipoProveedor = idTipoProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
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

	public List<Proveedor> getProveedor() {
		return proveedor;
	}

	public void setProveedor(List<Proveedor> proveedor) {
		this.proveedor = proveedor;
	}

	// @Override
	// public String toString() {
	// 	return "TipoProveedor [idTipoProveedor=" + idTipoProveedor + ", nombreProveedor=" + nombreProveedor
	// 			+ ", descripcion=" + descripcion + ", estado=" + estado + ", registro=" + registro + ", modificacion="
	// 			+ modificacion + ", proveedor=" + proveedor + "]";
	// }  

	
}
