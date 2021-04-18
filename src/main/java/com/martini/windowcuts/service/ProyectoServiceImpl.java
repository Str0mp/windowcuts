package com.martini.windowcuts.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martini.windowcuts.model.Proyecto;
import com.martini.windowcuts.model.Ventana;
import com.martini.windowcuts.repository.ProyectoRepository;

@Service
public class ProyectoServiceImpl implements ProyectoService {

	@Autowired
	ProyectoRepository proyectoRepository;

	@Override
	public Collection<Proyecto> getProyectos() {
		return proyectoRepository.findAll();
	}

	@Override
	public void saveProyecto(Proyecto proyecto) {
		if (null != proyecto) {
			proyectoRepository.save(proyecto);
		}
 
	}

	@Override
	public void updateProyecto(Proyecto proyecto) {
		if (null != proyecto) {
			Proyecto update = proyectoRepository.findById(proyecto.getIdProyecto()).orElse(null);
			List<Ventana> tmpVentana = new ArrayList<Ventana>();
			tmpVentana.addAll(proyecto.getIdVentana());
			tmpVentana.addAll(update.getIdVentana());
			update.setIdVentana(tmpVentana);
			proyectoRepository.save(update);
		}

	}

	@Override
	public Proyecto viewProyecto(Proyecto proyecto) {
		if (null != proyecto && proyecto.getIdProyecto() != 0) {
			return proyectoRepository.findById(proyecto.getIdProyecto()).orElse(null);
		}
		return null;
	}

	@Override
	public void eliminarProyecto(Proyecto proyecto) {
		if (null != proyecto && 0 != proyecto.getIdProyecto()) {
			proyectoRepository.deleteById(proyecto.getIdProyecto());
		}

	}

	@Override
	public void eliminarVentana(Proyecto proyecto) {
		Proyecto tmpProyecto = null;
		Proyecto newProyecto = null;
		if (null != proyecto && 0 != proyecto.getIdProyecto()) {
			newProyecto = new Proyecto();
			tmpProyecto = proyectoRepository.findById(proyecto.getIdProyecto()).orElse(null);
			newProyecto.setIdProyecto(tmpProyecto.getIdProyecto());
			newProyecto.setFechaProyecto(tmpProyecto.getFechaProyecto());
			newProyecto.setNombreProyecto(tmpProyecto.getNombreProyecto());
			List<Ventana> ventanas = tmpProyecto.getIdVentana();
			List<Ventana> newVentanas = new ArrayList<Ventana>();
			for (Ventana ventana : ventanas) {
				if (ventana.getIdVentana() != proyecto.getIdVentana().get(0).getIdVentana()) {
					newVentanas.add(ventana);
				}
			}
			newProyecto.setIdVentana(newVentanas);
			proyectoRepository.saveAndFlush(newProyecto);
		}

	}

}
