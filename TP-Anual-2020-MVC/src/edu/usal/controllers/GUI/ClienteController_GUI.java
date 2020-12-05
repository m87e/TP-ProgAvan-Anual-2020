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
import edu.usal.tp.negocio.dao.dominio.Pais;
import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.dominio.Provincia;
import edu.usal.tp.negocio.dao.dominio.Telefono;
import edu.usal.tp.negocio.dao.factory.ClienteFactory;
import edu.usal.tp.negocio.dao.factory.PaisFactory;
import edu.usal.tp.negocio.dao.factory.ProvinciaFactory;
import edu.usal.tp.negocio.dao.implementaciones.ClienteDAOImplDatabase;
import edu.usal.tp.negocio.dao.implementaciones.PaisesDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.ClienteDAO;
import edu.usal.tp.negocio.dao.interfaces.PaisesDAO;
import edu.usal.tp.negocio.dao.interfaces.ProvinciasDAO;
import edu.usal.view.ClientesABM_view;
import edu.usal.view.ClientesAlta_view;
import edu.usal.view.ClientesView;

public class ClienteController_GUI {

	private ClientesABM_view viewGUI;
	private ClientesView clientesView;
	private ClienteManager manager = new ClienteManager();
	private ClienteDAO clienteDAODatabase = ClienteFactory.GetImplementation("database");
	private PaisesDAO paisesDAODatabase = PaisFactory.GetImplementation("database");
	private ProvinciasDAO provinciasDAODatabase = ProvinciaFactory.GetImplementation("database");
	
	public ClienteController_GUI(ClientesABM_view viewGUI) {
		this.viewGUI = viewGUI;
	}

	public ClienteController_GUI(ClientesView clientesView) {
		this.clientesView = clientesView;
	}

	public ClienteController_GUI() {

	}

	public void altaCliente() throws ParseException {
		Cliente c = this.viewGUI.cargarCliente();
		Pasaporte p = this.viewGUI.cargarPasaporte();
		Telefono tel = this.viewGUI.cargarTelefono();
		DireccionCompleta dir = this.viewGUI.cargarDirCompleta();
		PasajeroFrecuente pasFrec = this.viewGUI.cargarPasFrecuente();

		this.manager.AltaCliente(c, p, tel, dir, pasFrec);
	}

	public void modificarCliente(int cliID, Cliente cli) throws ParseException {
		Cliente c = this.viewGUI.cargarCliente();
		Pasaporte p = this.viewGUI.cargarPasaporte();
		Telefono tel = this.viewGUI.cargarTelefono();
		DireccionCompleta dir = this.viewGUI.cargarDirCompleta();
		PasajeroFrecuente pasFrec = this.viewGUI.cargarPasFrecuente();

		c.setId(cliID);

		dir.setId(cli.getDireccionCompleta().getId());
		p.setId(cli.getPasaporte().getId());
		tel.setId(cli.getTelefono().getId());
		pasFrec.setId(cli.getPasajeroFrecuente().getId());

		System.out.println(c.getApellido());
		System.out.println(c.getDni());
		System.out.println(dir.getId());
		System.out.println(dir.getAltura());
		this.manager.ModificacionCliente(c, p, tel, dir, pasFrec);
	}

	public void bajaCliente(Cliente cli) {
		this.manager.BajaCliente(cli);
	}

	public Cliente mostrarClientePorDni(String dni) {
		Cliente cli = new Cliente();
		
		try {
			cli = this.clienteDAODatabase.ObtenerClientePorDNI(dni);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cli;
	}

	public List<Cliente> mostrarTodo() {
		List<Cliente> listadoClientes = new ArrayList();
		listadoClientes = this.manager.MostrarClientes();

		return listadoClientes;
	}
	
	public List<Pais> mostrarPaises(){
		
		List<Pais> listadoPaises = new ArrayList();
		try {
			listadoPaises = paisesDAODatabase.GetAll();
		} catch (IOException e) {
			System.out.println("Pais no encontrado");
		}
		
		return listadoPaises;
	}
	
	public List<Provincia> mostrarProvincias(){
		
		List<Provincia> listadoProvincias = new ArrayList();
		try {
			listadoProvincias = provinciasDAODatabase.GetAll();
		} catch (IOException e) {
			System.out.println("Pais no encontrado");
		}
		
		return listadoProvincias;
	}
}
