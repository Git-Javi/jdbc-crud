package com.jdbc.mantenimiento.dao;

import java.util.ArrayList;

import com.jdbc.mantenimiento.entidad.Alumno;

public class FileAlumnoDao implements Dao<Alumno> {

	@Override
	public void create(Alumno t) {
		// TODO Auto-generated method stub
	}

	@Override
	public Alumno read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Alumno t) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<Alumno> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno createAndRead(Alumno t) {
		System.out.println("Holiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii, voy a guardar este alumno en un fichero: "+t);
		return null;
	}

	@Override
	public Alumno updateAndRead(Alumno t) {
		// TODO Auto-generated method stub
		return null;
	}

}
