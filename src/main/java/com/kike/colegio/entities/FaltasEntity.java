package com.kike.colegio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "faltas")
public class FaltasEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idfaltas")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "asignatura")
	private AsignaturaEntity asignatura;
	
	@ManyToOne
	@JoinColumn(name = "alumno")
	private AlumnoEntity alumno;
	
	@Column(name="fecha")
	private String fecha;
	
	@Column(name="justificada")
	private Integer justificada;

	public FaltasEntity() {
		super();
	}

	
	public FaltasEntity(AsignaturaEntity asignatura, AlumnoEntity alumno, String fecha,
			Integer justificada) {
		super();
		this.asignatura = asignatura;
		this.alumno = alumno;
		this.fecha = fecha;
		this.justificada = justificada;
	}
	public FaltasEntity(Integer id, AsignaturaEntity asignatura, AlumnoEntity alumno, String fecha,
			Integer justificada) {
		super();
		this.id = id;
		this.asignatura = asignatura;
		this.alumno = alumno;
		this.fecha = fecha;
		this.justificada = justificada;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public AsignaturaEntity getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(AsignaturaEntity asignatura) {
		this.asignatura = asignatura;
	}



	public AlumnoEntity getAlumno() {
		return alumno;
	}



	public void setAlumno(AlumnoEntity alumno) {
		this.alumno = alumno;
	}



	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getJustificada() {
		return justificada;
	}

	public void setJustificada(Integer justificada) {
		this.justificada = justificada;
	}
	
	
	
}
