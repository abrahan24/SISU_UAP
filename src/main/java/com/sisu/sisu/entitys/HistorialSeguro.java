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
@Setter
@Getter
@Table(name = "historial_seguro")
public class HistorialSeguro implements Serializable {
	private static long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_historial_seguro")
	private Integer idHistorialSeguro;


	@Column(name = "titularHS")
	private Boolean titularHS;

	@Column(name = "fecha_alta")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaAlta;

	@Column(name = "fecha_baja")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaBaja;

	@Column(name = "codigo_seguro_principal")
	private String codigoSeguroPrincipal;

	@Column(name = "estado")
	private String estado;

	@Column(name = "registro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registro;

	@Column(name = "modificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modificacion;

	// ------------------Relaciones ------

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tipo_seguro")
	private TipoSeguro tipo_seguro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estado_seguro")
	private EstadoSeguro estado_seguro;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_institucion")
	private Institucion institucion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_asegurado")
	private Asegurado asegurado;

		@OneToMany(cascade = CascadeType.ALL, mappedBy = "historialSeguro", fetch = FetchType.LAZY)
	private List<HistoriaClinica> historiaClinicas;

	public HistorialSeguro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HistorialSeguro(Integer idHistorialSeguro, Boolean titularHS, Date fechaAlta, Date fechaBaja,
			String codigoSeguroPrincipal, String estado, Date registro, Date modificacion, TipoSeguro tipo_seguro,
			EstadoSeguro estado_seguro, Institucion institucion, Asegurado asegurado) {
		super();
		this.idHistorialSeguro = idHistorialSeguro;
		this.titularHS = titularHS;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.codigoSeguroPrincipal = codigoSeguroPrincipal;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
		this.tipo_seguro = tipo_seguro;
		this.estado_seguro = estado_seguro;
		this.institucion = institucion;
		this.asegurado = asegurado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdHistorialSeguro() {
		return idHistorialSeguro;
	}

	public void setIdHistorialSeguro(Integer idHistorialSeguro) {
		this.idHistorialSeguro = idHistorialSeguro;
	}

	public Boolean getTitularHS() {
		return titularHS;
	}

	public void setTitularHS(Boolean titularHS) {
		this.titularHS = titularHS;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getCodigoSeguroPrincipal() {
		return codigoSeguroPrincipal;
	}

	public void setCodigoSeguroPrincipal(String codigoSeguroPrincipal) {
		this.codigoSeguroPrincipal = codigoSeguroPrincipal;
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

	public TipoSeguro getTipo_seguro() {
		return tipo_seguro;
	}

	public void setTipo_seguro(TipoSeguro tipo_seguro) {
		this.tipo_seguro = tipo_seguro;
	}

	public EstadoSeguro getEstado_seguro() {
		return estado_seguro;
	}

	public void setEstado_seguro(EstadoSeguro estado_seguro) {
		this.estado_seguro = estado_seguro;
	}

	public Institucion getInstitucion() {
		return institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}

	public Asegurado getAsegurado() {
		return asegurado;
	}

	public void setAsegurado(Asegurado asegurado) {
		this.asegurado = asegurado;
	}

	@Override
	public String toString() {
		return "HistorialSeguro [idHistorialSeguro=" + idHistorialSeguro + ", titularHS=" + titularHS + ", fechaAlta="
				+ fechaAlta + ", fechaBaja=" + fechaBaja + ", codigoSeguroPrincipal=" + codigoSeguroPrincipal
				+ ", estado="
				+ estado + ", registro=" + registro + ", modificacion=" + modificacion + ", tipo_seguro=" + tipo_seguro
				+ ", estado_seguro=" + estado_seguro + ", institucion=" + institucion + ", asegurado=" + asegurado
				+ "]";
	}

}
