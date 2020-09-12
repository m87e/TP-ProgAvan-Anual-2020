package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.DirCompletaDAOImpArchivo;
import edu.usal.tp.negocio.dao.implementaciones.DirCompletaDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.IDirCompletaDAO;

public class DirCompletaFactory {

	public static IDirCompletaDAO GetImplementation(String source) {
		if (source.equals("Archivo")) {
			return new DirCompletaDAOImpArchivo();
		}
		if (source.equals("database")) {
			return new DirCompletaDAOImplDatabase();
		}

		return null;

	}
}
