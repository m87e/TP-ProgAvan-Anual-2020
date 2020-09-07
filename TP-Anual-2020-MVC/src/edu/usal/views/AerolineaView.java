package edu.usal.views;

import edu.usal.util.IOGeneral;

public class AerolineaView {

	public int mostrarMenu() {
		System.out.println("1 - Alta aerolinea");
		return IOGeneral.leerInt("Seleccione opci�n: ", "Debe de ingresar un numero");

	}

}
