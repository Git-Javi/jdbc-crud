package com.jdbc.mantenimiento.dao;

import java.sql.Connection;

import com.jdbc.mantenimiento.conexion.ConexionMySQL;
import com.jdbc.mantenimiento.entidad.Alumno;

public class MySQLDaoManager implements DaoManager {

	private Connection cone;
	private Dao<Alumno> unAlumno = null;

	public MySQLDaoManager() {
		cone = ConexionMySQL.getConexion();
	}

	@Override
	public Dao<Alumno> getAlumnoDAO() {
		if (unAlumno == null) {
			unAlumno = new MySQLAlumnoDAO(cone);
		}
		return unAlumno;
	}

	// Cuantos métodos de generación de daos de entidad concreta que queramos crear
}
