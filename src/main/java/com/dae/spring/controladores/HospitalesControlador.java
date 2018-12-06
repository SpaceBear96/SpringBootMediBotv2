package com.dae.spring.controladores;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dae.spring.modelos.Hospitales;
import com.dae.spring.servicios.HospitalesServicios;

@Controller
@RequestMapping("/hospitales")
@SessionAttributes("hospitales")
public class HospitalesControlador{
	@Autowired
	@Qualifier("hospitales")
	HospitalesServicios hospitalesServicio;
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Hospitales> hospitales = hospitalesServicio.listar();
		model.addAttribute("hospitales",hospitales);
		model.addAttribute("titulo","Lista de Hospitales");
		return "hospitalesListar";
	}
	
	@RequestMapping("/form")
	public String formulario (Map<String, Object> model) {
		Hospitales hospitales = new Hospitales();
		model.put("hospitales",hospitales);
		model.put("btn", "Agregar hospital");
		return "hospitalesForm";
	}
	
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("hospital",hospitalesServicio.buscar(id));
		model.addAttribute("btn","Actualiza Registro");
		return "hospitalesForm";
	}
	
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
	public String guardar(@Valid Hospitales hospitales,BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			hospitales = new Hospitales();
			model.addAttribute("hospitales",hospitales);
			model.addAttribute("btn","Agregar Hospital");
			return "hospitalesForm";
		}else {
			hospitalesServicio.guardar(hospitales);
		return "redirect:/hospitales/listar";
		}
	}
	
	@RequestMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		hospitalesServicio.eliminar(id);
		return "redirect:/hospitales/listar";
	}
}
