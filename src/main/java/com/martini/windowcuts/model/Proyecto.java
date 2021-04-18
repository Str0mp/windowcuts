package com.martini.windowcuts.model;

import java.sql.Date;
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

import org.springframework.beans.factory.annotation.Autowired;

import com.martini.windowcuts.service.ProyectoService;

@Entity
@Table(name = "proyecto")
public class Proyecto {
	

	@Id
	@Column(name = "id_proyecto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idProyecto;

	@Column(name = "nombre_proyecto")
	String nombreProyecto;

	@Column(name = "fecha_proyecto")
	Date fechaProyecto;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	List<Ventana> idVentana = new ArrayList<Ventana>();

	public Proyecto() {
		super();
	}
	
	public boolean isVentanas(Ventana ventana) {
		
		if (null != ventana) {
			return true;
		} else {
			return false;
		}
	}

	public Proyecto(Long idProyecto, String nombreProyecto, Date fechaProyecto, List<Ventana> idVentana) {
		super();
		this.idProyecto = idProyecto;
		this.nombreProyecto = nombreProyecto;
		this.fechaProyecto = fechaProyecto;
		this.idVentana = idVentana;
	}

	public Long getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Long idProyecto) {
		this.idProyecto = idProyecto;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public Date getFechaProyecto() {
		return fechaProyecto;
	}

	public void setFechaProyecto(Date fechaProyecto) {
		this.fechaProyecto = fechaProyecto;
	}

	public List<Ventana> getIdVentana() {
		return idVentana;
	}

	public void setIdVentana(List<Ventana> idVentana) {
		if (this.idVentana == null) {
			this.idVentana = idVentana;
		} else {
			this.idVentana.clear();
			this.idVentana.addAll(idVentana);
		}

	}

}
