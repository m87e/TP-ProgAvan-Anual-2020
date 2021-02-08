package edu.usal.controllers.GUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.managers.VueloManager;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Aeropuerto;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import edu.usal.tp.negocio.dao.factory.AerolineaFactory;
import edu.usal.tp.negocio.dao.factory.AeropuertoFactory;
import edu.usal.tp.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.tp.negocio.dao.interfaces.AeropuertoDAO;
import edu.usal.view.VuelosAltaView;

public class VueloAltaController_GUI {

	private VuelosAltaView vuelosAltaView;
	private VueloManager manager = new VueloManager();
	private AerolineaDAO aerolineaDAODatabase = AerolineaFactory.GetImplementation("database");
	private AeropuertoDAO aeropuertoDAODatabase = AeropuertoFactory.GetImplementation("database");
	
	public VueloAltaController_GUI() {

	}

	public VueloAltaController_GUI(VuelosAltaView vuelosAltaView) {
		this.vuelosAltaView = vuelosAltaView;
	}

	public void altaVuelo(Vuelo vuelo) {
		this.manager.AltaVuelo(vuelo);
	}

	public List<Aeropuerto> mostrarAeropuertos() {
		List<Aeropuerto> listadoAeropuertos = new ArrayList();

		try {
			listadoAeropuertos = aeropuertoDAODatabase.GetAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Aeropuerto no encontrada");
		}

		return listadoAeropuertos;
	}

	public List<Aerolinea> mostrarAerolinea() {
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
