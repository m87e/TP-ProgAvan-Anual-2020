package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.DirCompletaDAOImpArchivo;
import edu.usal.tp.negocio.dao.interfaces.IDirCompletaDAO;

public class DirCompletaFactory {

	public static IDirCompletaDAO GetImplementatios (String source) {
		if (source.equals("Archivo")) {
			return new DirCompletaDAOImpArchivo();
		}
		
		return null;
		
	}
}
