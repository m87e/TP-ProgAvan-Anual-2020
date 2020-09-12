package edu.usal.controllers;

import java.io.IOException;
import java.text.ParseException;

import edu.usal.managers.ClienteManager;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.DirCompleta;
import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.dominio.Telefono;
import edu.usal.views.console.ClienteView;

public class ClienteController {

	private ClienteView view;
	private ClienteManager manager = new ClienteManager();

	public ClienteController(ClienteView view) {
		this.view = view;
	}

	public void mostrarMenu() throws ClassNotFoundException, IOException, ParseException {
		boolean fin = false;
		while (!fin) {
			int opcion = this.view.mostrarMenu();
			switch (opcion) {
			case 0:
				System.out.println("Aplicacion cerrada");
				fin = true;
				break;
			case 1:
				this.altaCliente();
				break;
			default:
				System.out.println("Ingrese una opcion valida");
				break;
			}
		}
	}

	private void altaCliente() throws IOException, ParseException {

		Cliente c = this.view.cargarCliente();
		Pasaporte p = this.view.cargarPasaporte();
		Telefono tel = this.view.cargarTelefono();
		DirCompleta dir = this.view.cargarDirCompleta();
		PasajeroFrecuente pasFrec = this.view.cargarPasFrecuente();

		this.manager.cargarCliente(c, p, tel, dir, pasFrec);
	}

	private void modificarCliente() {

	}

	private void bajaCliente() {

	}

	private void mostrarClientePorDni() {

	}

	private void mostrarClientePorPasaporte() {

	}
}
