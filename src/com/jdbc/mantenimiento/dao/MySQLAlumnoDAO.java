package com.jdbc.mantenimiento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.jdbc.mantenimiento.entidad.Alumno;

public class MySQLAlumnoDAO implements Dao<Alumno> {

	final String CREATE = "INSERT INTO alumnos VALUES (?,?,?,?)";
	final String READ = "SELECT * FROM alumnos WHERE numero = ?";
	final String UPDATE = "UPDATE alumnos SET nombre=?, sexo=?, edad=? WHERE numero=?";
	final String DELETE = "DELETE FROM alumnos WHERE numero = ?";
	final String READ_ALL = "SELECT * FROM alumnos";
	
	private Connection cone;

	public MySQLAlumnoDAO(Connection cone) {
		this.cone = cone;
	}

	@Override
	public Alumno create(Alumno unAlumno) {
		Alumno alumnoDevuelto = null;
		if (!alumnoExists(unAlumno.getNumero())) {
			try (PreparedStatement ps = cone.prepareStatement(CREATE)) {
				ps.setInt(1, unAlumno.getNumero());
				ps.setString(2, unAlumno.getNombre());
				ps.setString(3, unAlumno.getSexo());
				ps.setInt(4, unAlumno.getEdad());
				if (ps.executeUpdate() != 1) {
					System.out.println("No se ha podido dar de alta al alumno.");
				} else {
					System.out.println("Alumno registrado correctamente.");
				}
			} catch (SQLException sqlex) {
				System.err.println("No se ha podido dar de alta al alumno. " + sqlex.getMessage());
			}
			alumnoDevuelto = read(unAlumno.getNumero());
		} else {
			System.out.println("Ya existe un alumno con el número " + unAlumno.getNumero() + ".");
		}
		return alumnoDevuelto;
	}

	@Override
	public Alumno read(int id) {
		Alumno alumnoDevuelto = null;
		if (alumnoExists(id)) {
			try (PreparedStatement ps = cone.prepareStatement(READ)) {
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				if (rs.first()) {
					alumnoDevuelto = new Alumno();
					alumnoDevuelto.setNumero(rs.getInt("numero"));
					alumnoDevuelto.setNombre(rs.getString("nombre"));
					alumnoDevuelto.setSexo(rs.getString("sexo"));
					alumnoDevuelto.setEdad(rs.getInt("edad"));
				}
			} catch (SQLException sqlex) {
				System.err.println("No se ha podido verificar la existencia del alumno. " + sqlex.getMessage());
			}
		} else {
			System.out.println("No existe un alumno con el número " + id + ".");
		}
		return alumnoDevuelto;
	}

	@Override
	public Alumno update(Alumno unAlumno) {
		Alumno alumnoDevuelto = new Alumno();
			try(PreparedStatement ps = cone.prepareStatement(UPDATE)){
				ps.setInt(4, unAlumno.getNumero());
				ps.setString(1, unAlumno.getNombre());
				ps.setString(2, unAlumno.getSexo());
				ps.setInt(3, unAlumno.getEdad());
				if (ps.executeUpdate() != 1) {
					System.out.println("No se ha podido modificar al alumno.");
				} else {
					System.out.println("Alumno modificado correctamente.");
				}
			} catch(SQLException sqlex) {
				System.err.println("No se ha podido actualizar los datos del alumno. " + sqlex.getMessage());
			}
			alumnoDevuelto = read(unAlumno.getNumero());
		return alumnoDevuelto;
	}

	@Override
	public void delete(int id) {
		if (alumnoExists(id)) {
			try(PreparedStatement ps = cone.prepareStatement(DELETE)){
				ps.setInt(1, id);
				if (ps.executeUpdate() != 1) {
					System.out.println("No se ha podido borrar el alumno.");
				} else {
					System.out.println("Alumno eliminado correctamente.");
				}
			} catch (SQLException sqlex) {
				System.err.println("No se ha podido borrar al alumno. " +sqlex);
			}
		} else {
			System.out.println("No existe un alumno con el número " + id + ".");
		}
	}

	@Override
	public ArrayList<Alumno> findAll() {
		ArrayList<Alumno> listaAlumnos = new ArrayList<>();
		try (Statement state = cone.createStatement()) {
			ResultSet rs = state.executeQuery(READ_ALL);
			while (rs.next()) {
				listaAlumnos.add(new Alumno(
						rs.getInt("numero"),
						rs.getString("nombre"),
						rs.getString("sexo"),
						rs.getInt("edad"))
				);
			}
		} catch (SQLException sqlex) {
			System.err.println("No se han podido recuperar los alumnos de la tabla. " + sqlex.getMessage());
		}
		return listaAlumnos;
	}

	private boolean alumnoExists(int id) {
		boolean existe = false;
		try (PreparedStatement ps = cone.prepareStatement(READ)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.first()) {
				existe = true;
			}
		} catch (SQLException sqlex) {
			System.err.println("No se ha podido verificar la existencia del alumno. " + sqlex.getMessage());
		}
		return existe;
	}
}
