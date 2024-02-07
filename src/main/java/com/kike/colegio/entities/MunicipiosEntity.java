 package com.kike.colegio.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="municipios")
public class MunicipiosEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_municipio")
	private Integer idMunicipio;
	
	@Column(name="id_provincia")
	private Integer idProvincia;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="cod_municipio")
	private String codMunicipio;
	
	@Column(name="DC")
	private String dc;
	
	@OneToMany(mappedBy = "municipio")	
	private List<AlumnoEntity> alumnos ;

	public MunicipiosEntity() {
		super();
	}

	
	public MunicipiosEntity(Integer idMunicipio) {
		super();
		this.idMunicipio = idMunicipio;
	}


	public MunicipiosEntity(Integer idMunicipio, Integer idProvincia, String nombre, String codMunicipio, String dc,
			List<AlumnoEntity> alumnos) {
		super();
		this.idMunicipio = idMunicipio;
		this.idProvincia = idProvincia;
		this.nombre = nombre;
		this.codMunicipio = codMunicipio;
		this.dc = dc;
		this.alumnos = alumnos;
	}

	public Integer getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public Integer getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Integer idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodMunicipio() {
		return codMunicipio;
	}

	public void setCodMunicipio(String codMunicipio) {
		this.codMunicipio = codMunicipio;
	}

	public String getDc() {
		return dc;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}

	public List<AlumnoEntity> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<AlumnoEntity> alumnos) {
		this.alumnos = alumnos;
	}
	
	
}
