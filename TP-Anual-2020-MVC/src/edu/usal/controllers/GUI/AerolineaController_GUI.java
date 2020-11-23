package edu.usal.controllers.GUI;

import edu.usal.events.AerolineaEvents;
import edu.usal.managers.AerolineaManager;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.view.AerolineasABM_View;

public class AerolineaController_GUI {

	private AerolineasABM_View viewGUI;
	private AerolineaEvents events;
	private AerolineaManager manager = new AerolineaManager();

	public AerolineaController_GUI(AerolineasABM_View viewGUI) {
		this.viewGUI = viewGUI;
	}

	public AerolineaController_GUI(AerolineaEvents events) {
		this.events = events;
	}

	public void altaAerolinea() {

		Aerolinea aerolinea = this.viewGUI.CargarAerolinea();
		this.manager.AltaAerolinea(aerolinea);
	}

	public void modificarAerolinea() {

		// Aerolinea aerolinea = this.viewGUI.cargarAerolinea();
		// this.manager.ModificacionAerolinea();
	}

	public void bajaAerolinea() {

		// this.manager.BajaAerolinea();
	}

}
