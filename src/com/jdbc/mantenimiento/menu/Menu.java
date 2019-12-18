package com.jdbc.mantenimiento.menu;

import com.jagasa.mantenimiento.controller.Mantenimiento;
import com.jdbc.mantenimiento.input.Teclado;

public class Menu {
	
	Teclado teclado = new Teclado();
	Mantenimiento mantenimiento = new Mantenimiento();
	char opcion;
	boolean salir = false;

	public void muestraMenu() {

		do {
			System.out.println("\n A. Altas \n C. Consultas \n M. Modificación \n B. Borrar \n L. Listar \n F. Fin \n");
			opcion = teclado.leerString().toLowerCase().charAt(0);
			switch (opcion) {
			case 'a':
				mantenimiento.alta();
				break;
			case 'c':
				mantenimiento.consulta();
				break;
			case 'm':
				mantenimiento.modificacion();
				break;
			case 'b':
				mantenimiento.baja();
				break;
			case 'l':
				mantenimiento.listar();
				break;
			case 'f':
				mantenimiento.fin();
				salir = true;
				System.out.println("\nHasta pronto!");
				break;
			default:
				System.out.println("\nNo has introducida una opción correcta!!\n");
			}
		} while (salir != true);
	}
}


