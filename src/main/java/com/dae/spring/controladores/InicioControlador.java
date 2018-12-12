package com.dae.spring.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InicioControlador {
	
	@RequestMapping("/")
	public ModelAndView listar() {
		ModelAndView model = new ModelAndView("inicio");
		return model;
	}
	
	
}
