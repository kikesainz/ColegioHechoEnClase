package com.kike.colegio.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.AlumnosDAO;
import com.kike.colegio.dao.jdbcimpl.AlumnosDAOImplJdbc;
import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.negocio.IAlumnosService;

@Component
public class AlumnosService implements IAlumnosService{
	
	@Autowired
	@Qualifier("AlumnosDAOImplSpringDataJPA")
	AlumnosDAO alumnosDAO;

	@Override
	public List<AlumnoDTO> obtenerTodosAlummnos() throws ClassNotFoundException, SQLException, NamingException {
		return alumnosDAO.obtenerTodosAlumnos();
	}

	@Override
	public List<AlumnoDTO> buscarAlumnos(String id, String nombre, String apellido, String activo, String famNumerosa)
			throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return alumnosDAO.buscarAlumnos(id, nombre, apellido, activo, famNumerosa);
	}

	@Override
	public Integer insertarAlumno(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipio) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return alumnosDAO.insertarAlumno(id, nombre, apellido, activo, famNumerosa, municipio);
	}

	@Override
	public Integer actualizarAlumno(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipio) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return  alumnosDAO.actualizarAlumno(id, nombre, apellido, activo, famNumerosa, municipio);
	}

	@Override
	public Integer borrarAlumno(String id) throws ClassNotFoundException, SQLException, NamingException {
		// TODO Auto-generated method stub
		return alumnosDAO.borrarAlumno(id);
	}

}
