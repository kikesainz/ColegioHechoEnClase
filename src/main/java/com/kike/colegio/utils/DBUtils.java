package com.kike.colegio.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtils {

	private static final Logger logger = LoggerFactory.getLogger(DBUtils.class);

	private static SessionFactory sessionFactory; // las variables estáticas son las que pertenecen a la clase y no al
	// objeto.
// Es decir, esta variable es compartida por todos los objetos que
// se creen de esta clase

//Implantamos el patrón singleton, lo cual nos garantiza que solo haya un objeto creado de SessionFactory en nuestra app

	public static SessionFactory creadorSessionFactory() {

		if (sessionFactory == null) {
			try {
				sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			} catch (Throwable ex) {
				System.err.println("Error al crear el objeto SessionFactory" + ex);
				throw new ExceptionInInitializerError(ex);
			}

		}

		return sessionFactory;
	}

	public static Connection conectaBBDD() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String urlDB = "jdbc:mysql://localhost:3306/colegio?serverTimezone=UTC";
		String user = "root";
		String pass = "PracticaRoot";
		Connection connection = DriverManager.getConnection(urlDB, user, pass);
		logger.info("Establecida la conexión a la BBDD");
		return connection;
	}

//	public static Connection conectaBBDD() throws ClassNotFoundException, SQLException, NamingException {
//	
//		Context  ctx = new InitialContext();
//		DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/MyLocalDB");
//		
//		Connection con = ds.getConnection();
//		return con;
//	}
}
