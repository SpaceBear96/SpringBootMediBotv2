package com.dae.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dae.spring.modelos.Enfermedades;
import com.dae.spring.modelos.Hospitales;
import com.dae.spring.repositorio.EnfermedadesRepositorio;

@Service("enfermedades")
public class EnfermedadesServicio {
	
	@Autowired
	EnfermedadesRepositorio enfermedadesRepositorio;
	
	public void guardar(Enfermedades enfermedades) {	
		enfermedadesRepositorio.save(enfermedades);
	}
	
	public List<Enfermedades> listar(){
		
		return enfermedadesRepositorio.findAll();
	}
	
	public Enfermedades buscar(Long id) {
		return enfermedadesRepositorio.findById(id);
	}
	
	public boolean eliminar(Long id) {
		try {
			enfermedadesRepositorio.delete(enfermedadesRepositorio.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public Enfermedades buscar(String nombre) {
		return enfermedadesRepositorio.findByNombre(nombre);
	}
	
}
