package edu.usal.controllers.GUI;

import edu.usal.managers.AerolineaManager;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.view.AerolineasView;

public class AerolineaModificarController_GUI {
	private AerolineasView aerolineaView;
	private AerolineaManager manager = new AerolineaManager();
	
	public AerolineaModificarController_GUI(AerolineasView aerolineaView) {
		this.aerolineaView = aerolineaView;
	}
	
	public AerolineaModificarController_GUI() {}
	
	public void modificarAerolinea (Aerolinea a) {
		this.manager.ModificacionAerolinea(a);
	}
	
}
