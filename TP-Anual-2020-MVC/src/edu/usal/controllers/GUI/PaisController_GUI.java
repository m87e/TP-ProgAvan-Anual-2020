package edu.usal.controllers.GUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Pais;
import edu.usal.tp.negocio.dao.factory.PaisFactory;
import edu.usal.tp.negocio.dao.implementaciones.PaisesDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.PaisesDAO;

public class PaisController_GUI {
	private PaisesDAO paisesDAODatanase = PaisFactory.GetImplementation("database");
	
	public PaisController_GUI () {}
	
	public List<Pais> mostrarTodo() {
		List<Pais> listadoPaises = new ArrayList();
		try {
			listadoPaises = paisesDAODatanase.GetAll();
		} catch (IOException e) {
			System.out.println("Pais no encontrado");
		}
		
		return listadoPaises;
	}

}
