package edu.usal.controllers;

import java.io.IOException;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.managers.ClienteManager;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.DireccionCompleta;
import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.dominio.Telefono;
import edu.usal.tp.negocio.dao.interfaces.ClienteDAO;
import edu.usal.view.ClientesABM_view;
import edu.usal.views.console.ClienteView;

public class ClienteController {

	private ClienteView viewConsola;
	private ClientesABM_view viewGUI;
	
	private ClienteManager manager = new ClienteManager();

	public ClienteController(ClienteView viewConsola) {
		this.viewConsola = viewConsola;
	}

	public void mostrarMenu() throws ClassNotFoundException, IOException, ParseException {
		boolean fin = false;
		while (!fin) {
			int opcion = this.viewConsola.mostrarMenu();
			switch (opcion) {
			case 0:
				System.out.println("Aplicacion cerrada");
				fin = true;
				break;
			case 1:
				this.altaClienteConsola();
				break;
			default:
				System.out.println("Ingrese una opcion valida");
				break;
			}
		}
	}

	private void altaClienteConsola() throws IOException, ParseException {

		Cliente c = this.viewConsola.cargarCliente();
		Pasaporte p = this.viewConsola.cargarPasaporte();
		Telefono tel = this.viewConsola.cargarTelefono();
		DireccionCompleta dir = this.viewConsola.cargarDirCompleta();
		PasajeroFrecuente pasFrec = this.viewConsola.cargarPasFrecuente();

		this.manager.AltaCliente(c, p, tel, dir, pasFrec);
	}

	private void modificarCliente() {

	}

	private void bajaCliente() {

	}

	private void mostrarClientePorDni() {

	}

	private void mostrarClientePorPasaporte() {

	}
	
	//GUI
	
	public ClienteController() {}
	public ClienteController(ClientesABM_view viewGUI) {
		this.viewGUI = viewGUI;
	}
	
	private void altaClienteGUI() {
		
		Cliente c = this.viewGUI.cargarCliente();
		Pasaporte p = this.viewGUI.cargarPasaporte();
		Telefono tel = this.viewGUI.cargarTelefono();
		DireccionCompleta dir = this.viewGUI.cargarDirCompleta();
		PasajeroFrecuente pasFrec = this.viewGUI.cargarPasFrecuente();
	}

}
