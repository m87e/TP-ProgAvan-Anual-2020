package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.VentaDAOImplArchivo;
import edu.usal.tp.negocio.dao.implementaciones.VentaDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.VentaDAO;

public class VentasFactory {
	public static VentaDAO GetImplementation(String source) {
		if (source.equals("Archivo")) {
			return new VentaDAOImplArchivo();
		}
		if (source.equals("database")) {
			return new VentaDAOImplDatabase();
		}

		return null;

	}
}
