package com.jdbc.mantenimiento.entidad;

public class Alumno {

	private int numero;
	private String nombre;
	private String sexo;
	private int edad;

	public Alumno() {}

	public Alumno(int numero, String nombre, String sexo, int edad) {
		this.numero = numero;
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Alumno:  Número: " + numero + " //  Nombre: " + nombre + " // Sexo: " + sexo + " // Edad: " + edad;
	}
}
