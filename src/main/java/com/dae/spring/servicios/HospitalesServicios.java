package com.dae.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dae.spring.modelos.Hospitales;
import com.dae.spring.repositorio.HospitalesRepositorio;

@Service("hospitales")
public class HospitalesServicios {
	
	@Autowired
	HospitalesRepositorio hospitalesRepositorio;
	
	public void guardar(Hospitales hospitales) {
		
		hospitalesRepositorio.save(hospitales);
	}
	
	public List<Hospitales> listar(){
		
		return hospitalesRepositorio.findAll();
	}
	
	public Hospitales buscar(Long id) {
		return hospitalesRepositorio.findById(id);
	}
	
	public boolean eliminar(Long id) {
		try {
			hospitalesRepositorio.delete(hospitalesRepositorio.findById(id));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public Hospitales buscar(String nombre) {
		return hospitalesRepositorio.findByNombre(nombre);
	}
}
