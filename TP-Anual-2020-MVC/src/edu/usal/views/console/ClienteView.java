package edu.usal.views.console;

import java.util.Date;

import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.DirCompleta;
import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.dominio.Telefono;
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

	public Telefono cargarTelefono() {

		Telefono t = new Telefono();
		t.setNumCelular((IOGeneral.leerLinea("ingrese numero de celular")));
		t.setNumLaboral((IOGeneral.leerLinea("ingrese numero laboral")));
		t.setNumPersonal((IOGeneral.leerLinea("ingrese numero personal")));
		return t;

	}

	public DirCompleta cargarDirCompleta() {

		DirCompleta dir = new DirCompleta();
		return dir;
	}

	public PasajeroFrecuente cargarPasFrecuente() {

		PasajeroFrecuente pas = new PasajeroFrecuente();

		return pas;
	}

}
