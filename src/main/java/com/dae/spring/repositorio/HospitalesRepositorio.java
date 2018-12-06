package com.dae.spring.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dae.spring.modelos.Hospitales;

@Repository
public interface HospitalesRepositorio extends JpaRepository<Hospitales, Serializable>{

	public abstract Hospitales findById(Long id);
	public abstract Hospitales findByNombre(String producto);

}
