package com.martini.windowcuts.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ventana")
public class Ventana {

	@Id
	@Column(name = "id_ventana")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idVentana;

	@Column(name = "ancho")
	double ancho;

	@Column(name = "alto")
	double alto;

	@Column(name = "cantidad")
	int cantidad;

	@Column(name = "descripcion_ventana")
	String descripcionVentana;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	List<Vidrio> idVidrio = new ArrayList<Vidrio>();

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	List<Perfil> idPerfil = new ArrayList<Perfil>();
	
	public Ventana(Long idVentana, double ancho, double alto, int cantidad, String descripcionVentana,
			List<Vidrio> idVidrio, List<Perfil> idPerfil) {
		super();
		this.idVentana = idVentana;
		this.ancho = ancho;
		this.alto = alto;
		this.cantidad = cantidad;
		this.descripcionVentana = descripcionVentana;
		this.idVidrio = idVidrio;
		this.idPerfil = idPerfil;
	}

	public Ventana() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdVentana() {
		return idVentana;
	}

	public void setIdVentana(Long idVentana) {
		this.idVentana = idVentana;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcionVentana() {
		return descripcionVentana;
	}

	public void setDescripcionVentana(String descripcionVentana) {
		this.descripcionVentana = descripcionVentana;
	}

	public List<Vidrio> getIdVidrio() {
		return idVidrio;
	}

	public void setIdVidrio(List<Vidrio> idVidrio) {
		this.idVidrio = idVidrio;
	}

	public List<Perfil> getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(List<Perfil> idPerfil) {
		this.idPerfil = idPerfil;
	}

}
