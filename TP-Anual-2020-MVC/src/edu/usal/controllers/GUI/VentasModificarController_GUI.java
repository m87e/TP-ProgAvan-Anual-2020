package edu.usal.controllers.GUI;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.managers.VentaManager;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Venta;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import edu.usal.tp.negocio.dao.factory.AerolineaFactory;
import edu.usal.tp.negocio.dao.factory.VueloFactory;
import edu.usal.tp.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.tp.negocio.dao.interfaces.VueloDAO;
import edu.usal.view.VentasModificar_view;

public class VentasModificarController_GUI {
	private VentasModificar_view ventasModificarView;
	private VentaManager manager = new VentaManager();
	private VueloDAO vueloDAODatabase = VueloFactory.GetImplementation("database");
	private AerolineaDAO aerolineaDAODatabase = AerolineaFactory.GetImplementation("database");

	
	public VentasModificarController_GUI() {}
	
	public VentasModificarController_GUI(VentasModificar_view ventasModificarView) {
		this.ventasModificarView = ventasModificarView;
	}
	
	public void modificarVenta (Venta v) {
		this.manager.ModificarVenta(v);
	}
	
	public List<Vuelo> mostrarVuelo(){
		List<Vuelo> listadoVuelo = new ArrayList();
		List<Aerolinea> listadoAerolinea = mostrarAerolinea();
			try {
				listadoVuelo = vueloDAODatabase.GetAll();
				for (int i = 0; i < listadoVuelo.size(); i++) {
					for (int j = 0; j < listadoAerolinea.size(); j++) {
						if (listadoVuelo.get(i).getAerolinea().getId()==listadoAerolinea.get(j).getId()) {
							listadoVuelo.get(i).setAerolinea(listadoAerolinea.get(j));
						}
				
				}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Vuelo no encontrada");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println("Vuelo no encontrada");
			}
		return listadoVuelo;
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
