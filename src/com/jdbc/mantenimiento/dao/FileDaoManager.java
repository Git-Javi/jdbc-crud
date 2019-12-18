package com.jdbc.mantenimiento.dao;

import com.jdbc.mantenimiento.entidad.Alumno;

public class FileDaoManager implements DaoManager {

	private Dao<Alumno> unAlumno = null;
	
	@Override
	public Dao<Alumno> getAlumnoDAO() {
		if (unAlumno == null) {
			unAlumno = new FileAlumnoDao();
		}
		return unAlumno;
	}

}
