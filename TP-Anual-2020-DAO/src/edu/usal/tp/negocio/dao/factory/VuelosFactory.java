package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.VueloDAOImplArchivo;
import edu.usal.tp.negocio.dao.implementaciones.VueloDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.IVuelosDAO;

public class VuelosFactory {
	public static IVuelosDAO GetImplementation(String source) {
		if (source.equals("Archivo")) {
			return new VueloDAOImplArchivo();
		}
		if (source.equals("database")) {
			return new VueloDAOImplDatabase();
		}

		return null;

	}
}
