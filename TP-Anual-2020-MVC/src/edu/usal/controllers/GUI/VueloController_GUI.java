package edu.usal.controllers.GUI;

import java.util.ArrayList;
import java.util.List;

import edu.usal.managers.VueloManager;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import edu.usal.view.VuelosAltaView;
import edu.usal.view.VuelosView;

public class VueloController_GUI {

	private VuelosView viewGUI;
	private VuelosAltaView viewAlta;
	private VueloManager manager = new VueloManager();

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

	public Vuelo BuscarVueloID(int id) {
		return this.manager.BuscarVueloID(id);
	}
}
