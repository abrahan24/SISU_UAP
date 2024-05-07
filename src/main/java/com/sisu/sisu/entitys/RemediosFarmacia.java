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
@Table(name = "remedios_farmacia")
public class RemediosFarmacia implements Serializable{
    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_remedios_farmacia")
    private Integer idRemediosFarmacia; 

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "estado")
    private String estado;

    @Column(name = "registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registro;
    
    @Column(name = "modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificacion;

    //-------------------REALCIONES---------------------------------------------

    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "remedios_farmacia", fetch = FetchType.LAZY)
	private List<RemediosFarmaciaLote> remedios_farmacia_lote;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idLiname")
    private ListaLiname lista_liname;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "remedios_farmacia", fetch = FetchType.LAZY)
	private List<RecetaRemedios> receta_remedios;

	public RemediosFarmacia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RemediosFarmacia(Integer idRemediosFarmacia, String ubicacion, String estado, Date registro,
			Date modificacion, List<RemediosFarmaciaLote> remedios_farmacia_lote, ListaLiname lista_liname,
			List<RecetaRemedios> receta_remedios) {
		super();
		this.idRemediosFarmacia = idRemediosFarmacia;
		this.ubicacion = ubicacion;
		this.estado = estado;
		this.registro = registro;
		this.modificacion = modificacion;
		this.remedios_farmacia_lote = remedios_farmacia_lote;
		this.lista_liname = lista_liname;
		this.receta_remedios = receta_remedios;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
	}

	public Integer getIdRemediosFarmacia() {
		return idRemediosFarmacia;
	}

	public void setIdRemediosFarmacia(Integer idRemediosFarmacia) {
		this.idRemediosFarmacia = idRemediosFarmacia;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
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

	public List<RemediosFarmaciaLote> getRemedios_farmacia_lote() {
		return remedios_farmacia_lote;
	}

	public void setRemedios_farmacia_lote(List<RemediosFarmaciaLote> remedios_farmacia_lote) {
		this.remedios_farmacia_lote = remedios_farmacia_lote;
	}

	public ListaLiname getLista_liname() {
		return lista_liname;
	}

	public void setLista_liname(ListaLiname lista_liname) {
		this.lista_liname = lista_liname;
	}

	public List<RecetaRemedios> getReceta_remedios() {
		return receta_remedios;
	}

	public void setReceta_remedios(List<RecetaRemedios> receta_remedios) {
		this.receta_remedios = receta_remedios;
	}

	@Override
	public String toString() {
		return "RemediosFarmacia [idRemediosFarmacia=" + idRemediosFarmacia + ", ubicacion=" + ubicacion + ", estado="
				+ estado + ", registro=" + registro + ", modificacion=" + modificacion + ", remedios_farmacia_lote="
				+ remedios_farmacia_lote + ", lista_liname=" + lista_liname + ", receta_remedios=" + receta_remedios
				+ "]";
	}
    
    
    
    
    
}
