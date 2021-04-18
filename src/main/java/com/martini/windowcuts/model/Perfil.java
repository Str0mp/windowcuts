package com.martini.windowcuts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "perfil")
public class Perfil {

	@Id
	@Column(name = "id_perfil")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idPerfil;

	@Column(name = "descripcion_perfil")
	String descripcionPerfil;

	@Column(name = "ancho_corte")
	double anchoCorte;

	@Column(name = "alto_corte")
	double altoCorte;

	public Perfil() {
		super();
	}
	
	public boolean isPerfilSoloAlto() {
		if(getDescripcionPerfil().equalsIgnoreCase("Traslapo Fijo Alto") || getDescripcionPerfil().equalsIgnoreCase("Traslapo Movil Alto")) {
			return false;
		}
		return true;
	}
	
	public boolean isPerfilHojaMovil() {
		if(getDescripcionPerfil().equals("Hoja Movil")) {
			return false;
		}
		return true;
	}

	public Perfil(Long idPerfil, String descripcionPerfil, double anchoCorte, double altoCorte) {
		super();
		this.idPerfil = idPerfil;
		this.descripcionPerfil = descripcionPerfil;
		this.anchoCorte = anchoCorte;
		this.altoCorte = altoCorte;
	}

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getDescripcionPerfil() {
		return descripcionPerfil;
	}

	public void setDescripcionPerfil(String descripcionPerfil) {
		this.descripcionPerfil = descripcionPerfil;
	}

	public double getAnchoCorte() {
		return anchoCorte;
	}

	public void setAnchoCorte(double anchoCorte) {
		this.anchoCorte = anchoCorte;
	}

	public double getAltoCorte() {
		return altoCorte;
	}

	public void setAltoCorte(double altoCorte) {
		this.altoCorte = altoCorte;
	}

}
