package com.jagasa.mantenimiento.controller;

import java.util.ArrayList;
import com.jdbc.mantenimiento.conexion.ConexionMySQL;
import com.jdbc.mantenimiento.dao.Dao;
import com.jdbc.mantenimiento.dao.DaoManager;
import com.jdbc.mantenimiento.dao.MySQLDaoManager;
import com.jdbc.mantenimiento.entidad.Alumno;
import com.jdbc.mantenimiento.utils.Operaciones;

public class Mantenimiento {

	private DaoManager mySQLDaoManager = new MySQLDaoManager();
	private Dao<Alumno> mySQLAlumnoDAO = mySQLDaoManager.getAlumnoDAO();

	public void alta() {
		Alumno alumnoDevuelto = mySQLAlumnoDAO.create(Operaciones.pideDatosDevuelveAlumno());
		Operaciones.muestraAlumno(alumnoDevuelto);
	}

	public void baja() {
		mySQLAlumnoDAO.delete(Operaciones.pideNumero());
	}

	public void consulta() {
		Alumno alumnoDevuelto = mySQLAlumnoDAO.read(Operaciones.pideNumero());
		Operaciones.muestraAlumno(alumnoDevuelto);
	}

	public void modificacion() {
		Alumno alumnoTmp = mySQLAlumnoDAO.read(Operaciones.pideNumero());
		Operaciones.muestraAlumno(alumnoTmp);
		if (alumnoTmp != null) {
			Alumno alumnoDevuelto = mySQLAlumnoDAO.update(Operaciones.modificacionDatosAlumno(alumnoTmp));
			Operaciones.muestraAlumno(alumnoDevuelto);
		}
	}

	public void listar() {
		ArrayList<Alumno> listaAlumnos = mySQLAlumnoDAO.findAll();
		Operaciones.muestraAlumnos(listaAlumnos);
	}

	public void fin() {
		ConexionMySQL.closeConexion();
	}

}
