package com.dae.spring.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dae.spring.modelos.Enfermedades;

@Repository
public interface EnfermedadesRepositorio extends JpaRepository<Enfermedades, Serializable>{
	
	public abstract Enfermedades findById(Long id);
	public abstract Enfermedades findByNombre(String producto);
	
}
