package com.martini.windowcuts.service;

import java.util.Collection;

import com.martini.windowcuts.model.Proyecto;

public interface ProyectoService {
	
	Collection<Proyecto> getProyectos();
	
	void saveProyecto(Proyecto proyecto);
	
	void updateProyecto(Proyecto proyecto);
	
	Proyecto viewProyecto(Proyecto proyecto);
	
	void eliminarProyecto(Proyecto proyecto);
	
	void eliminarVentana(Proyecto proyecto);

}
