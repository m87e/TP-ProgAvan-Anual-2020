package edu.usal.views;

import edu.usal.util.IOGeneral;

public class VueloView {

	public int mostrarMenu() {
		System.out.println("1 - Alta vuelo");
		return IOGeneral.leerInt("Seleccione opci�n: ", "Debe de ingresar un numero");

	}
}
