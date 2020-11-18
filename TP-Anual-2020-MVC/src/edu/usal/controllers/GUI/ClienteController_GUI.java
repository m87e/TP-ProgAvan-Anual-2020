package edu.usal.controllers.GUI;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

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

public class ClienteController_GUI {

	private ClientesABM_view viewGUI;
	private ClienteManager manager = new ClienteManager();
//	private ClienteDAOImplDatabase cliImpl = ClienteFactory.GetImplementation("database");
	//private ClienteDAOImplDatabase clienteDAODatabase;
	private ClienteDAO clienteDAODatabase = ClienteFactory.GetImplementation("database");
	//public ClienteController_GUI() {}
	
	public ClienteController_GUI(ClientesABM_view viewGUI) {
		this.viewGUI = viewGUI;
	}

	public void modificarCliente() throws ParseException {
		Cliente c = this.viewGUI.cargarCliente();
		Pasaporte p = this.viewGUI.cargarPasaporte();
		Telefono tel = this.viewGUI.cargarTelefono();
		DireccionCompleta dir = this.viewGUI.cargarDirCompleta();
		PasajeroFrecuente pasFrec = this.viewGUI.cargarPasFrecuente();
		
		this.manager.ModificacionCliente(c, p, tel, dir, pasFrec);
	}

	private void bajaCliente() {

	}

	public Cliente mostrarClientePorDni(String dni) {
		//dni = dni.substring(dni.indexOf("ID:")+3);
		Cliente cli = new Cliente();
		//cli = this.manager.ObtenerCliente(dni);
		
		try {
			cli = this.clienteDAODatabase.ObtenerClientePorDNI(dni);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cli;
	}

	public DireccionCompleta mostrarDirCompleta (int id) {
		DireccionCompleta dir = new DireccionCompleta();
		
		dir = this.manager.ObtenerDirCompleta(id);
		
		return dir;
	}
	public Telefono mostrarTelefono(int id) {
		Telefono tel = new Telefono();
		
		tel = this.manager.ObtenerTelefono(id);
		System.out.println("controller"+id);
		return tel;
	}
	public Pasaporte mostrarPasaporte (int id) {
		Pasaporte pas = new Pasaporte();
		
		pas = this.manager.ObtenerPasaporte(id);
		
		return pas;
	}
	public PasajeroFrecuente mostrasPasFre (int id) {
		PasajeroFrecuente pasFre = new PasajeroFrecuente();
		
		pasFre = this.manager.ObtenerPasFrecuente(id);
		
		return pasFre;
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
