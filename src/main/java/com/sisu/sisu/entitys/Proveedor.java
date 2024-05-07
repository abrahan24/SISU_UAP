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

@Entity
@Setter
@Getter
@Table(name = "proveedor")
public class Proveedor implements Serializable{
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Integer idProveedor;

    @Column(name = "nombre_proveedor")
    private String nombreProveedor;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "nit")
    private String NIT;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "estado_proveedor")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;


    //----------------------RELACIONES------------------------------------------

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor", fetch = FetchType.LAZY)
	private List<RemedioLote> remedio_lote;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipoProveedor")
    private TipoProveedor tipo_proveedor;

	public Proveedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proveedor(Integer idProveedor, String nombreProveedor, String descripcion, String nIT, String direccion,
			String estado, Date registro, Date modificacion, List<RemedioLote> remedio_lote,
			TipoProveedor tipo_proveedor) {
		super();
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.descripcion = descripcion;
		NIT = nIT;
		this.direccion = direccion;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
		this.remedio_lote = remedio_lote;
		this.tipo_proveedor = tipo_proveedor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
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

	public String getNIT() {
		return NIT;
	}

	public void setNIT(String nIT) {
		NIT = nIT;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public List<RemedioLote> getRemedio_lote() {
		return remedio_lote;
	}

	public void setRemedio_lote(List<RemedioLote> remedio_lote) {
		this.remedio_lote = remedio_lote;
	}

	public TipoProveedor getTipo_proveedor() {
		return tipo_proveedor;
	}

	public void setTipo_proveedor(TipoProveedor tipo_proveedor) {
		this.tipo_proveedor = tipo_proveedor;
	}

	// @Override
	// public String toString() {
	// 	return "Proveedor [idProveedor=" + idProveedor + ", nombreProveedor=" + nombreProveedor + ", descripcion="
	// 			+ descripcion + ", NIT=" + NIT + ", direccion=" + direccion + ", estado=" + estado + ", registro="
	// 			+ registro + ", modificacion=" + modificacion + ", remedio_lote=" + remedio_lote + ", tipo_proveedor="
	// 			+ tipo_proveedor + "]";
	// }

}
