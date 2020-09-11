package edu.usal.controllers;

import java.io.IOException;
import java.text.ParseException;

import edu.usal.managers.ClienteManager;

public class ClienteController {

	private ClienteManager manager;

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
