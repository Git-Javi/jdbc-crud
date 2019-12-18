package com.jdbc.mantenimiento.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {

	private static Connection conexion = null;

	private ConexionMySQL() {}
	
	public static Connection getConexion() {
		if (conexion == null) {
			String url = "jdbc:mysql://localhost/BDAlumnos";
			String user = "mantenimiento";
			String password = "1234";
			try {
				conexion = DriverManager.getConnection(url, user, password);
				System.out.println("Conexión establecida.");
			} catch (SQLException sqlex) {
				System.err.println("No se ha podido conectar con la BD. " + sqlex.getMessage());
			}
		}
		return conexion;
	}

	public static void closeConexion() {
		try {
			conexion.close();
			System.out.println("Conexión cerrada.");
		} catch (SQLException sqlex) {
			System.err.println("No se ha podido cerrar con la BD. " + sqlex.getMessage());
		}
		conexion = null;
	}
}