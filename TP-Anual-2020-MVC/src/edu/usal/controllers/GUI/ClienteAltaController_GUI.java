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
import edu.usal.view.ClientesAltaView;

public class ClienteAltaController_GUI {
	private ClientesAltaView clientesAltaView;
	private PaisesDAO paisesDAODatabase = PaisFactory.GetImplementation("database");
	private ProvinciasDAO provinciasDAODatabase = ProvinciaFactory.GetImplementation("database");
	private AerolineaDAO aerolineaDAODatabase = AerolineaFactory.GetImplementation("database");
	private ClienteManager manager = new ClienteManager();
	
	public ClienteAltaController_GUI() {}
	
	public ClienteAltaController_GUI(ClientesAltaView clientesAltaView) {
		this.clientesAltaView = clientesAltaView;
	}

	public void altaCliente(Cliente c, Pasaporte p, Telefono tel, DireccionCompleta dir, PasajeroFrecuente pasFrec) throws ParseException {

		this.manager.AltaCliente(c, p, tel, dir, pasFrec);
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
