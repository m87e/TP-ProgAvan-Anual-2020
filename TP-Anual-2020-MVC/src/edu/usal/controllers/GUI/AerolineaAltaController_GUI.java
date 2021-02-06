package edu.usal.controllers.GUI;

import edu.usal.managers.AerolineaManager;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.view.AerolineasView;

public class AerolineaAltaController_GUI {

	private AerolineasView aerolineaView;
	private AerolineaManager manager = new AerolineaManager();
	
	public AerolineaAltaController_GUI(AerolineasView aerolineaView) {
		this.aerolineaView = aerolineaView;
	}
	
	public AerolineaAltaController_GUI () {}
	
	public void altaAerolinea (Aerolinea a) {
		this.manager.AltaAerolinea(a);
	}
	
}
