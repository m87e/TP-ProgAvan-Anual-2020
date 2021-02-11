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
import edu.usal.view.VuelosView;

public class VueloController_GUI {

	private VuelosView viewGUI;
	private VuelosAltaView viewAlta;
	private VueloManager manager = new VueloManager();
	private AeropuertoDAO aeropuertoDAODatabase = AeropuertoFactory.GetImplementation("database");
	private AerolineaDAO aerolineaDAODatabase = AerolineaFactory.GetImplementation("database");

	public VueloController_GUI(VuelosView viewGUI) {
		this.viewGUI = viewGUI;
	}

	public VueloController_GUI() {

	}

	public void AltaVuelo(Vuelo vuelo) {
		this.manager.AltaVuelo(vuelo);
	}

	public void ModificarVuelo(Vuelo vuelo) {
		this.manager.ModificacionVuelo(vuelo);
	}

	public void BajaVuelo(Vuelo vuelo) {
		this.manager.BajaVuelo(vuelo);
	}

	public List<Vuelo> MostrarTodo() {
		List<Vuelo> listadoVuelos = new ArrayList();
		listadoVuelos = this.manager.MostrarVuelos();

		return listadoVuelos;
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

	public Vuelo BuscarVueloID(int id) {
		return this.manager.BuscarVueloID(id);
	}
}
