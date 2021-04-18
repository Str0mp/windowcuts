package com.martini.windowcuts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martini.windowcuts.model.Perfil;
import com.martini.windowcuts.model.Ventana;
import com.martini.windowcuts.model.Vidrio;
import com.martini.windowcuts.repository.VentanaRepository;

@Service
public class VentanaServiceImpl implements VentanaService {

	@Autowired
	VentanaRepository ventanaRepository;

	@Override
	public Ventana saveVentana(Ventana ventana) {
		Ventana retorno = null;
		if (null != ventana) {
			retorno = ventanaRepository.save(ventana);
		}
		return retorno;
	}

	@Override
	public List<Vidrio> saveVidrio(Ventana ventana) {
		List<Vidrio> listaVidrio = new ArrayList<>();
		listaVidrio.add(calculoVidrioPanioFijo(ventana));
		listaVidrio.add(calculoVidrioHojaMovil(ventana));
		listaVidrio.add(calculoVidrioMarcoFijoCompleto(ventana));
		return listaVidrio;
	}

	@Override
	public List<Perfil> savePerfil(Ventana ventana) {
		List<Perfil> listaPerfil = new ArrayList<Perfil>();
//			listaPerfil.add(calculoMarcoCorredera(ventana));
			listaPerfil.add(calculoTraslapoFijoAlto(ventana));
			listaPerfil.add(calculoTraslapoMovilAlto(ventana));
			listaPerfil.add(calculoHojaMovil(ventana));

		return listaPerfil;
	}

	@SuppressWarnings("null")
	@Override
	public Vidrio calculoVidrioPanioFijo(Ventana ventana) {
		Vidrio vidrio = new Vidrio();
		if (null != ventana) {
			if (ventana.getDescripcionVentana().toLowerCase().contains("fijo")) {
				vidrio.setDescripcionVidrio("Vidrio Paño Fijo");
				vidrio.setAnchoCorte(0);
				vidrio.setAltoCorte(0);
			} else {
				vidrio.setDescripcionVidrio("Vidrio Paño Fijo");
				int numeroDivisionAncho = String.valueOf((int) ((ventana.getAncho() / 2) - 32)).length();
				int numeroDivisionAlto = String.valueOf((int) (ventana.getAlto() - 44)).length();
				vidrio.setAnchoCorte(((ventana.getAncho() / 2) - 32) / zeroRight(numeroDivisionAncho));
				vidrio.setAltoCorte((ventana.getAlto() - 44) / zeroRight(numeroDivisionAlto));
			}

		}
		return vidrio;
	}

	@Override
	public Vidrio calculoVidrioHojaMovil(Ventana ventana) {
		Vidrio vidrio = new Vidrio();
		if (null != ventana) {
			if (ventana.getDescripcionVentana().toLowerCase().contains("fijo")) {
				vidrio.setDescripcionVidrio("Vidrio Hoja Movil");
				vidrio.setAnchoCorte(0);
				vidrio.setAltoCorte(0);
			} else {
				int numeroDivisionAncho = String.valueOf((int) ((ventana.getAncho() / 2) - 54)).length();
				int numeroDivisionAlto = String.valueOf((int) (ventana.getAlto() - 106)).length();
				vidrio.setDescripcionVidrio("Vidrio Hoja Movil");
				vidrio.setAnchoCorte(((ventana.getAncho() / 2) - 54) / zeroRight(numeroDivisionAncho));
				vidrio.setAltoCorte((ventana.getAlto() - 106) / zeroRight(numeroDivisionAlto));
			}

		}
		return vidrio;
	}

	@Override
	public Vidrio calculoVidrioMarcoFijoCompleto(Ventana ventana) {
		Vidrio vidrio = new Vidrio();
		if (null != ventana) {
			int numeroDivisionAncho = String.valueOf((int) (ventana.getAncho() - 44)).length();
			int numeroDivisionAlto = String.valueOf((int) (ventana.getAlto() - 44)).length();
			vidrio.setDescripcionVidrio("Vidrio Marco Fijo Completo");
			vidrio.setAnchoCorte((ventana.getAncho() - 44) / zeroRight(numeroDivisionAncho));
			vidrio.setAltoCorte((ventana.getAlto() - 44) / zeroRight(numeroDivisionAlto));
		}
		return vidrio;
	}

	@Override
	public Perfil calculoMarcoCorredera(Ventana ventana) {
		Perfil perfil = new Perfil();
		if (null != ventana) {
			perfil.setDescripcionPerfil("Marco Corredera");
			perfil.setAnchoCorte(ventana.getAncho() + 8);
			perfil.setAltoCorte(ventana.getAlto() + 8);
		}
		return perfil;
	}

	@Override
	public Perfil calculoTraslapoFijoAlto(Ventana ventana) {
		Perfil perfil = new Perfil();
		if (null != ventana) {
			if (ventana.getDescripcionVentana().toLowerCase().contains("fijo")) {
				perfil.setDescripcionPerfil("Traslapo Fijo Alto");
				perfil.setAltoCorte(0);
			} else {
				perfil.setDescripcionPerfil("Traslapo Fijo Alto");
				perfil.setAltoCorte(ventana.getAlto() - 39);
			}
		}
		return perfil;
	}

	@Override
	public Perfil calculoTraslapoMovilAlto(Ventana ventana) {
		Perfil perfil = new Perfil();
		if (null != ventana) {
			if (ventana.getDescripcionVentana().toLowerCase().contains("fijo")) {
				perfil.setDescripcionPerfil("Traslapo Movil Alto");
				perfil.setAltoCorte(0);
			} else {
				perfil.setDescripcionPerfil("Traslapo Movil Alto");
				perfil.setAltoCorte(ventana.getAlto() - 43);
			}

		}
		return perfil;
	}

	@Override
	public Perfil calculoHojaMovil(Ventana ventana) {
		Perfil perfil = new Perfil();
		if (null != ventana) {
			if (ventana.getDescripcionVentana().toLowerCase().contains("fijo")) {
				perfil.setDescripcionPerfil("Hoja Movil");
				perfil.setAnchoCorte(0);
			} else {
				perfil.setDescripcionPerfil("Hoja Movil");
				perfil.setAnchoCorte((ventana.getAncho() / 2) + 6);
			}

//			perfil.setAltoCorte(ventana.getAlto() - 43);
		}
		return perfil;
	}

	@Override
	public int zeroRight(int largo) {
		StringBuilder sb = new StringBuilder();
		sb.append("1");
		while (sb.length() < largo + 1) {
			sb.append("0");
		}
		int division = Integer.parseInt(sb.toString());
		return division;
	}

}
