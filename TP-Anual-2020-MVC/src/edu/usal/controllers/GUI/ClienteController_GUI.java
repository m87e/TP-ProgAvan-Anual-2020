package edu.usal.controllers.GUI;

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
import edu.usal.tp.negocio.dao.factory.ClienteFactory;
import edu.usal.tp.negocio.dao.implementaciones.ClienteDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.ClienteDAO;
import edu.usal.view.ClientesABM_view;
import edu.usal.views.console.ClienteView;

public class ClienteController_GUI {

	private ClientesABM_view viewGUI;
	private ClienteManager manager = new ClienteManager();
//	private ClienteDAOImplDatabase cliImpl = ClienteFactory.GetImplementation("database");
	
	public ClienteController_GUI() {}
	
	public ClienteController_GUI(ClientesABM_view viewGUI) {
		this.viewGUI = viewGUI;
	}

	private void modificarCliente() {

	}

	private void bajaCliente() {

	}

	private void mostrarClientePorDni() {

	}

	private void mostrarClientePorPasaporte() {

	}
	
	public void altaCliente() throws ParseException {
		
		Cliente c = this.viewGUI.cargarCliente();
		Pasaporte p = this.viewGUI.cargarPasaporte();
		Telefono tel = this.viewGUI.cargarTelefono();
		DireccionCompleta dir = this.viewGUI.cargarDirCompleta();
		PasajeroFrecuente pasFrec = this.viewGUI.cargarPasFrecuente();
		
		this.manager.AltaCliente(c, p, tel, dir, pasFrec);
	}
	
	public List<Cliente> mostrarTodo() {
		
		List<Cliente> listadoClientes = new ArrayList();
		listadoClientes = this.manager.MostrarClientes();
		
		return listadoClientes;
	}

}
