package com.martini.windowcuts.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.martini.windowcuts.model.Proyecto;
import com.martini.windowcuts.model.Ventana;
import com.martini.windowcuts.service.ProyectoService;
import com.martini.windowcuts.service.VentanaService;

@Controller
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
public class MainController {

	Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	ProyectoService proyectoService;

	@Autowired
	VentanaService ventanaService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/verProyecto")
	public String verProyecto(Model model) {
		return "proyectos";
	}

	@GetMapping("/buscarProyectos")
	public String buscarProyecto(Model model) {
		model.addAttribute("listaProyectos", proyectoService.getProyectos());
		model.addAttribute("Proyecto", new Proyecto());
		return "buscarProyectos";
	}

	@GetMapping("/")
	public String retorno() {
		return "redirect:/index";
	}

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("listaProyectos", proyectoService.getProyectos());
		model.addAttribute("Proyecto", new Proyecto());
		model.addAttribute("Ventana", new Ventana());
		return "index";
	}

	@GetMapping("/agregarVentana")
	public String agregarVentana(Model model) {
		model.addAttribute("listaProyectos", proyectoService.getProyectos());
		model.addAttribute("Proyecto", new Proyecto());
		model.addAttribute("Ventana", new Ventana());
		return "agregarVentana";
	}

	@PostMapping("/saveProyecto")
	public String saveProyecto(@ModelAttribute("Proyecto") Proyecto proyecto) {
		proyectoService.saveProyecto(proyecto);
		return "redirect:/index";
	}

	@PostMapping("/saveVentana")
	public String saveVentana(@ModelAttribute("Ventana") Ventana ventana,
			@ModelAttribute("Proyecto") Proyecto proyecto) {
		ventana.setIdVidrio(ventanaService.saveVidrio(ventana));
		ventana.setIdPerfil(ventanaService.savePerfil(ventana));
		Ventana tmp = ventanaService.saveVentana(ventana);
		List<Ventana> listaVentana = new ArrayList<Ventana>();
		listaVentana.add(tmp);
		proyecto.setIdVentana(listaVentana);
		proyectoService.updateProyecto(proyecto);
		return "redirect:/agregarVentana";
	}

	@PostMapping("/viewProyecto")
	public String viewProyecto(@ModelAttribute("Proyecto") Proyecto proyecto, Model model) {
		model.addAttribute("Proyecto", new Proyecto());
		model.addAttribute("viewProyecto", proyectoService.viewProyecto(proyecto));
		return "proyectos";
	}

	@PostMapping("/eliminarProyecto")
	public String deleteProyecto(@ModelAttribute("Proyecto") Proyecto proyecto) {
		proyectoService.eliminarProyecto(proyecto);
		return "redirect:/index";
	}

	@PostMapping("/eliminarVentana")
	public String deleteVentana(@ModelAttribute("Proyecto") Proyecto proyecto) {
		proyectoService.eliminarVentana(proyecto);
		return "redirect:/buscarProyectos";
	}

}
