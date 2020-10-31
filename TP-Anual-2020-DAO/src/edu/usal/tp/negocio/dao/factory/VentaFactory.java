package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.VentaDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.VentaDAO;

public class VentaFactory {
	public static VentaDAO GetImplementation(String source) {

		if (source.equals("database")) {
			return new VentaDAOImplDatabase();
		}

		return null;

	}
}
