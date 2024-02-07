package com.kike.colegio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;

@Embeddable
public class MatriculacionesID {

	@Id
	@Column(name="id_asignatura")
	private Integer idAsignatura;
	
	@Column(name="id_alumno")
	private Integer idAlumno;



	public MatriculacionesID() {
		super();
	}

	
	
	public MatriculacionesID(Integer idAsignatura, Integer idAlumno) {
		super();
		this.idAsignatura = idAsignatura;
		this.idAlumno = idAlumno;
	}



	public Integer getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(Integer idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}
	
	
}
