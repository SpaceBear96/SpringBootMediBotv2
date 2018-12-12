package com.dae.spring.repositorio;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dae.spring.modelos.Distritos;

@Repository
public interface DistritoRepositorio extends JpaRepository<Distritos, Serializable>{

	List<Distritos> findAll();

}
