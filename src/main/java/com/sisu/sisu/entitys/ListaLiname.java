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
@Table(name = "lista_liname")
public class ListaLiname implements Serializable{
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista_liname")
    private Integer idLiname;

    @Column(name = "medicamento")
    private String medicamento;

    @Column(name = "concentracion")
    private String concentracion;

    @Column(name = "codigo_liname")
    private String codigoLiname;

    @Column(name = "fecha_incluido")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaIncluido;

    @Column(name = "fecha_excluido")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaExcluido;

    @Column(name = "estado_liname")
    private String estadoLiname;

    @Column(name = "codigo_ATQ")
    private String codigoATQ;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;


    //--------------------REMEDIOS--------------------------------------------

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lista_liname", fetch = FetchType.LAZY)
	private List<RemediosFarmacia> remedios_farmacia;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lista_liname", fetch = FetchType.LAZY)
	private List<HistorialLiname> historial_liname;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idFormaFarmaceutica")
    private FormaFarmaceutica forma_farmaceutica;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipoUso")
    private TipoUso tipo_uso;

	public ListaLiname() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListaLiname(Integer idLiname, String medicamento, String concentracion, String codigoLiname,
			Date fechaIncluido, Date fechaExcluido, String estadoLiname, String codigoATQ, Date registro,
			Date modificacion, List<RemediosFarmacia> remedios_farmacia, List<HistorialLiname> historial_liname,
			FormaFarmaceutica forma_farmaceutica, TipoUso tipo_uso) {
		super();
		this.idLiname = idLiname;
		this.medicamento = medicamento;
		this.concentracion = concentracion;
		this.codigoLiname = codigoLiname;
		this.fechaIncluido = fechaIncluido;
		this.fechaExcluido = fechaExcluido;
		this.estadoLiname = estadoLiname;
		this.codigoATQ = codigoATQ;
		this.registro = registro;
		this.modificacion = modificacion;
		this.remedios_farmacia = remedios_farmacia;
		this.historial_liname = historial_liname;
		this.forma_farmaceutica = forma_farmaceutica;
		this.tipo_uso = tipo_uso;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdLiname() {
		return idLiname;
	}

	public void setIdLiname(Integer idLiname) {
		this.idLiname = idLiname;
	}

	public String getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}

	public String getConcentracion() {
		return concentracion;
	}

	public void setConcentracion(String concentracion) {
		this.concentracion = concentracion;
	}

	public String getCodigoLiname() {
		return codigoLiname;
	}

	public void setCodigoLiname(String codigoLiname) {
		this.codigoLiname = codigoLiname;
	}

	public Date getFechaIncluido() {
		return fechaIncluido;
	}

	public void setFechaIncluido(Date fechaIncluido) {
		this.fechaIncluido = fechaIncluido;
	}

	public Date getFechaExcluido() {
		return fechaExcluido;
	}

	public void setFechaExcluido(Date fechaExcluido) {
		this.fechaExcluido = fechaExcluido;
	}

	public String getEstadoLiname() {
		return estadoLiname;
	}

	public void setEstadoLiname(String estadoLiname) {
		this.estadoLiname = estadoLiname;
	}

	public String getCodigoATQ() {
		return codigoATQ;
	}

	public void setCodigoATQ(String codigoATQ) {
		this.codigoATQ = codigoATQ;
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

	public List<RemediosFarmacia> getRemedios_farmacia() {
		return remedios_farmacia;
	}

	public void setRemedios_farmacia(List<RemediosFarmacia> remedios_farmacia) {
		this.remedios_farmacia = remedios_farmacia;
	}

	public List<HistorialLiname> getHistorial_liname() {
		return historial_liname;
	}

	public void setHistorial_liname(List<HistorialLiname> historial_liname) {
		this.historial_liname = historial_liname;
	}

	public FormaFarmaceutica getForma_farmaceutica() {
		return forma_farmaceutica;
	}

	public void setForma_farmaceutica(FormaFarmaceutica forma_farmaceutica) {
		this.forma_farmaceutica = forma_farmaceutica;
	}

	public TipoUso getTipo_uso() {
		return tipo_uso;
	}

	public void setTipo_uso(TipoUso tipo_uso) {
		this.tipo_uso = tipo_uso;
	}

	@Override
	public String toString() {
		return "ListaLiname [idLiname=" + idLiname + ", medicamento=" + medicamento + ", concentracion=" + concentracion
				+ ", codigoLiname=" + codigoLiname + ", fechaIncluido=" + fechaIncluido + ", fechaExcluido="
				+ fechaExcluido + ", estadoLiname=" + estadoLiname + ", codigoATQ=" + codigoATQ + ", registro="
				+ registro + ", modificacion=" + modificacion + ", remedios_farmacia=" + remedios_farmacia
				+ ", historial_liname=" + historial_liname + ", forma_farmaceutica=" + forma_farmaceutica
				+ ", tipo_uso=" + tipo_uso + "]";
	}
    
    
    
    
	
	
    
    
    
    

}
