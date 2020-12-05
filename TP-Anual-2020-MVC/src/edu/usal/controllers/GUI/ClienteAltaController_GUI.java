package edu.usal.controllers.GUI;

import java.io.IOException;import java.security.AlgorithmConstraints;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Alianza;
import edu.usal.tp.negocio.dao.dominio.Pais;
import edu.usal.tp.negocio.dao.dominio.Provincia;
import edu.usal.tp.negocio.dao.factory.AerolineaFactory;
import edu.usal.tp.negocio.dao.factory.PaisFactory;
import edu.usal.tp.negocio.dao.factory.ProvinciaFactory;
import edu.usal.tp.negocio.dao.implementaciones.ProvinciasDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.tp.negocio.dao.interfaces.PaisesDAO;
import edu.usal.tp.negocio.dao.interfaces.ProvinciasDAO;
import edu.usal.view.ClientesAlta_view;

public class ClienteAltaController_GUI {
	private ClientesAlta_view clientesAlta_view;
	private PaisesDAO paisesDAODatabase = PaisFactory.GetImplementation("database");
	private ProvinciasDAO provinciasDAODatabase = ProvinciaFactory.GetImplementation("database");
	private AerolineaDAO aerolineaDAODatabase = AerolineaFactory.GetImplementation("database");
	
	public ClienteAltaController_GUI() {}
	
	public ClienteAltaController_GUI(ClientesAlta_view clientesAlta_view) {
		this.clientesAlta_view = clientesAlta_view;
	}

	public void altaCliente() throws ParseException {

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
