package com.dae.spring.controladores;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dae.spring.modelos.Distritos;
import com.dae.spring.modelos.Hospitales;
import com.dae.spring.servicios.DistritoServicios;
import com.dae.spring.servicios.HospitalesServicios;

@Controller
@RequestMapping("/hospitales")
@SessionAttributes("hospitales")
public class HospitalesControlador{
	@Autowired
	@Qualifier("hospitales")
	HospitalesServicios hospitalesServicio;
	@Autowired
	DistritoServicios distritoServicio;
	
	@RequestMapping("/listar")
	public ModelAndView listar() {
		ModelAndView model = new ModelAndView("hospital_Lista");
		List<Hospitales> hospitales = hospitalesServicio.listar();
		model.addObject("hospitales",hospitales);
		model.addObject("titulo","Lista de Hospitales");
		return model;
	}
	
	@RequestMapping("/form")
	public ModelAndView formulario() {
		ModelAndView model = new ModelAndView();
		Hospitales hospital = new Hospitales();
		List<Distritos> distritos = distritoServicio.listado();
		model.addObject("hospitales",hospital);
		model.addObject("distrito",distritos);
		model.setViewName("hospital_Form");
		return model;
	}
	
	@RequestMapping("/form/{id}")
	public String actualizar (@PathVariable("id") Long id,Model model) {
		model.addAttribute("hospitales",hospitalesServicio.buscarId(id));
		return "hospital_Form";
	}
	
	@RequestMapping("/view/{id}")
    public String visualizar(@PathVariable("id") Long id,Model model){
		model.addAttribute("hospitales",hospitalesServicio.buscarId(id));
        return "hospital_View";
    }
	
	@PostMapping(value="/insertar")
	public String guardar(@Valid Hospitales hospitales,BindingResult result,Model model) throws IOException {
		
		if(result.hasErrors()) {
			model.addAttribute("ERROR","Error al enviar registro");
			hospitales = new Hospitales();
			model.addAttribute("hospitales",hospitales);
			model.addAttribute("btn","Agregar Hospital");
			return "hospitales_Form";
		}else {
			hospitalesServicio.guardar(hospitales);
		return "redirect:/hospitales/listar";
		}
	}
	
	@RequestMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") Long id) {
		hospitalesServicio.eliminar(id);
		return "redirect:/hospitales/listar";
	}
	
	@PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        
		if (file.isEmpty()) {
            return new ResponseEntity<Object>("Seleccionar un archivo", HttpStatus.OK);
        }

        try {
            hospitalesServicio.saveFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<Object>("Archivo subido correctamente"+file.getOriginalFilename(), HttpStatus.OK);
    }
}
