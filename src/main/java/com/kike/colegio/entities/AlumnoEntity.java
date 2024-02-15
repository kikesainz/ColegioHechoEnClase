package com.kike.colegio.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "alumnos")
public class AlumnoEntity {

	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidos")
	private String apellidos;
	
//	@Column(name="id_municipio")
//	private Integer idMunicipio;
	
	@Column(name="familia_numerosa")
	private Integer famNumerosa;
	
	@Column(name="activo")
	private Integer activo;
	
	@ManyToOne
	@JoinColumn(name="id_municipio")
	@JsonBackReference
	private MunicipiosEntity municipio;

	public AlumnoEntity(Integer id, String nombre, String apellidos, Integer famNumerosa, Integer activo,
			MunicipiosEntity municipio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.famNumerosa = famNumerosa;
		this.activo = activo;
		this.municipio = municipio;
	}

	public AlumnoEntity() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getFamNumerosa() {
		return famNumerosa;
	}

	public void setFamNumerosa(Integer famNumerosa) {
		this.famNumerosa = famNumerosa;
	}

	public Integer getActivo() {
		return activo;
	}

	public void setActivo(Integer activo) {
		this.activo = activo;
	}

	public MunicipiosEntity getMunicipio() {
		return municipio;
	}

	public void setMunicipio(MunicipiosEntity municipio) {
		this.municipio = municipio;
	}
	
	
	
}