package com.kike.colegio.dtos;


public class AlumnoDTO  {

	private Integer id;
	private String nombre;
	private String apellido;
	private String municipio;
	private Integer idMunicipio;
	private Integer famNumerosa;
	private Integer activo;
	
	public AlumnoDTO(Integer id, String nombre, String apellido, String municipio, Integer idMunicipio,
			Integer famNumerosa, Integer activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.municipio = municipio;
		this.idMunicipio = idMunicipio;
		this.famNumerosa = famNumerosa;
		this.activo = activo;
	}
	
	

	public AlumnoDTO(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Integer getIdMunicipio() {
		return idMunicipio;
	}

	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
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
	
	
	
	
	
	
	
}
