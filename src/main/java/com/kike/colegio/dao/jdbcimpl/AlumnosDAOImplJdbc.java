package com.kike.colegio.dao.jdbcimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.kike.colegio.dao.AlumnosDAO;
import com.kike.colegio.dtos.AlumnoDTO;
import com.kike.colegio.utils.DBUtils;

@Component("JDBCImpl")
public class AlumnosDAOImplJdbc implements AlumnosDAO{
	private static final Logger logger = LoggerFactory.getLogger(AlumnosDAOImplJdbc.class) ; 

	@Override
	public List<AlumnoDTO> obtenerTodosAlumnos() throws ClassNotFoundException, SQLException, NamingException {
		ResultSet alumnosResultSet = null;
		List<AlumnoDTO> listaAlumnos = new ArrayList<AlumnoDTO>();
		Connection connection = DBUtils.conectaBBDD();
		
		Statement st = connection.createStatement();
		alumnosResultSet = st.executeQuery("SELECT * FROM alumnos");
		
		while(alumnosResultSet.next()) {
			listaAlumnos.add(new AlumnoDTO(alumnosResultSet.getInt(1), alumnosResultSet.getString(2)));
			logger.info("añadido alumno " + alumnosResultSet.getInt(1)+ " " + alumnosResultSet.getString(2)  );
		}
		
		return listaAlumnos;
	}

	@Override
	public List<AlumnoDTO> buscarAlumnos(String id, String nombre, String apellido, String activo, String famNumerosa) throws ClassNotFoundException, SQLException, NamingException {
		
		String sql = "SELECT a.id, a.nombre, a.apellidos, m.nombre, a.id_municipio, "
					+ "a.familia_numerosa, a.activo "
					+ " FROM alumnos a  "
					+ " INNER JOIN municipios m "
					+ " ON a.id_municipio = m.id_municipio "
					+ " WHERE a.id LIKE ? AND a.nombre LIKE ? AND a.apellidos LIKE ? "
					+ " AND a.activo = ? "
					+ " AND a.familia_numerosa = ? ";
		
		Connection connection = DBUtils.conectaBBDD();
		List<AlumnoDTO> listaAlumnos = new ArrayList<>();
		
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, "%" + id + "%");
		ps.setString(2, "%" + nombre + "%");
		ps.setString(3, "%" + apellido + "%");
		ps.setString(4, activo );
		ps.setString(5, famNumerosa );

		ResultSet rs  = ps.executeQuery();
	
		while (rs.next()) {
			listaAlumnos.add(new AlumnoDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7)));
		}
		connection.close();
		return listaAlumnos;
		
		
	}

	@Override
	public Integer insertarAlumno(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipio) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "INSERT INTO alumnos (id, nombre, apellidos, id_municipio, familia_numerosa, activo) "
					+ "  VALUES (?, ?, ?, ?, ?, ?)";
		
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, id);
		ps.setString(2, nombre);
		ps.setString(3, apellido);
		ps.setString(4, municipio);
		ps.setString(5, famNumerosa);
		ps.setString(6, activo);
		
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	@Override
	public Integer actualizarAlumno(String id, String nombre, String apellido, String activo, String famNumerosa,
			String municipio) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "UPDATE alumnos set nombre = ?, apellidos = ?, activo = ?, familia_numerosa = ? , id_municipio = ? "
					+ "WHERE id = ? ";
		
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		

		ps.setString(1, nombre);
		ps.setString(2, apellido);
		ps.setString(3, activo);
		ps.setString(4, famNumerosa);
		ps.setString(5, municipio);
		ps.setString(6, id);
		
		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

	@Override
	public Integer borrarAlumno(String id) throws ClassNotFoundException, SQLException, NamingException {
		String sql = "UPDATE alumnos SET activo = 0 "
				+ "WHERE id = ? ";
		Connection connection = DBUtils.conectaBBDD();
		PreparedStatement ps = connection.prepareStatement(sql);
		
		ps.setString(1, id);

		Integer resultado = ps.executeUpdate();
		connection.close();
		return resultado;
	}

}
