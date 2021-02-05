package edu.usal.controllers.GUI;

import java.util.ArrayList;
import java.util.List;

import edu.usal.events.AerolineaEvents;
import edu.usal.managers.AerolineaManager;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.view.AerolineaAlta_view;
import edu.usal.view.AerolineasABM_View;
import edu.usal.view.AerolineasView;

public class AerolineaController_GUI {

	private AerolineasView viewGUI;
	private AerolineaAlta_view viewAlta;
	private AerolineaManager manager = new AerolineaManager();

	public AerolineaController_GUI(AerolineasView viewGUI) {
		this.viewGUI = viewGUI;
	}

	/*
	  public AerolineaController_GUI(AerolineaAlta_view viewAlta) {
	
		this.viewAlta = viewAlta;
	}
	 */

	public AerolineaController_GUI() {

	}

	public void AltaAerolinea(Aerolinea aerolinea) {

		this.manager.AltaAerolinea(aerolinea);
	}

	public void ModificarAerolinea(Aerolinea aerolinea) {

		this.manager.ModificacionAerolinea(aerolinea);
	}

	public void BajaAerolinea(Aerolinea aerolinea) {

		this.manager.BajaAerolinea(aerolinea);
	}
	
	public List<Aerolinea> MostrarTodo(){
		List<Aerolinea> listadoAerolinea = new ArrayList();
		listadoAerolinea = this.manager.MostrarLineasAereas();
		
		return listadoAerolinea;
	}

}
