package edu.usal.controllers.GUI;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.managers.ClienteManager;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.DireccionCompleta;
import edu.usal.tp.negocio.dao.dominio.Pais;
import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;
import edu.usal.tp.negocio.dao.dominio.Pasaporte;
import edu.usal.tp.negocio.dao.dominio.Provincia;
import edu.usal.tp.negocio.dao.dominio.Telefono;
import edu.usal.tp.negocio.dao.factory.AerolineaFactory;
import edu.usal.tp.negocio.dao.factory.PaisFactory;
import edu.usal.tp.negocio.dao.factory.ProvinciaFactory;
import edu.usal.tp.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.tp.negocio.dao.interfaces.PaisesDAO;
import edu.usal.tp.negocio.dao.interfaces.ProvinciasDAO;
import edu.usal.view.ClienteModificar_view;
import edu.usal.view.ClientesView;

public class ClienteModificarController_GUI {
	private ClienteModificar_view clienteModificarView;
	private ClienteManager manager = new ClienteManager();
	
	private PaisesDAO paisesDAODatabase = PaisFactory.GetImplementation("database");
	private ProvinciasDAO provinciasDAODatabase = ProvinciaFactory.GetImplementation("database");
	private AerolineaDAO aerolineaDAODatabase = AerolineaFactory.GetImplementation("database");
	
	
	public ClienteModificarController_GUI() {}
	
	public ClienteModificarController_GUI(ClienteModificar_view clienteModificar_view) {
		this.clienteModificarView = clienteModificar_view;
	}

	public void modificarCliente(Cliente c, Pasaporte p, Telefono tel, DireccionCompleta dir, PasajeroFrecuente pasFrec) throws ParseException {
		this.manager.ModificacionCliente(c, p, tel, dir, pasFrec);
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
		List<Provincia> listadoProvincia = new ArrayList();
			try {
				listadoProvincia = provinciasDAODatabase.GetAll();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Pronvincia no encontrada");
			}
			return listadoProvincia;
	}
	
	public List<Aerolinea> mostrarAerolinea(){
		List<Aerolinea> listadoAerolinea = new ArrayList();
		
		try {
			listadoAerolinea = aerolineaDAODatabase.GetAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Aerolinea no encontrada");
		}
		
		return listadoAerolinea;
	}
}
