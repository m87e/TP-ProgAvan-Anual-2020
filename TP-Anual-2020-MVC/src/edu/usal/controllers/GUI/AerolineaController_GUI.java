package edu.usal.controllers.GUI;

import edu.usal.events.AerolineaEvents;
import edu.usal.managers.AerolineaManager;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.view.AerolineaAlta_view;
import edu.usal.view.AerolineasABM_View;

public class AerolineaController_GUI {

	private AerolineasABM_View viewGUI;
	private AerolineaAlta_view viewAlta;
	private AerolineaManager manager = new AerolineaManager();

	public AerolineaController_GUI(AerolineasABM_View viewGUI) {
		this.viewGUI = viewGUI;
	}

	public AerolineaController_GUI(AerolineaAlta_view viewAlta) {
		this.viewAlta = viewAlta;
	}

	public void altaAerolinea() {

		// Aerolinea aerolinea = this.viewAlta.CargarAerolinea();
		// this.manager.AltaAerolinea(aerolinea);
	}

	public void modificarAerolinea() {

		// Aerolinea aerolinea = this.viewGUI.cargarAerolinea();
		// this.manager.ModificacionAerolinea();
	}

	public void bajaAerolinea() {

		// this.manager.BajaAerolinea();
	}

}
