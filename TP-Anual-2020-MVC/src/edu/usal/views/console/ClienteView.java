package edu.usal.views.console;

import java.util.Date;

import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.util.IOGeneral;

public class ClienteView {

	public int mostrarMenu() {
		System.out.println("1 - Alta cliente");
		return IOGeneral.leerInt("Seleccione opci�n: ", "Debe de ingresar un numero");

	}

	public Cliente cargarCliente() {

		Cliente c = new Cliente();

		c.setNombre(IOGeneral.leerLinea("Ingrese nombre: "));
		c.setApellido(IOGeneral.leerLinea("Ingrese apellido: "));
		c.setDni(IOGeneral.leerLinea("Ingrese dni: "));
		c.setCuit(IOGeneral.leerLinea("Ingrese cuit: "));
		c.setEmail(IOGeneral.leerLinea("Ingrese email: "));
		return c;

	}

	public Pasaporte cargarPasaporte() {

		// Pasaporte pas = new Pasaporte(1, "AAA333444", p, "Consulado", d, d);

		Pasaporte pas = new Pasaporte();
		// pas.setNumeroPasaporte(IOGeneral.leerLinea("ingrese numero de pasaporte"));
		// pas.setPais(pais);??
		return pas;

	}

	public int obtenerTelefono() {

		int id = IOGeneral.leerInt(("Ingrese id de telefono: "), "dato invalido");
		return id;

	}

	public int obtenerDir() {

		int id = IOGeneral.leerInt(("Ingrese id de direccion: "), "dato invalido");
		return id;
	}

}
