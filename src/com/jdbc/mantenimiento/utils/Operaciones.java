package com.jdbc.mantenimiento.utils;

import java.util.ArrayList;
import com.jdbc.mantenimiento.entidad.Alumno;
import com.jdbc.mantenimiento.input.Conversor;
import com.jdbc.mantenimiento.input.Teclado;

public class Operaciones {
	
	private static Teclado teclado = new Teclado();
	private static Conversor conversor = new Conversor();

	public static int pideNumero() {
		int numero;
		do {
			System.out.println("Introduce el número:");
			numero = conversor.convierteInt(teclado.leerString());
		} while (numero == Integer.MIN_VALUE || numero < 1);
		return numero;
	}

	public static String pideNombre() {
		String nombre;
		do {
			System.out.println("Introduce el nombre:");
			nombre = teclado.leerString();
		} while (nombre.trim().equals(""));
		return nombre;
	}

	public static String pideSexo() {
		String nombre;
		do {
			System.out.println("Introduce el sexo (H/M):");
			nombre = teclado.leerString().toUpperCase();
		} while (nombre.trim().equals("") || (!nombre.equals("H") && !nombre.equals("M")));
		return nombre;
	}

	public static int pideEdad() {
		int edad;
		do {
			System.out.println("Introduce la edad:");
			edad = conversor.convierteInt(teclado.leerString());
		} while (edad == Integer.MIN_VALUE || edad < 1);
		return edad;
	}

	public static Alumno pideDatosDevuelveAlumno() {
		Alumno unAlumno = new Alumno();
		System.out.println("Introduce los datos del alumno:");
		unAlumno.setNumero(pideNumero());
		unAlumno.setNombre(pideNombre());
		unAlumno.setSexo(pideSexo());
		unAlumno.setEdad(pideEdad());
		return unAlumno;
	}

	public static Alumno modificacionDatosAlumno(Alumno unAlumno) {
		int opcion;

		do {
			System.out.println("Selecciona el campo que deseas modificar:");
			System.out.println("1. Nombre / 2. Sexo / 3. Edad ");
			opcion = conversor.convierteInt(teclado.leerString());
		} while (opcion < 1 || opcion > 3);

		switch (opcion) {
		case 1:
			unAlumno.setNombre(pideNombre());
			return unAlumno;
		case 2:
			unAlumno.setSexo(pideSexo());
			return unAlumno;
		case 3:
			unAlumno.setEdad(pideEdad());
			return unAlumno;
		default:
			return null;
		}
	}

	public static void muestraAlumno(Alumno unAlumno) {
		if (unAlumno != null) {
			System.out.println(unAlumno);
		} else {
			System.out.println("No se ha devuelto ningún registro...");
		}		
	}

	public static void muestraAlumnos(ArrayList<Alumno> alumnos) {
		if (alumnos.size() == 0) {
			System.out.println("No se ha devuelto ningún registro...");
		} else {
			System.out.println("Número de registros: " + alumnos.size());
			for (Alumno a : alumnos) {
				System.out.println(a);
			}
		}
	}

}
