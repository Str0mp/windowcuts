package com.martini.windowcuts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vidrio")
public class Vidrio {

	@Id
	@Column(name = "id_vidrio")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idVidrio;

	@Column(name = "descripcion_vidrio")
	String descripcionVidrio;

	@Column(name = "ancho_corte")
	double anchoCorte;

	@Column(name = "alto_corte")
	double altoCorte;

	public Vidrio() {
		super();
	}

	public Vidrio(Long idVidrio, String descripcionVidrio, double anchoCorte, double altoCorte) {
		super();
		this.idVidrio = idVidrio;
		this.descripcionVidrio = descripcionVidrio;
		this.anchoCorte = anchoCorte;
		this.altoCorte = altoCorte;
	}

	public Long getIdVidrio() {
		return idVidrio;
	}

	public void setIdVidrio(Long idVidrio) {
		this.idVidrio = idVidrio;
	}

	public String getDescripcionVidrio() {
		return descripcionVidrio;
	}

	public void setDescripcionVidrio(String descripcionVidrio) {
		this.descripcionVidrio = descripcionVidrio;
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
