package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.VentaDAOImplArchivo;
import edu.usal.tp.negocio.dao.implementaciones.VentaDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.IVentaDAO;

public class VentasFactory {
	public static IVentaDAO GetImplementation(String source) {
		if (source.equals("Archivo")) {
			return new VentaDAOImplArchivo();
		}
		if (source.equals("database")) {
			return new VentaDAOImplDatabase();
		}

		return null;

	}
}
