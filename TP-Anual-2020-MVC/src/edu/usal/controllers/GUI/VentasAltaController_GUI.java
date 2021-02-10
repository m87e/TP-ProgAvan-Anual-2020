package edu.usal.controllers.GUI;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.usal.managers.VentaManager;
import edu.usal.tp.negocio.dao.dominio.Aerolinea;
import edu.usal.tp.negocio.dao.dominio.Cliente;
import edu.usal.tp.negocio.dao.dominio.Venta;
import edu.usal.tp.negocio.dao.dominio.Vuelo;
import edu.usal.tp.negocio.dao.factory.AerolineaFactory;
import edu.usal.tp.negocio.dao.factory.VueloFactory;
import edu.usal.tp.negocio.dao.interfaces.AerolineaDAO;
import edu.usal.tp.negocio.dao.interfaces.VueloDAO;
import edu.usal.view.VentasAlta_view;

public class VentasAltaController_GUI {
	
	private VentasAlta_view ventasAltaView;
	private VentaManager manager = new VentaManager();
	private VueloDAO vueloDAODatabase = VueloFactory.GetImplementation("database");
	private AerolineaDAO aerolineaDAODatabase = AerolineaFactory.GetImplementation("database");

	public VentasAltaController_GUI() {}
	
	public VentasAltaController_GUI(VentasAlta_view ventasAltaView) {
		this.ventasAltaView = ventasAltaView;
	}
	
	public void altaVenta (Venta vt , Cliente c, Vuelo v , Aerolinea a , LocalDate f , String fP) {
		this.manager.AltaVenta(vt, c, v, a, f, fP);
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
