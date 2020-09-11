package edu.usal.views.console;

import edu.usal.util.IOGeneral;

public class VentaView {

	public int mostrarMenu() {
		System.out.println("1 - Alta venta");
		return IOGeneral.leerInt("Seleccione opci�n: ", "Debe de ingresar un numero");

	}
}
