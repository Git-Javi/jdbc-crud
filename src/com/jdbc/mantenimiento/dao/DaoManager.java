package com.jdbc.mantenimiento.dao;

import com.jdbc.mantenimiento.entidad.Alumno;

public interface DaoManager {

	public Dao<Alumno> getAlumnoDAO();
}
