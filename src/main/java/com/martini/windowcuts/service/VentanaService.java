package com.martini.windowcuts.service;

import java.util.List;

import com.martini.windowcuts.model.Perfil;
import com.martini.windowcuts.model.Ventana;
import com.martini.windowcuts.model.Vidrio;

public interface VentanaService {

	Ventana saveVentana(Ventana ventana);

	List<Vidrio> saveVidrio(Ventana ventana);

	List<Perfil> savePerfil(Ventana ventana);

	Vidrio calculoVidrioPanioFijo(Ventana ventana);

	Vidrio calculoVidrioHojaMovil(Ventana ventana);

	Vidrio calculoVidrioMarcoFijoCompleto(Ventana ventana);

	Perfil calculoMarcoCorredera(Ventana ventana);

	Perfil calculoTraslapoFijoAlto(Ventana ventana);

	Perfil calculoTraslapoMovilAlto(Ventana ventana);

	Perfil calculoHojaMovil(Ventana ventana);
	
	int zeroRight(int largo);

}
