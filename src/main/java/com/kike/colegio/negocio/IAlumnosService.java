package com.kike.colegio.negocio;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.kike.colegio.dtos.AlumnoDTO;

public interface IAlumnosService {
	
	public List<AlumnoDTO> obtenerTodosAlummnos() throws ClassNotFoundException, SQLException, NamingException;
	
	public List<AlumnoDTO> buscarAlumnos(String id, String nombre, String apellido, String activo, String famNume) throws ClassNotFoundException, SQLException, NamingException;

	public Integer insertarAlumno(String id, String nombre,String apellido, String activo, String famNumerosa, String municipio)throws ClassNotFoundException, SQLException, NamingException;
	
	public Integer actualizarAlumno(String id, String nombre,String apellido, String activo, String famNumerosa, String municipio)throws ClassNotFoundException, SQLException, NamingException;

	public Integer borrarAlumno(String id)throws ClassNotFoundException, SQLException, NamingException;


}
