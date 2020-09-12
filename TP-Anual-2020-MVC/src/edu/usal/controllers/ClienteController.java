package edu.usal.controllers;

import java.io.IOException;
import java.text.ParseException;

import edu.usal.managers.ClienteManager;
import edu.usal.views.console.ClienteView;

public class ClienteController {

	private ClienteView view;
	private ClienteManager manager = new ClienteManager(view);

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
		this.manager.cargarCliente();
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
