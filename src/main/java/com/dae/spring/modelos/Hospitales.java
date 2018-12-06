package com.dae.spring.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="hospitales")
@EntityListeners(AuditingEntityListener.class)
public class Hospitales {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="c_distrito")
	private String distrito;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public Hospitales(long id, String nombre, String distrito) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.distrito = distrito;
	}
	public Hospitales() {
		super();
	}
	
	
}
