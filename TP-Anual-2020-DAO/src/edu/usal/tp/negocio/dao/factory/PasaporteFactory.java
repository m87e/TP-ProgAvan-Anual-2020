package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.PasaporteDAOImpArchivo;
import edu.usal.tp.negocio.dao.implementaciones.PasaporteDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.PasaporteDAO;

public class PasaporteFactory {
	public static PasaporteDAO GetImplementation(String source) {
		if (source.equals("Archivo")) {
			return new PasaporteDAOImpArchivo();
		}
		if (source.equals("database")) {
			return new PasaporteDAOImplDatabase();
		}

		return null;

	}
}
