package com.dae.spring.controladores;

import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import com.dae.spring.modelos.Enfermedades;
import com.dae.spring.servicios.EnfermedadesServicio;

@Controller
@RequestMapping("/enfermedades")
@SessionAttributes("enfermedades")
public class EnfermedadesControlador {
	@Autowired
	@Qualifier("enfermedades")
	EnfermedadesServicio enfermedadesServicio;
	
	@RequestMapping("/listar")
	public ModelAndView listar() {
		ModelAndView model = new ModelAndView("enfermedad_Lista");
		List<Enfermedades> enfermedad = enfermedadesServicio.listar();
		model.addObject("enfermedad",enfermedad);
		model.addObject("titulo","Lista de Enfermedades");
		return model;
	}
	
	@RequestMapping("/form")
	public ModelAndView formulario() {
		ModelAndView model = new ModelAndView();
		Enfermedades enfermedades = new Enfermedades();
		model.addObject("enfermedades",enfermedades);
		model.setViewName("enfermedad_Form");
		return model;
	}
	
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("enfermedades",enfermedadesServicio.buscar(id));
		model.addAttribute("btn","Actualiza Registro");
		return "enfermedad_Form";
	}
	
	@RequestMapping(value="/insertar",method=RequestMethod.POST)
	public String guardar(@Valid Enfermedades enfermedades,BindingResult result,Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			enfermedades = new Enfermedades();
			model.addAttribute("enfermedades",enfermedades);
			return "enfermedad_Form";
		}else {
			enfermedadesServicio.guardar(enfermedades);
		return "redirect:/enfermedades/listar";
		}
	}
	
	@RequestMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		enfermedadesServicio.eliminar(id);
		return "redirect:/enfermedades/listar";
	}
}
