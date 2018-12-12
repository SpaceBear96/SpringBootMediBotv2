package com.dae.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dae.spring.modelos.Distritos;
import com.dae.spring.repositorio.DistritoRepositorio;

@Service("distritos")
public class DistritoServicios {
	
	@Autowired
	DistritoRepositorio distritoRepositorio;

	public List<Distritos> listado() {
		return distritoRepositorio.findAll();
	}
}
