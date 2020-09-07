package edu.usal.views;

import java.util.Date;

import edu.usal.util.IOGeneral;

public class ClienteView {

	public int mostrarMenu() {
		System.out.println("1 - Alta cliente");
		return IOGeneral.leerInt("Seleccione opci�n: ", "Debe de ingresar un numero");

	}
	/*
	 * public Cliente cargarCliente() { Cliente c = new Cliente();
	 * 
	 * c.setNombre(IOGeneral.leerLinea("Ingrese nombre: "));
	 * c.setApellido(IOGeneral.leerLinea("Ingrese apellido: "));
	 * c.setDni(IOGeneral.leerLinea("Ingrese dni: "));
	 * c.setCuit(IOGeneral.leerLinea("Ingrese cuit: "));
	 * c.setEmail(IOGeneral.leerLinea("Ingrese email: "));
	 * 
	 * }
	 */
}
