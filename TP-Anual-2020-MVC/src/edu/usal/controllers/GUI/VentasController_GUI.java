package edu.usal.controllers.GUI;

import java.util.ArrayList;
import java.util.List;

import edu.usal.managers.VentaManager;
import edu.usal.tp.negocio.dao.dominio.Venta;
import edu.usal.view.VentasView;

public class VentasController_GUI {
	
	private VentasView viewGUI;
	private VentaManager manager = new VentaManager();
	
	public VentasController_GUI (VentasView viewGUI) {
		this.viewGUI = viewGUI;
	}
	
	public VentasController_GUI() {}
	
	public List<Venta> mostrarTodo() {
		List<Venta> listadoVentas = new ArrayList();
		listadoVentas = this.manager.MostrarVentas();
		
		return listadoVentas;
	}

}
