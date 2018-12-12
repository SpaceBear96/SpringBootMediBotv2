package com.dae.spring.servicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
	
	public Hospitales buscarId(long id) {
		return hospitalesRepositorio.findById(id);
	}
	
	public boolean eliminar(Long id) {
		try {
			hospitalesRepositorio.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public Hospitales buscar(String nombre) {
		return hospitalesRepositorio.findByNombre(nombre);
	}
	
	private String upload_folder = ".//src//main//resources//files//";

	public void saveFile(MultipartFile file) throws IOException {
	        if(!file.isEmpty()){
	            byte[] bytes = file.getBytes();
	            String name = Math.random() + file.getOriginalFilename();
	            Path path = Paths.get(upload_folder + name);
	            Files.write(path,bytes);
	            
	        }
	}
}
